import java.util.ArrayList;

import com.google.gson.Gson;

public class Run {
	private Gson g = new Gson();
	private ArrayList<Racer> racers = new ArrayList<Racer>();
	private String stuff =  "";
	
	public boolean add(String firstName, String lastName, String time, String runnerNum){
		Racer r=new Racer(firstName,lastName,runnerNum,time);
		racers.add(r);
		System.out.println("Added Runner");
		return true;
	}

	public ArrayList<Racer> getArraylist()
	{
		return racers;	
	}
	
	public String print(){
		//print things
		String s = "";
		Runner_Comparator rc = new Runner_Comparator();
		racers.sort(rc);
		if(racers != null && !racers.isEmpty()){
			s += "Printing... ";
			for(Racer r: racers) {
				s += "\n" + r.toString();
			}
		}
		else{
			System.out.println("No racers in the Run!");
		}
		return s;
	}
	
	public void clear(){
		racers = new ArrayList<Racer>();
		stuff = g.toJson(racers);
	}
}
