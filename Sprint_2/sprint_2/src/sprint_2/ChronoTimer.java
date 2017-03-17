package sprint_2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ChronoTimer {

	//Queues of Racers
	Queue<Racer> racerQueue1 = new LinkedList<Racer>(); //beginning1
	Queue<Racer> racerQueue2 = new LinkedList<Racer>(); //beginning2
	Queue<Racer> racerRun1 = new LinkedList<Racer>(); //running1
	Queue<Racer> racerRun2 = new LinkedList<Racer>(); //running2
	Queue<Racer> racerFinish = new LinkedList<Racer>(); //done
	
	//Queues for Storing/Printing/Exporting
	ArrayList<String> systemLog = new ArrayList<String>();
//	Queue<String> Export_list = new LinkedList<String>();
	
	ArrayList<Run> runList = new ArrayList<Run>();
	private static int runNum = 0;

	private boolean power = false;
	Time t = new Time(); //time instance to do functions

	private boolean[][] enabled = new boolean[2][4]; //array holding enable for each channel
	private boolean runStarted = false;
	

	public int eventType = 0; //0 is not set, 1 is IND, 2 is PARIND, 3 is ending run
	private int queueNum = 1; //keeps track of which beginning queue to add new racer to

	private int hours = 0;
	private int minutes = 0;
	private double seconds = 0.0;

	public static void main(String args[]){//needs to be verified
		//make sure to print results to console, use Time.computeTime
		Simulator sim = new Simulator();
		ChronoTimer t = new ChronoTimer();

		String command;
		
		do{
			command = sim.getInput();
			if(command == ""){
				break;
			}

			t.sendCommand(command);
		}while(true);
	}

	public boolean getEnabled(int i, int j){ //returns enabled at a given index //used for testing
		return enabled[i][j];
	}

	public void sendCommand(String command){//needs to be finished
		if(command.contains("Power") || command.contains("POWER")){
			power();
			boolean b = isPowerOn();
			if(b == true) System.out.println("Power On");
			else System.out.println("Power Off");

		}
		else if(command.contains("Reset") || command.contains("RESET")){
			reset();
			System.out.println("Reset");
		}
		else if(command.contains("Time") || command.contains("TIME")){
			String[] time = command.split(" ");
			String[] splitTime = time[1].split(":");
			int _hours = Integer.parseInt(splitTime[0]);
			int _minutes = Integer.parseInt(splitTime[1]);
			double _seconds = Double.parseDouble(splitTime[2]);
			setTime(_hours, _minutes,_seconds);
			System.out.println("Time " + _hours + ":" + _minutes + ":" + _seconds);
		}
		else if(command.contains("Event") || command.contains("EVENT")){
			Steven
		}
		else if(command.contains("NewRun") || command.contains("NEWRUN")){
			Steven
		}
		else if(command.contains("Num") || command.contains("NUM")){
			String[] num = command.split(" ");
			int i = Integer.parseInt(num[1]);//this is not good for user input
			addRacer(i);
			System.out.println("Num " + i + " Added");
		}
		else if(command.contains("DNF")){
			dnfRacer();
			System.out.println("DNF");
		}
		else if(command.contains("Cancel") || command.contains("CANCEL")){
			cancelRacer();
			System.out.println("Cancel");
		}
		else if(command.contains("Toggle") || command.contains("TOG")){
			command=command.substring(command.length()-1,command.length());
			int channel=Integer.parseInt(command);
			togChannel(channel);
			System.out.println("Toggle Channel " + channel);
		}
		else if(command.contains("Trigger") || command.contains("TRIG")){
			command=command.substring(command.length()-1,command.length());
			int channel=Integer.parseInt(command);
			boolean b = trigChannel(channel);
			if(b == true) System.out.println("Trigger Channel " + channel + " was successful!");
			else System.out.println("Triggering Channel " + channel + " was not successful.");

		}
		else if(command.contains("Print") || command.contains("PRINT")){
			Steven
		}
		else if(command.contains("Start") || command.contains("START")){
			start();
			System.out.println("Start");
		}
		else if(command.contains("Finish") || command.contains("FINISH")){
			finish();
			System.out.println("Finish");
		}
		else if(command.contains("End") || command.contains("ENDRUN")){
			Steven
		}
		else if(command.contains("Export") || command.contains("EXPORT")){
			Steven
		}
		else if(command.contains("Exit") || command.contains("EXIT")){
			System.out.println("Exit");
			exit();
		}

	}

	public boolean isPowerOn(){
		return power;
	}

	public void power(){
		//if(on) -> turn off //stay in simulator
		//else if(off) -> turn on
		if(power){
			power = false;
		}
		else{
			power = true;
		}
	}

	public void exit(){
		//"quits program" //exit simulator
		if(!isPowerOn()) throw new IllegalStateException();
		System.exit(0);
	}

	public void reset(){
		//sets all variables to initial values
		if(!isPowerOn()) throw new IllegalStateException();

		racerQueue1 = new LinkedList<Racer>();
		racerQueue2 = new LinkedList<Racer>();
		racerRun1 = new LinkedList<Racer>();
		racerRun2 = new LinkedList<Racer>();
		racerFinish = new LinkedList<Racer>();

		systemLog = new ArrayList<String>();
		
		enabled = new boolean[2][4];
		runStarted = false;

		hours = 0;
		minutes = 0;
		seconds = 0.0;

		eventType = 0;
		queueNum = 1;
	}

	public void setTime(int hrs, int min, double sec){
		//allows user to set time
		if(!isPowerOn()) throw new IllegalStateException();

		hours = hrs;
		minutes = min;
		seconds = sec;
		systemLog.add(t.getSystemTime() + " Set Time to: " + hrs + ":" + min + ":" + sec);		
	}

	public void setEventType(String s){
		if(!isPowerOn()) throw new IllegalStateException();

		if(s.equalsIgnoreCase("IND")){
			eventType = 1;
		}
		else if(s.equalsIgnoreCase("PARIND")){
			eventType = 2;
		}
	}
	
	public void newRun(int runNum){
		if(!isPowerOn()) throw new IllegalStateException();
		if(eventType == 0) throw new IllegalStateException();
		if(runStarted == true) throw new IllegalStateException();

		if(runStarted != true){
			runStarted = true;
			systemLog.add(t.getSystemTime() + " New Run Started.");
		}
	}

	public void endRun(){
		if(!isPowerOn()) throw new IllegalStateException();
		if(eventType == 0) throw new IllegalStateException();
		if(runStarted == false) throw new IllegalStateException();
		
		systemLog.add(t.getSystemTime() + " Run Ended.");
		eventType = 3;
		dnfRacer();
		Run r = new Run(runNum, systemLog);
		runList.add(r);
		runNum++;
		reset();
		
	}
	
	public void dnfRacer(){
		//sets end time of next racer to finish to DNF (-1), not return to queue		
		if(!isPowerOn()) throw new IllegalStateException();
		if(eventType == 0) throw new IllegalStateException();
		if(runStarted == false) throw new IllegalStateException();
		
		if(eventType == 1){ //IND 
			Racer r = racerRun1.remove();
			r.setEnd(-1);
			r.setState(2);
			systemLog.add(t.getSystemTime() + " Racer " + r.getNum() + " did not finish.");
			racerFinish.add(r);
		}
		else if(eventType == 2){ //PARIND
			systemLog.add(t.getSystemTime() + " dnfRacer cannot be called on PARIND runs.");
			throw new IllegalArgumentException();
		}
		else if(eventType == 3){ //used when ending run, empties both run queues
			while(!racerRun1.isEmpty()){
				Racer r = racerRun1.remove();
				r.setEnd(-1);
				r.setState(2);
				systemLog.add(t.getSystemTime() + " Racer " + r.getNum() + " did not finish.");
				racerFinish.add(r);
			}
			while(!racerRun2.isEmpty()){
				Racer r = racerRun2.remove();
				r.setEnd(-1);
				r.setState(2);
				systemLog.add(t.getSystemTime() + " Racer " + r.getNum() + " did not finish.");
				racerFinish.add(r);
			}
		}		
	}

	public void cancelRacer(){
		//discard current race for first racer and put back in queue as next to start
		if(!isPowerOn()) throw new IllegalStateException();
		if(eventType == 0) throw new IllegalStateException();
		if(runStarted == false) throw new IllegalStateException();

		if(eventType == 1){ //IND
			Queue<Racer> newQueue = new LinkedList<Racer>();
			Racer r = racerRun1.remove();
			r.setStart(0.0);
			r.setState(0);
			systemLog.add(t.getSystemTime() + " Racer " + r.getNum() + " has been canceled");
			newQueue.add(r);
			while(!racerQueue1.isEmpty()){
				Racer r1 = racerQueue1.remove();
				newQueue.add(r1);
			}
			racerQueue1 = newQueue;
		}
		else if(eventType == 2){//PARIND
			systemLog.add(t.getSystemTime() + " cancelRacer cannot be called on PARIND runs.");
			throw new IllegalArgumentException();
		}
	}

	public void togChannel(int channelNum){
		//enable or disable the channel		
		if(!isPowerOn()) throw new IllegalStateException();
		if(eventType == 0) throw new IllegalStateException();
		if(runStarted == false) throw new IllegalStateException();

		if(eventType == 1 || eventType == 2){ //same thing for IND & PARIND
			if(channelNum % 2 != 0){ //odd
				boolean enable = enabled[0][channelNum/2];
				
				if(enable == false){ //odd & disabled
					enabled[0][channelNum/2] = true;
					systemLog.add(t.getSystemTime() + " Start Channel Num " + channelNum + " has been enabled");
				}
				else if(enable == true){ //odd & enabled
					enabled[0][channelNum/2] = false;
					systemLog.add(t.getSystemTime() + " Start Channel Num " + channelNum + " has been disabled");
				}
			}
			else if(channelNum % 2 == 0){ //even
				boolean enable1 = enabled[1][(channelNum/2)-1];
				
				if(enable1 == false){ //even & disabled
					enabled[1][(channelNum/2)-1] = true;
					systemLog.add(t.getSystemTime() + " End Channel Num " + channelNum + " has been enabled");
				}
				
				else if(enable1 == true){ //even & enabled
					enabled[1][(channelNum/2)-1] = false;
					systemLog.add(t.getSystemTime() + " End Channel Num " + channelNum + " has been disabled");
				}
			}//end else if
		}//end outside if
	}//end method

	public boolean trigChannel(int channelNum){
		//trigger the channel number & pulls racer from queue
		//if odd number, is a start time
		//if even number, is an end time
		if(!isPowerOn()) throw new IllegalStateException();
		if(eventType == 0) throw new IllegalStateException();
		if(runStarted == false) throw new IllegalStateException();

		//IND
		if(eventType == 1){ 
			if(channelNum != 1 && channelNum != 2){
				systemLog.add(t.getSystemTime() + " IND Races only use channels 1 & 2.");
				throw new IllegalArgumentException();
			}
			if(channelNum == 1){ //start
				if(racerQueue1.isEmpty()){
					System.out.println("No Racers in the Queue"); 
					systemLog.add(t.getSystemTime() + " No Racers in the Queue to start race.");
					return false;
				}
				if(enabled[0][0]){
					Racer r = racerQueue1.remove();
					double start = t.start();
					r.setStart(start);
					r.setState(1);
					racerRun1.add(r);
					systemLog.add(t.getSystemTime() + " Racer Num " + r.getNum() + " started racing.");
					return true;
				}
			}
			else if(channelNum == 2){ //end
				if(enabled[1][0]){
					Racer r1 = racerRun1.remove();
					double end = t.end();
					r1.setEnd(end);
					r1.setElapsed(r1.getStart(), end);
					r1.setState(2);
					racerFinish.add(r1);
					systemLog.add(t.getSystemTime() + " Racer Num " + r1.getNum() + " finished racing.");
					return true;
				}
			}
		}//end IND
		
		//PARIND
		else if(eventType == 2){ 
			if(channelNum != 1 && channelNum != 2 && channelNum != 3 && channelNum != 4){
				systemLog.add(t.getSystemTime() + " PARIND Races only use channels 1, 2, 3 and 4.");
				throw new IllegalArgumentException();
			}
			if(channelNum % 2 != 0){ //odd, start
				if(racerQueue1.isEmpty() && racerQueue2.isEmpty()){
					System.out.println("No Racers in either Queue"); 
					systemLog.add(t.getSystemTime() + " No Racers in either Queue to start race.");
					return false;
				}
				if(enabled[0][channelNum/2]){//enabled
					if(channelNum == 1){
						if(racerQueue1.isEmpty()){
							return false;
						}
						Racer r = racerQueue1.remove();
						double start = t.start();
						r.setStart(start);
						r.setState(1);
						racerRun1.add(r);
						systemLog.add(t.getSystemTime() + " Racer Num " + r.getNum() + " started racing.");
						return true;
					}
					else if(channelNum == 3){
						if(racerQueue2.isEmpty()){
							return false;
						}
						Racer r = racerQueue2.remove();
						double start = t.start();
						r.setStart(start);
						r.setState(1);
						racerRun2.add(r);
						systemLog.add(t.getSystemTime() + " Racer Num " + r.getNum() + " started racing.");
						return true;
					}					
				}//end enabled if
			}//end odd channel
			else if(channelNum % 2 == 0){ //even, end
				if(enabled[1][(channelNum/2)-1]){ //enabled
					if(channelNum == 2){
						Racer r1 = racerRun1.remove();
						double end = t.end();
						r1.setEnd(end);
						r1.setState(2);
						r1.setElapsed(r1.getStart(), end);
						racerFinish.add(r1);
						systemLog.add(t.getSystemTime() + " Racer Num " + r1.getNum() + " finished racing.");
						return true;
					}
					else if(channelNum == 4){
						Racer r1 = racerRun2.remove();
						double end = t.end();
						r1.setEnd(end);
						r1.setState(2);
						r1.setElapsed(r1.getStart(), end);
						racerFinish.add(r1);
						systemLog.add(t.getSystemTime() + " Racer Num " + r1.getNum() + " finished racing.");
						return true;
					}
				}//end enabled if
			}//end even channel
		}//end PARIND
		systemLog.add(t.getSystemTime() + " Channel called is not Enabled.");
		return false;
	}

	public boolean start(){
		//triggers channel 1
		if(!isPowerOn()) throw new IllegalStateException();
		if(eventType == 0) throw new IllegalStateException();
		if(runStarted == false) throw new IllegalStateException();

		return trigChannel(1);
	}

	public boolean finish(){
		//triggers channel 2
		if(!isPowerOn()) throw new IllegalStateException();
		if(eventType == 0) throw new IllegalStateException();
		if(runStarted == false) throw new IllegalStateException();

		return trigChannel(2);
	}

	public void addRacer(int racerNum){ //num
		//adds racer to queue
		if(!isPowerOn()) throw new IllegalStateException();
		if(eventType == 0) throw new IllegalStateException();
		if(runStarted == false) throw new IllegalStateException();

		Racer r = new Racer(racerNum, 0.0, 0.0, "0", 0);
		if(eventType == 1){ //IND, just add
			racerQueue1.add(r);
			systemLog.add(t.getSystemTime() + " Racer Num " + racerNum + " has been added to IND event.");
		}
		else if(eventType == 2){ //PARIND add to one queue, then the other, etc.
			if(queueNum == 1){
				racerQueue1.add(r);
				queueNum = 2;
				systemLog.add(t.getSystemTime() + " Racer Num" + racerNum + " has been added to PARIND event.");
			}
			else if(queueNum == 2){
				racerQueue2.add(r);
				queueNum = 1;
				systemLog.add(t.getSystemTime() + " Racer Num" + racerNum + " has been added to PARIND event.");
			}
		}		
	}
	
	/// NEEDS TO BE CHANGES TO EXPORT RIGHT NOW WILL JUST PRINT QUEUE WILL ALWAYS WORK JUST ADJUST FOR JSON
	
	public void store(String racer_name, String occurance, String time)
	{
//		if(Export_list.isEmpty())
//		{
//			while(!systemLog.isEmpty())
//			{
//				String e = systemLog.poll();
//				System.out.print(e);
//				System.out.println();
//				Export_list.add(e);
//			}
//			
//		}
//		else
//		{
//			while(!Export_list.isEmpty())
//			{
//				String e = Export_list.poll();
//				System.out.print(e);
//				System.out.println();
//				systemLog.add(e);
//			}
//		}
			
	}
	///Please Check this method and the stuff that comes in, pretty sure it works but you need to check it 
	/// this was the simplest way to do it I think

	public void export(int rNum)
	{
		if(rNum > runList.size()){
			System.out.println("Error: not a valid run number");
		}
		else{
			Run r = runList.get(rNum-1);
			try {
				r.export();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void print(int rNum)
	{
		if(rNum > runList.size()){
			System.out.println("Error: not a valid run number");
		}
		else{
			Run r = runList.get(rNum-1);
			r.print();
		}
//		if(systemLog.isEmpty())
//		{
//			while(!Export_list.isEmpty())
//			{
//				String e = Export_list.poll();
//				System.out.print(e);
//				System.out.println();
//				systemLog.add(e);
//			}
//		}
//		else
//		{
//			while(!systemLog.isEmpty())
//			{
//				String e = systemLog.poll();
//				System.out.print(e);
//				System.out.println();
//				Export_list.add(e);
//			}
//		}
	}
}//end ChronoTimer
