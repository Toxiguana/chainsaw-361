package sprint_1;

import java.util.LinkedList;
import java.util.Queue;

//one stream of racers (only IND) that can start, finish, cancel and not finish (DNF).
//For each event handle the response in the Chronotimer.
//You should be able to detect a start, a finish (with times) and calculate the total time for a race.

public class ChronoTimer {

	Queue<Racer> racerQueue = new LinkedList<Racer>();
	Queue<Racer> racerRun = new LinkedList<Racer>();
	Queue<Racer> racerFinish = new LinkedList<Racer>();
	private boolean power = false;
	Time t = new Time();
	private boolean[][] enabled = new boolean[2][4];
	private double[][] times = new double[2][4];
	private boolean[] available = new boolean[4];

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

	public boolean getEnabled(int i, int j){
		return enabled[i][j];
	}

	public double getTimes(int i, int j){
		return times[i][j];
	}

	public void sendCommand(String command){
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
		}
		else{
			power = true;
			for(int i = 0; i < available.length; i++){
				available[i] = true;
			}
		}
	}

	public void exit(){
		//"quits program" //exit simulator
		if(isPowerOn()) throw new IllegalStateException();
		System.exit(0);
	}

	public void reset(){
		//sets all variables to initial values
		if(!isPowerOn()) throw new IllegalStateException();

		racerQueue = new LinkedList<Racer>();
		racerRun = new LinkedList<Racer>();
		racerFinish = new LinkedList<Racer>();
		enabled = new boolean[2][4];
		times = new double[2][4];
		available = new boolean[4];
		hours = 0;
		minutes = 0;
		seconds = 0.0;
	}

	public void setTime(int hrs, int min, double sec){
		//allows user to set time
		if(!isPowerOn()) throw new IllegalStateException();
		hours = hrs;
		minutes = min;
		seconds = sec;
	}

	public void dnfRacer(){
		//sets end time of next racer to finish to DNF, not return to queue
		if(!isPowerOn()) throw new IllegalStateException();
		Racer r = racerRun.remove();
		r.setEnd(-1);
		r.setState(2);
		racerFinish.add(r);
	}

	public void cancelRacer(){
		//discard current race for racer and put back in queue as next to start
		if(!isPowerOn()) throw new IllegalStateException();
		Queue<Racer> newQueue = new LinkedList<Racer>();
		Racer r = racerRun.remove();
		times = new double[2][4]; //will be different for more than one racer
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
		if(!isPowerOn()) throw new IllegalStateException();
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

	public boolean trigChannel(int channelNum){
		//trigger the channel number & pulls racer from queue
		//if odd number, is a start time
		//if even number, is an end time
		if(!isPowerOn()) throw new IllegalStateException();
		
		if(channelNum % 2 != 0){ //odd
			if(racerQueue.isEmpty()){
				System.out.println("No Racers in the Queue"); 
				return false;
			}
			if(enabled[0][channelNum/2] && available[channelNum/2]){
				Racer r = racerQueue.remove();
				double start = t.start();
				times[0][channelNum/2] = start;
				r.setStart(start);
				r.setState(1);
				racerRun.add(r);
				available[channelNum/2] = false;
				return true;
			}
		}
		else if(channelNum % 2 == 0){ //even
			if(enabled[1][(channelNum/2)-1] && !available[(channelNum/2)-1]){
				Racer r1 = racerRun.remove();
				double end = t.end();
				times[1][(channelNum/2)-1] = end;
				r1.setEnd(end);
				r1.setState(2);
				racerFinish.add(r1);
				available[(channelNum/2)-1] = true;
				return true;
			}
		}
		return false;
	}

	public void start(){
		//triggers channel 1
		if(!isPowerOn()) throw new IllegalStateException();
		trigChannel(1);
	}

	public void finish(){
		//triggers channel 2
		if(!isPowerOn()) throw new IllegalStateException();
		trigChannel(2);
	}

	public void addRacer(int racerNum){ //num
		//adds racer to queue
		if(!isPowerOn()) throw new IllegalStateException();
		Racer r = new Racer(racerNum, 0.0, 0.0, "0", 0);
		racerQueue.add(r);
	}
}