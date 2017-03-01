
package sprint_1;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;


public class ChronoTimer {
	static Boolean power;
	Queue<String> myQueue = new LinkedList<String>();
	public static void main(String [] args){
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
	
	
	public static void ind(){
		
	}
	
	void power(){
		
	}
	
	void exit(){
		
	}
	
	void reset(){
		
	}
	
	void time(){
		
	}
	
	void dnf(String RacerName){
		
	}
	
	void cancel(String RacerName){
		
		
	}
	
	void tog(int button){
		
	}
	
	void trig(int button){
		
	}
	
	void start(String RacerName){
		
	}
	
	void finish(String RacerName){
		
	}
//	The first release of the timing system allows one stream of racers (IND) that can start, 
//	finish, cancel and not finish (DNF).  These are individual times (not parallel or group).
	
//	For each event handle the response in the Chronotimer.
//	You should be able to detect a start, a finish (with times) and calculate the total time for a race.

//	Your system should handle the basic events:
//	POWER
//	EXIT
//	RESET
//	TIME
//	DNF
//	CANCEL
//	TOG
//	TRIG 
//	START
//	FINISH
	
//	CANCEL will discard the current race and put the racer back in the queue as 
//	next to start.  DNF says that the run for the bib number is over (they do not 
//	return to the queue) and the end time is a DNF (Did Not Finish).

//	Output activity on the paper tape.
	
	
}
