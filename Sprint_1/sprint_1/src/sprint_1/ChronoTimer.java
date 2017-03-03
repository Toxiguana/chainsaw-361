package sprint_1;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;

//one stream of racers (only IND) that can start, finish, cancel and not finish (DNF).
//For each event handle the response in the Chronotimer.
//You should be able to detect a start, a finish (with times) and calculate the total time for a race.

public class ChronoTimer {

	static Queue<Racer> racerQueue = new LinkedList<Racer>();
	static Queue<Racer> racerRun = new LinkedList<Racer>();
	static Queue<Racer> racerFinish = new LinkedList<Racer>();
	private static boolean power = false;
	Time t = new Time();
	private boolean[][] enabled = new boolean[2][4];
	private static double[][] times = new double[2][4];
	
	private int minutes = 0;
	private double seconds = 0.0;
	//	Queue<String> myQueue = new LinkedList<String>();

	public static void main(String args[]){
		//make sure to print results to console, use Time.computeTime
		Simulator sim = new Simulator();
		ChronoTimer t=new ChronoTimer();
		String command;
		power = false;
		do{
			command = sim.getInput();
			if(command == ""){
				break;
			}
			
		t.sendCommand(command);
		}while(true);
//		for(int i = 0; i < 2; i++){
//			for(int j = 0; j < 4; j++){
//				System.out.println(times[i][j]);
//			}
//		}
		
	}
	public void sendCommand(String command){
		if(command.contains("Power")){
			power();
			System.out.println("Power");
		}
		else if(command.contains("Exit")){
			exit();
			System.out.println("Exit");
		}
		else if(command.contains("Reset")){
			reset();
			System.out.println("Reset");
		}
		else if(command.contains("Time")){
			System.out.println(command);
			String minutes=command.substring(command.indexOf(" ")+1,command.indexOf(":"));
			String seconds=command.substring(command.indexOf(":")+1,command.length());
			int _minutes=Integer.parseInt(minutes);
			double _seconds=Double.parseDouble(seconds);
		setTime(_minutes,_seconds);
		System.out.println("Time " + _minutes + ":" + _seconds);
		}
		else if(command.contains("DNF")){
			dnfRacer();
			System.out.println("DNF");
		}
		else if(command.contains("Cancel")){
			cancelRacer();
			System.out.println("Cancel");
		}
		else if(command.contains("Toggle")){
			command=command.substring(command.length()-1,command.length());
			int channel=Integer.parseInt(command);
			togChannel(channel);
			System.out.println("Toggle Channel " + channel);
		}
		else if(command.contains("Trigger")){
			command=command.substring(command.length()-1,command.length());
			int channel=Integer.parseInt(command);
			trigChannel(channel);
			System.out.println("Trigger Channel " + channel);
		}else if(command.contains("Start")){
			start();
			System.out.println("Start");
		}
		else if(command.contains("Finish")){
			finish();
			System.out.println("Finish");
		}
	
	}
	public static boolean isPowerOn(){
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
		System.exit(0);
	}

	public void reset(){
		//sets all variables to initial values
		//boolean on
		//other variables to initialize?
		racerQueue = new LinkedList<Racer>();
		racerRun = new LinkedList<Racer>();
		racerFinish = new LinkedList<Racer>();
		enabled = new boolean[2][4];
		times = new double[2][4];
	}

	public void setTime(int min, double sec){

		//allows user to set time
		minutes = min;
		seconds = sec;
	}


	
	public void dnfRacer(){
		//sets end time of next racer to finish to DNF, not return to queue
		Racer r = racerRun.remove();
		r.setEnd(-1);
		r.setStart(2);
		racerFinish.add(r);
	}

	public void cancelRacer(){
		//discard current race for racer and put back in queue as next to start
		Queue<Racer> newQueue = new LinkedList<Racer>();
		Racer r = racerRun.remove();
		r.setStart(0.0);
		r.setState(0);
		newQueue.add(r);
		while(!racerQueue.isEmpty()){
			Racer r1 = racerQueue.remove();
			newQueue.add(r1);
		}
		racerQueue = newQueue;
	}

	public void togChannel(int channelNum){
		//enable or disable the channel
		boolean enable = enabled[0][channelNum/2];

		if(channelNum % 2 != 0 && enable == false){ //odd & disabled
			enabled[0][channelNum/2] = true;
		}
		else if(channelNum % 2 != 0 && enable == true){ //odd & enabled
			enabled[0][channelNum/2] = false;
		}
		else if(channelNum % 2 != 0 && enable == false){ //even & disabled
			enabled[1][(channelNum/2)-1] = true;
		}
		else if(channelNum % 2 != 0 && enable == true){ //even & enabled
			enabled[1][(channelNum/2)-1] = false;
		}
	}


	public void trigChannel(int channelNum){
		//trigger the channel number & pulls racer from queue
		//if odd number, is a start time
		//if even number, is an end time //I checked in the explanation and this is actually a thing
		
		if(channelNum % 2 != 0){ //odd
			if(enabled[0][channelNum/2]){
				Racer r = racerQueue.remove();
				double start = t.start();
				times[0][channelNum/2] = start;
				r.setStart(start);
				r.setState(1);
				racerRun.add(r);
			}
		}
		else if(channelNum % 2 != 0){ //even
			if(enabled[0][(channelNum/2)-1]){
				Racer r1 = racerRun.remove();
				double end = t.end();
				times[1][(channelNum/2)-1] = end;
				r1.setEnd(end);
				r1.setState(2);
				racerFinish.add(r1);
			}
		}
	}

	public void start(){
		//triggers channel 1
		trigChannel(1);
	}

	public void finish(){
		//triggers channel 2
		trigChannel(2);
	}
	
	public void addRacer(int racerNum){ //num
		Racer r = new Racer(racerNum, 0.0, 0.0, "0", 0);
		racerQueue.add(r);
	}
}