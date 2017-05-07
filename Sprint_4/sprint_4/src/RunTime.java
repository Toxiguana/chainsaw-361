import java.util.ArrayList;

public class RunTime implements Runnable {
	ArrayList<Racer>run;
	GUI g;
	Time t=new Time();
	public RunTime(GUI _g,ArrayList<Racer> _r){
		g=_g;
		run=_r;
	}
	//updates the output string for each racer so it can be printed out to the running display
	public void run() {
		try {
			while (true) {
				//thread sleeps and then runs every second
				Thread.sleep(1000);
				//goes through the racer arrayList and updates the time of each racer
				for(int i=0;i<run.size();i++){
				//gets a racer from the arrayList
				Racer r=run.get(i);
				//resets the racer output string
				String output=r.getNum()+" ";
				//computers current time for the racer
				String time=t.computeTime(r.getStart(), t.start());
				//substrings the time string to get rid of the milliseconds
				time=time.substring(0,time.indexOf('.'));
				//adds the time to the output string
				output+=time;
				//sets the output string for the racer
				r.setOutput(output);
				//sends updated arrayList to gui
				g.updateTime(run);
				}
			}
		} catch (InterruptedException e) {
			return;
		}
	}
}
