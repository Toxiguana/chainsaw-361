package sprint_2;

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

	
	Queue<String> Event_list = new LinkedList<String>();
	Queue<String> Export_list = new LinkedList<String>();
	

	private boolean power = false;
	Time t = new Time(); //time instance to do functions

	private boolean[][] enabled = new boolean[2][4]; //array holding enable for each channel
	private double[][] times = new double[2][4]; //array holding start & end times //used for testing
	private boolean[] available = new boolean[4]; //array holding whether pair of channels is available

	public int runType = 0; //0 is not set, 1 is IND, 2 is PARIND, 3 is ending run
	private int queueNum = 1; //keeps track of which beginning queue to add new racer to
	private int queueRunNum = 1; //keeps track of which running queue to add racer pulled from wait queue to

	private int hours = 0;
	private int minutes = 0;
	private double seconds = 0.0;

	public static void main(String args[]){
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

	public double getTimes(int i, int j){ //returns time at a given index //used for testing
		return times[i][j];
	}

	public boolean getAvailable(int i){ //returns available at a given index //used for testing
		return available[i];
	}

	public void sendCommand(String command){//needs to be finished
		if(command.contains("Power") || command.contains("POWER")){
			power();
			boolean b = isPowerOn();
			if(b == true) System.out.println("Power On");
			else System.out.println("Power Off");

		}
		else if(command.contains("Exit") || command.contains("EXIT")){
			System.out.println("Exit");
			exit();

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
		else if(command.contains("Start") || command.contains("START")){
			start();
			System.out.println("Start");
		}
		else if(command.contains("Finish") || command.contains("FINISH")){
			finish();
			System.out.println("Finish");
		}
		else if(command.contains("Num") || command.contains("NUM")){
			String[] num = command.split(" ");
			int i = Integer.parseInt(num[1]);//this is not good for user input
			addRacer(i);
			System.out.println("Num " + i + " Added");
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
			//STORE
			Event_list.add(t + "Power on");
			
		}
		else{
			power = true;
			for(int i = 0; i < available.length; i++){
				available[i] = true; //setting all available indexes to true cuz start as false
			}
			//STORE
			Event_list.add(t + "Power off");
		}
	}

	public void exit(){
		//"quits program" //exit simulator
		//STORE
		Event_list.add(t + "Exit");
		
		if(!isPowerOn()) throw new IllegalStateException();
		System.exit(0);
		
		

	}

	public void reset(){
		//sets all variables to initial values
		//STORE
		Event_list.add(t + "Reset");

		
		if(!isPowerOn()) throw new IllegalStateException();

		racerQueue1 = new LinkedList<Racer>();
		racerQueue2 = new LinkedList<Racer>();
		racerRun1 = new LinkedList<Racer>();
		racerRun2 = new LinkedList<Racer>();
		racerFinish = new LinkedList<Racer>();

		enabled = new boolean[2][4];
		times = new double[2][4];
		available = new boolean[4];

		hours = 0;
		minutes = 0;
		seconds = 0.0;

		runType = 0;
		queueNum = 1;
		queueRunNum = 1;
	}

	public void setTime(int hrs, int min, double sec){
		//allows user to set time
		//STORE
		Event_list.add(t + "Set Time to: " + hrs + ":" + min + ":" + sec);

		if(!isPowerOn()) throw new IllegalStateException();

		hours = hrs;
		minutes = min;
		seconds = sec;
		
	}

	public void dnfRacer(){
		//sets end time of next racer to finish to DNF (-1), not return to queue
		//STORE
		Event_list.add(t + "Racer" + /*r +*/ " did not finish");

		
		if(!isPowerOn()) throw new IllegalStateException();
		if(runType == 0) throw new IllegalStateException();

		if(runType == 1 || runType == 2){ //IND or PARIND implementation
			Racer r = racerRun1.remove();
			r.setEnd(-1);
			r.setState(2);
			racerFinish.add(r);
		}
		else if(runType == 3){ //used when ending run, empties both run queues
			while(!racerRun1.isEmpty()){
				Racer r = racerRun1.remove();
				r.setEnd(-1);
				r.setState(2);
				racerFinish.add(r);
			}
			while(!racerRun2.isEmpty()){
				Racer r = racerRun2.remove();
				r.setEnd(-1);
				r.setState(2);
				racerFinish.add(r);
			}
		}		
	}

	public void cancelRacer(){
		//discard current race for first racer and put back in queue as next to start
		//STORE
		Event_list.add(t + "Racer has been canceled");

		
		if(!isPowerOn()) throw new IllegalStateException();
		if(runType == 0) throw new IllegalStateException();

		if(runType == 1 || runType == 2){ //does same thing for both IND & PARIND
			Queue<Racer> newQueue = new LinkedList<Racer>();
			Racer r = racerRun1.remove();
			times = new double[2][4]; //will be different for more than one racer
			r.setStart(0.0);
			r.setState(0);
			newQueue.add(r);
			while(!racerQueue1.isEmpty()){
				Racer r1 = racerQueue1.remove();
				newQueue.add(r1);
			}
			racerQueue1 = newQueue;
			available[0] = true;
		}
	}

	public void togChannel(int channelNum){
		//enable or disable the channel
		//STORE
		
		// I do not understand this method well enough to assign it statements
		
		if(!isPowerOn()) throw new IllegalStateException();
		if(runType == 0) throw new IllegalStateException();

		if(runType == 1 || runType == 2){ //same thing for IND & PARIND
			boolean enable = enabled[0][channelNum/2];

			if(channelNum % 2 != 0 && enable == false){ //odd & disabled
				enabled[0][channelNum/2] = true;
			}
			
			else if(channelNum % 2 != 0 && enable == true){ //odd & enabled
				enabled[0][channelNum/2] = false;
			}
			
			else if(channelNum % 2 == 0 && enable == false){ //even & disabled
				enabled[1][(channelNum/2)-1] = true;
			}
			
			else if(channelNum % 2 == 0 && enable == true){ //even & enabled
				enabled[1][(channelNum/2)-1] = false;
			}
			
		}
	}

	public boolean trigChannel(int channelNum){
		//trigger the channel number & pulls racer from queue
		//if odd number, is a start time
		//if even number, is an end time
		if(!isPowerOn()) throw new IllegalStateException();
		if(runType == 0) throw new IllegalStateException();

		if(channelNum % 2 != 0){ //odd, start
			if(racerQueue1.isEmpty() && racerQueue2.isEmpty()){
				//System.out.println("No Racers in the Queue"); 
				
				//STORE

				Event_list.add(t + "Trigger has been activated and is a start time");
				
				return false;
			}

			

			
			if(enabled[0][channelNum/2] && available[channelNum/2]){ //enabled & available
				Racer r = null;
				if(runType == 1){//IND
					if(racerQueue1.isEmpty()){
						return false;
					}
					r = racerQueue1.remove();
					double start = t.start();
					times[0][channelNum/2] = start;
					r.setStart(start);
					r.setState(1);
					racerRun1.add(r);
					available[channelNum/2] = false;
					queueRunNum = 2;
					return true;
				}
				else if(runType == 2){//PARIND
					if(queueRunNum == 1){//switches pulling from between 2 diff queues
						if(racerQueue1.isEmpty()){
							return false;
						}
						r = racerQueue1.remove();
						double start = t.start();
						times[0][channelNum/2] = start;
						r.setStart(start);
						r.setState(1);
						racerRun1.add(r);
						available[channelNum/2] = false;
						queueRunNum = 2;
						return true;
					}
					else if(queueRunNum == 2){
						if(racerQueue2.isEmpty()){
							return false;
						}
						r = racerQueue2.remove();
						double start = t.start();
						times[0][channelNum/2] = start;
						r.setStart(start);
						r.setState(1);
						racerRun2.add(r);
						available[channelNum/2] = false;
						queueRunNum = 1;
						return true;
					}				
				}}

		}
		else if(channelNum % 2 == 0){ //even, end
			if(enabled[1][(channelNum/2)-1] && !available[(channelNum/2)-1]){//enabled & not available
				Racer r1 = racerRun1.remove();
				double end = t.end();
				times[1][(channelNum/2)-1] = end;
				r1.setEnd(end);
				r1.setState(2);
				racerFinish.add(r1);
				available[(channelNum/2)-1] = true;
				
				//STORE

				Event_list.add(t + "Trigger has been activated and is an end time");
				
				return true;
			}
		}
		return false;
	}

	
//	public boolean trigPARINDChannel(int numRacers){ //PARIND
//		boolean b = false;
//		for(int i = 1; i <= numRacers; i++){
//			b = trigChannel(i);
//		}
//		return b;
//	}

	public void start(){
		//triggers channel 1
		if(!isPowerOn()) throw new IllegalStateException();
		if(runType == 0) throw new IllegalStateException();

		trigChannel(1);
	}

	public void finish(){
		//triggers channel 2
		if(!isPowerOn()) throw new IllegalStateException();
		if(runType == 0) throw new IllegalStateException();

		trigChannel(2);
	}

	public void addRacer(int racerNum){ //num
		//adds racer to queue
		if(!isPowerOn()) throw new IllegalStateException();
		if(runType == 0) throw new IllegalStateException();

		Racer r = new Racer(racerNum, 0.0, 0.0, "0", 0);
		if(runType == 1){ //IND, just add
			racerQueue1.add(r);
			//STORE

			Event_list.add(t + "Racer has been added to IND event");
			
		}
		else if(runType == 2){ //PARIND add to one queue, then the other, etc.
			if(queueNum == 1){
				racerQueue1.add(r);
				queueNum = 2;
				
				//STORE

				Event_list.add(t + "Racers have been added to PARIND event");
				
			}
			else if(queueNum == 2){
				racerQueue2.add(r);
				queueNum = 1;
				
				//STORE

				Event_list.add(t + "Racers have been added");
			}
		}		
	}
	
	/// NEEDS TO BE CHANGES TO EXPORT RIGHT NOW WILL JUST PRINT QUEUE WILL ALWAYS WORK JUST ADJUST FOR JSON
	
	public void store(String racer_name, String occurance, String time)
	{
		if(Export_list.isEmpty())
		{
			while(!Event_list.isEmpty())
			{
				String e = Event_list.poll();
				System.out.print(e);
				System.out.println();
				Export_list.add(e);
			}
			
		}
		else
		{
			while(!Export_list.isEmpty())
			{
				String e = Export_list.poll();
				System.out.print(e);
				System.out.println();
				Event_list.add(e);
			}
		}
			
	}
	///Please Check this method and the stuff that comes in, pretty sure it works but you need to check it 
	/// this was the simplest way to do it I think
	public void print(String racer_name, String occurance, String time)
	{
		
		if(Event_list.isEmpty())
		{
			while(!Export_list.isEmpty())
			{
				String e = Export_list.poll();
				System.out.print(e);
				System.out.println();
				Event_list.add(e);
			}
		}
		else
		{
			while(!Event_list.isEmpty())
			{
				String e = Event_list.poll();
				System.out.print(e);
				System.out.println();
				Export_list.add(e);
			}
		}
	}

	public void newRun(){
		double start1;
		double start2;
		if(!racerQueue1.isEmpty()){
			racerRun1.add(racerQueue1.remove());
			start1 = t.start();
		}
		if(!racerQueue2.isEmpty()){
			racerRun2.add(racerQueue2.remove());
			racerRun2.add(racerQueue2.remove());
			start1 = t.start();
			start2 = t.start();
		}
	}

	public void endRun(){
		if(!racerRun1.isEmpty()){
			racerRun1.remove();	

		}
		if(!racerRun2.isEmpty()){
			racerRun2.remove();
			
		}

	}
}