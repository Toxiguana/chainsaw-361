import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class Server {
	static String sharedResponse = "";
	static ArrayList<Run> runList;
	static ArrayList<Name> nameList = new ArrayList<Name>();
	
	/**
	 * Subclass for storing associating names with racerNumbers
	 */
	class Name{
		int number;
		String firstName;
		String lastName;
		
		public Name(int racerNumber, String fName, String lName){
			number = racerNumber;
			firstName = fName;
			lastName = lName;
		}
	}
	
	/**
	 * server constructor.  Attempts to read and parse a file containing racer numbers and their
	 * associated names
	 * @param RUNLIST : ArrayList containing all previous runs
	 */
	public Server(ArrayList<Run> RUNLIST){
		runList = RUNLIST;
		
		//reads file and puts names and numbers into a linked list
		try(Scanner s = new Scanner(new FileReader("src/names.txt"))){
			String line;
			while(s.hasNextLine()){
				line = s.nextLine();
				String[] parts = line.split(":");
				Name n = new Name(Integer.parseInt(parts[0]), parts[1], parts[2]);
				nameList.add(n);
			}
		} catch (Exception e) {
			System.out.println("Error: bad file format for names.txt");
		}
	}
	
	/**
	 * Method which runs the server
	 * @throws IOException
	 */
	public void startServer() throws IOException{
		
		
		// set up a simple HTTP server on our local host
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

        // create a context to get the request to display the results
        server.createContext("/displayresults/directory", new DisplayHandler()); //listeners at the ports
        server.createContext("/displayresults/css", new cssHandler()); //listeners at the ports

        // create a context to get the request for the POST
//        server.createContext("/sendresults", new PostHandler()); //ONLY use this one for Lab 8
        server.setExecutor(null); // creates a default executor

        // get it going
        System.out.println("Starting Server...");
        server.start(); 
	}
	static class cssHandler implements HttpHandler
    {
    	public void handle(HttpExchange t) throws IOException 
    	{
    		String response = "";
            response += "h1{text-align: center;}\n";
            response += "h2{text-align: center;}\n";
            response += "table {margin-left: auto; margin-right: auto; border: 2px solid black;}\n";
            response += "th, td {border: 2px solid black;}\n";
            response += "tr:nth-child(even){background-color: lightgray;}\n";
            response += "tr {text-align: center;}\n";
            
            // write out the response
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
    	}
    }

    static class DisplayHandler implements HttpHandler {
        public void handle(HttpExchange t) throws IOException {

            String response = "";
            			
            // set up the header
            response += "<!DOCTYPE html>\n<html>\n<head><title>Run</title>";
            response += "<link rel=\"stylesheet\" href=\"/displayresults/css\">\n</head>\n<body>";
            response += "<h1>Run Results</h1>";

            for(Run r : runList){ //traverse runList
            	Queue<Racer> finishQ = r.getFinish2(); //retrieve the finish2 queue from a given run
            	ArrayList<Racer> finishList = new ArrayList<Racer>();  //new ArrayList
            	for(Racer a: finishQ){ //convert Queue to ArrayList so that it can be sorted
            		finishList.add(a);
            	}
            	RacerComparator rc = new RacerComparator(); //new comparator
            	finishList.sort(rc); //sort racers in a run
            	//table headers
            	response += "\n<table>";
                response += "<tr><th>Place</th>\n<th>RunnerNumber</th>\n<th>First Name</th>\n<th>Last Name</th>";
                response += "<th>Time</th>";
            	response += "<h2> Run " + r.getRunNum() + "</h2>";
            	
            	int placeCounter = 0; //used to count places for displaying results in table
            	for(Racer b : finishList) //display all racers in a run
            	{
            		placeCounter++;
            		String first = "FIRSTNAME";
            		String last = "LASTNAME";
            		try{ //try block used to prevent crash as a result of nameList being null due to a bad text file
            			for(Name n : nameList){ //searches nameList for a given racerNumber
            				if(n.number == b.getNum()){
            					first = n.firstName;
            					last = n.lastName;
            				}
            			}
            		}catch(Exception e){
            			first = "FIRSTNAME";
            			last = "LASTNAME";
            		}
            		//displays a racer
            		response += "<tr>\n<td>" + placeCounter + "</td>";
            		response += "\n<td>" + b.getNum() + "</td>"; 
            		response += "\n<td>" + first + "</td>";
            		response += "\n<td>" + last + "</td>"; 
            		response += "\n<td>" + b.getElapsedTime() + "</td>";
            		response += "\n</tr>";
            	}
            }    
            response += "\n</table>\n</body>\n</html>";
            
            // write out the response
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
