package sprint_2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

public class Run {

	private int runNum;
	private ArrayList<String> runLog;

	public Run(int rN, ArrayList<String> rL){
		runNum = rN;
		runLog = rL;		
	}
	
	public void print(){
		for(int i = 0; i < runLog.size(); i++){
			System.out.println(runLog.get(i));
		}
	}
	
	public void export() throws IOException{
		Gson g = new Gson();
		g.toJson(runLog);
		
		try(FileWriter file = new FileWriter("RUN"+runNum+".txt")){
			file.write(g.toString());
			System.out.println("exported Run " + runNum + " to RUN"+runNum+".txt");
		}
	}
}
