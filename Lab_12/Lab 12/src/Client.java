//import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.URL;
import com.google.gson.Gson;

public class Client {
	 
	public void sendData(Racer r, String command) {
		String content = getJSON(r, command);
		try {
			// Client will connect to this location
			URL site = new URL("localhost:8000/sendresults");
			HttpURLConnection conn = (HttpURLConnection) site.openConnection();

			// now create a POST request
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			DataOutputStream out = new DataOutputStream(conn.getOutputStream());

			// write out string to output buffer for message
			out.writeBytes(content);
			out.flush();
			out.close();

			System.out.println("Done sent to server");

			InputStreamReader inputStr = new InputStreamReader(conn.getInputStream());

			// string to hold the result of reading in the response
			StringBuilder sb = new StringBuilder();

			// read the characters from the request byte by byte and build up
			// the Response
			int nextChar;
			while ((nextChar = inputStr.read()) > -1) {
				sb = sb.append((char) nextChar);
			}
			System.out.println("Return String: " + sb);

		} catch (Exception ex) {
			//ex.printStackTrace();
			if(ex instanceof SocketException){
				System.out.println("ERROR: Please fill all of the fields! "
						+ "and/or Check that there are no spaces after your submissions!");
			}
		}
	}

	private String getJSON(Racer r, String command) {
		if(command.equalsIgnoreCase("Add ")){
			Gson g = new Gson();
			String json = g.toJson(r); 
			return "Add " + json;
		}
		else if(command.equalsIgnoreCase("Clear ")){
			return command;
		}
		else if(command.equalsIgnoreCase("Print ")){
			return command;
		}
		return null;
	}

}
