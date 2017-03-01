package sprint_1;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;

//one stream of racers (only IND) that can start, finish, cancel and not finish (DNF).
//For each event handle the response in the Chronotimer.
//You should be able to detect a start, a finish (with times) and calculate the total time for a race.

public class ChronoTimer {

	//		Queue<Racer> racers = new LinkedList<Racer>();
	//		private boolean on = false;
	static Boolean power;
	Queue<String> myQueue = new LinkedList<String>();

	public static void main(String args[]){
		//make sure to print results to console, use Time.computeTime
		Simulator sim= new Simulator();
		String command;
		power=false;
		do{
			command=sim.getInput();
			if(command==""){
				break;
			}
			System.out.println(command);
		}while(true);
	}

	public void power(){
		//if(on) -> turn off //stay in simulator
		//else if(off) -> turn on
	}

	public void exit(){
		//"quits program" //exit simulator
	}

	public void reset(){
		//sets all variables to initial values
		//boolean on
		//other variables to initialize?
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
	}

	public void start(){
		//triggers channel 1
	}

	public void finish(){
		//triggers channel 2
	}
}



