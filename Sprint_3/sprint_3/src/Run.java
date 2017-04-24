import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Queue;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

public class Run {

	private int runNum;
	private ArrayList<String> runLog;
	private Queue<Racer> finish1;
	private Queue<Racer> finish2;

	public Run(int rN, ArrayList<String> rL, Queue<Racer> rF1, Queue<Racer> rF2){
		runNum = rN;
		runLog = rL;
		finish1 = rF1;
		finish2 = rF2;
	}
	
	public int getRunNum(){
		return runNum;
	}
	
	public Queue<Racer> getFinish1(){
		return finish1;
	}
	
	public Queue<Racer> getFinish2(){
		return finish2;
	}
	
	public boolean setRacerNum(int index, int racerNum){
		if(index < 0 || index > finish1.size()-1){
			System.out.println("Finish1 empty.");
			return false;
		}
		Racer r = finish1.remove();
		r.setNum(racerNum);
		finish2.add(r);
		return true;
	}
	
	public void print(){
		for(int i = 0; i < runLog.size(); i++){
			System.out.println(runLog.get(i));
		}
	}
	public ArrayList<String> guiPrint(){
		return runLog;
	}
	public void export() throws IOException{
		Gson g = new Gson();
		g.toJson(runLog);
		
		try(FileWriter file = new FileWriter("RUN"+runNum+".txt")){
			file.write(g.toString());
			System.out.println("Exported Run " + runNum + " to RUN"+runNum+".txt");
		}
	}
}
