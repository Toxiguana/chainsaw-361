import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Queue;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

public class Run { //used to keep track of a run

	private int runNum;
	private ArrayList<String> runLog;
	private Queue<Racer> finish1; //has placeholder numbers
	private Queue<Racer> finish2; //has real numbers

	public Run(int RUNNUM, ArrayList<String> RUNLOG, Queue<Racer> FINISH1, Queue<Racer> FINISH2){
		runNum = RUNNUM;
		runLog = RUNLOG;
		finish1 = FINISH1;
		finish2 = FINISH2;
	}
	
	//Getters
	public int getRunNum(){
		return runNum;
	}
	
	public ArrayList<String> guiPrint(){ //getRunLog() //prints to GUI
		return runLog;
	}
	
	public Queue<Racer> getFinish1(){
		return finish1;
	}
	
	public Queue<Racer> getFinish2(){
		return finish2;
	}
	
	//Setter
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
	
	public void export() throws IOException{
		Gson g = new Gson();
		String s = "";
		for(int i = 0; i < runLog.size(); i++){
			s += runLog.get(i).toString() + "\n";
		}
		g.toJson(runLog);
		try(FileWriter file = new FileWriter("RUN"+runNum+".txt")){
			file.write(s);
			System.out.println("Exported Run " + runNum + " to RUN"+runNum+".txt");
		}
	}
}
