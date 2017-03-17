package sprint_2;

import java.util.ArrayList;

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
}
