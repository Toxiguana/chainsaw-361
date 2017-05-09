import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Queue;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class Server {
	static Run r = new Run(0, null, null, null);
	static String sharedResponse = "";
	public void startServer() throws IOException{
		// set up a simple HTTP server on our local host
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

        // create a context to get the request to display the results
        server.createContext("/displayresults/directory", new DisplayHandler()); //listeners at the ports
        server.createContext("/displayresults/css", new cssHandler()); //listeners at the ports

        // create a context to get the request for the POST
        server.createContext("/sendresults", new PostHandler()); //ONLY use this one for Lab 8
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
            response += "<h1>Run Results</h1>\n<table>";
            response += "<tr><th>RunnerNumber</th>\n<th>First Initial</th>\n<th>Last Name</th>";
            response += "<th>Time</th>";
            
            Queue<Racer> finishQ = r.getFinish1();
            ArrayList<Racer> run = new ArrayList<Racer>();
            for(Racer a: finishQ){
            	run.add(a);
            }
            RacerComparator rc = new RacerComparator();
            run.sort(rc);
            for(Racer b : run)
            {
            	response += "<tr>\n<td>" + b.getNum() + "</td>"; 
            	response += "\n<td>" + b.getFirstInitial() + "</td>";
            	response += "\n<td>" + b.getLast() + "</td>"; 
            	response += "\n<td>" + b.getTime() + "</td>";
            	response += "\n</tr>";
            
            }
            
            response += "\n</table>\n</body>\n</html>";
            
//            System.out.println(response);
            
            // write out the response
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    static class PostHandler implements HttpHandler {
        public void handle(HttpExchange transmission) throws IOException {
        	
            //  shared data that is used with other handlers
            sharedResponse = "";

            // set up a stream to read the body of the request
            InputStream inputStr = transmission.getRequestBody();

            // set up a stream to write out the body of the response
            OutputStream outputStream = transmission.getResponseBody();

            // string to hold the result of reading in the request
            StringBuilder sb = new StringBuilder();

            // read the characters from the request byte by byte and build up the sharedResponse
            int nextChar = inputStr.read();
            while (nextChar > -1) {
                sb = sb.append((char)nextChar);
                nextChar = inputStr.read();
            }

            // create our response String to use in other handler
            sharedResponse = sharedResponse + sb.toString();

            System.out.println(sharedResponse);
         
            String[] s1 = sharedResponse.split(" ");
            String s2 = s1[0];
            String pr2 = "";
            
            if(s2.equalsIgnoreCase("Add")){
            	String s = s1[1];
            	String[] s3 = s.split("\"");
            	
            	if(s3[3].equals("")){
            		s2 = "NOT Added";
            		pr2 = "ERROR: Please fill out the fields!";
            	}
            	else{
            		r.add(s3[3], s3[7], s3[11], s3[15]);
//	            	System.out.println(s3[3] + s3[7] + s3[11] + s3[15]);
            		pr2 = "Added " + s3[3] + " " + s3[7] + " to Directory.";
            	}
            }
            else if(s2.equalsIgnoreCase("Clear")){
            	r.clear();
            	pr2 = "Cleared Directory.";
            }
            else if(s2.equalsIgnoreCase("Print")){
            	pr2 = r.print();
            }
            
            // respond to the POST with ROGER
            String postResponse = "ROGER JSON RECEIVED: " + s2 + "\n" + pr2 + "\n";
            
            
            System.out.println("response: " + sharedResponse + "\n");

            //Desktop dt = Desktop.getDesktop();
            //dt.open(new File("raceresults.html"));

            // assume that stuff works all the time
            transmission.sendResponseHeaders(300, postResponse.length());

            // write it and return it
            outputStream.write(postResponse.getBytes());

            outputStream.close();
        }
    }
}
