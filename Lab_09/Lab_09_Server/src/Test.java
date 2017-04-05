/**
 * Simple HTTP handler for testing ChronoTimer
 */


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class Test {
	static Directory d = new Directory();
    // a shared area where we get the POST data and then use it in the other handler
    static String sharedResponse = "";
    static boolean gotMessageFlag = false;
    
    public static void main(String[] args) throws Exception {
    	
    	
        // set up a simple HTTP server on our local host
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

        // create a context to get the request to display the results
        server.createContext("/displayresults", new DisplayHandler()); //listeners at the ports
        server.createContext("/displayresults", new cssHandler()); //listeners at the ports

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
    		String response = "Begin of response\n";
			Gson g = new Gson();
			// set up the header
            System.out.println(response);
			try {
				if (!sharedResponse.isEmpty()) {
					System.out.println(response);
					ArrayList<Employee> fromJson = g.fromJson(sharedResponse,
							new TypeToken<Collection<Employee>>() {
							}.getType());

					System.out.println(response);
					response += "Before sort\n";
					for (Employee e : fromJson) {
						response += e + "\n";
					}
					Collections.sort(fromJson);
					response += "\nAfter sort\n";
					for (Employee e : fromJson) {
						response += e + "\n";
					}
				}
			} catch (JsonSyntaxException e) {
				e.printStackTrace();
			}
            response += "End of response\n";
            System.out.println(response);
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
            
            Directory d = new Directory();
			
            // set up the header
            
            ArrayList<Employee> employeeList = new ArrayList<Employee>();
            employeeList = d.getArraylist();
            for(int i = 0; i<employeeList.size() ; i++)
            {
            	
            }
            
            
            System.out.println(response);
			try {
				if (!sharedResponse.isEmpty()) {

					response += "Before sort\n";
					for (Employee e : fromJson) {
						response += e + "\n";
					}
					Collections.sort(fromJson);
					response += "\nAfter sort\n";
					for (Employee e : fromJson) {
						response += e + "\n";
					}
				}
			} catch (JsonSyntaxException e) {
				e.printStackTrace();
			}
            response += "End of response\n";
            System.out.println(response);
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
            		d.add(s3[3], s3[7], s3[11], s3[15], s3[19], s3[23]);
//	            	System.out.println(s3[3] + s3[7] + s3[11] + s3[15] + s3[19] + s3[23]);
            		pr2 = "Added " + s3[3] + " " + s3[7] + " to Directory.";
            	}
            }
            else if(s2.equalsIgnoreCase("Clear")){
            	d.clear();
            	pr2 = "Cleared Directory.";
            }
            else if(s2.equalsIgnoreCase("Print")){
            	pr2 = d.print();
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