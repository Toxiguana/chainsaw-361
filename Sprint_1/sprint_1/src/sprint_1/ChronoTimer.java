package sprint_1;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;

//one stream of racers (only IND) that can start, finish, cancel and not finish (DNF).
//For each event handle the response in the Chronotimer.
//You should be able to detect a start, a finish (with times) and calculate the total time for a race.

public class ChronoTimer {

	Queue<Racer> racers = new LinkedList<Racer>();
	private static boolean power = false;
	
	Time t = new Time();
	private boolean[][] enabled = new boolean[2][4];
	private double[][] times = new double[2][4];
//	Queue<String> myQueue = new LinkedList<String>();

	public static void main(String args[]){
		//make sure to print results to console, use Time.computeTime
		Simulator sim = new Simulator();
		String command;
		power = false;
		do{
			command = sim.getInput();
			if(command == ""){
				break;
			}
			System.out.println(command);
			//need something here to do things.
		}while(true);
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
		//empty the racers
	}

	public void setTime(){
		//allows user to set time
	}

	public void dnfRacer(String RacerNum){
		//sets end time of specified racer to DNF, not return to queue
	}

	public void cancelRacer(String RacerNum){
		//discard current race for racer and put back in queue as next to start
	}

	public void togChannel(int channelNum){
		//enable or disable the channel
		
	}

	public void trigChannel(int channelNum){
		//trigger the channel number
		//if odd number, is a start time
		//if even number, is an end time //I checked in the explanation and this is actually a thing
		if(channelNum % 2 != 0){ //odd
			double start = t.start();
			times[0][channelNum/2] = start;
		}
		else if(channelNum % 2 != 0){ //even
			double end = t.end();
			times[1][(channelNum/2)-1] = end;
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
}



