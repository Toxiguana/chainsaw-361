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
	static Queue<Racer> racerFinish1;
	static Queue<Racer> racerFinish2;
	static ArrayList<Run> runList;
	static ArrayList<Name> nameList = new ArrayList<Name>();
	
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
	
	public Server(Queue<Racer> RACERFINISH1, Queue<Racer> RACERFINISH2, ArrayList<Run> RUNLIST){
		racerFinish1 = RACERFINISH1;
		racerFinish2 = RACERFINISH2;
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
            
//            System.out.println(response);
            
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
            	Queue<Racer> finishQ = r.getFinish2();
            	ArrayList<Racer> run = new ArrayList<Racer>();
            	for(Racer a: finishQ){ //convert Queue to ArrayList, needed for sorting
            		run.add(a);
            	}
            	RacerComparator rc = new RacerComparator();
            	run.sort(rc); //sort racers in a run
            	response += "\n<table>";
                response += "<tr><th>RunnerNumber</th>\n<th>First Initial</th>\n<th>Last Name</th>";
                response += "<th>Time</th>";
            	response += "<h2> Run " + r.getRunNum() + "</h2>";
            	for(Racer b : run) //display a run
            	{
            		String first = "FIRSTNAME";
            		String last = "LASTNAME";
            		try{
            			for(Name n : nameList){
            				if(n.number == b.getNum()){
            					first = n.firstName;
            					last = n.lastName;
            				}
            			}
            		}catch(Exception e){
            			first = "FIRSTNAME";
            			last = "LASTNAME";
            		}
            		response += "<tr>\n<td>" + b.getNum() + "</td>"; 
            		response += "\n<td>" + first + "</td>";
            		response += "\n<td>" + last + "</td>"; 
            		response += "\n<td>" + b.getElapsedTime() + "</td>";
            		response += "\n</tr>";
            		
            		//nameList.get(b.getNum()).lastName
            	}
            }
            //TODO: display racers from racerFinish1 and racerFinish2
            
            
            response += "\n</table>\n</body>\n</html>";
            
//            System.out.println(response);
            
            // write out the response
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

//POST HANDLER.  I DONT THINK WE NEED IT
//could be wrong though
    
//    static class PostHandler implements HttpHandler {
//        public void handle(HttpExchange transmission) throws IOException {
//        	
//            //  shared data that is used with other handlers
//            sharedResponse = "";
//
//            // set up a stream to read the body of the request
//            InputStream inputStr = transmission.getRequestBody();
//
//            // set up a stream to write out the body of the response
//            OutputStream outputStream = transmission.getResponseBody();
//
//            // string to hold the result of reading in the request
//            StringBuilder sb = new StringBuilder();
//
//            // read the characters from the request byte by byte and build up the sharedResponse
//            int nextChar = inputStr.read();
//            while (nextChar > -1) {
//                sb = sb.append((char)nextChar);
//                nextChar = inputStr.read();
//            }
//
//            // create our response String to use in other handler
//            sharedResponse = sharedResponse + sb.toString();
//
//            System.out.println(sharedResponse);
//         
//            String[] s1 = sharedResponse.split(" ");
//            String s2 = s1[0];
//            String pr2 = "";
//            
//            if(s2.equalsIgnoreCase("Add")){
//            	String s = s1[1];
//            	String[] s3 = s.split("\"");
//            	
//            	if(s3[3].equals("")){
//            		s2 = "NOT Added";
//            		pr2 = "ERROR: Please fill out the fields!";
//            	}
//            	else{
//            		r.add(s3[3], s3[7], s3[11], s3[15]);
////	            	System.out.println(s3[3] + s3[7] + s3[11] + s3[15]);
//            		pr2 = "Added " + s3[3] + " " + s3[7] + " to Directory.";
//            	}
//            }
//            else if(s2.equalsIgnoreCase("Clear")){
//            	r.clear();
//            	pr2 = "Cleared Directory.";
//            }
//            else if(s2.equalsIgnoreCase("Print")){
//            	pr2 = r.print();
//            }
//            
//            // respond to the POST with ROGER
//            String postResponse = "ROGER JSON RECEIVED: " + s2 + "\n" + pr2 + "\n";
//            
//            
//            System.out.println("response: " + sharedResponse + "\n");
//
//            //Desktop dt = Desktop.getDesktop();
//            //dt.open(new File("raceresults.html"));
//
//            // assume that stuff works all the time
//            transmission.sendResponseHeaders(300, postResponse.length());
//
//            // write it and return it
//            outputStream.write(postResponse.getBytes());
//
//            outputStream.close();
//        }
//    }
}
