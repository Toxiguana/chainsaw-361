import java.util.ArrayList;

public class RuntimeGroup implements Runnable {
	GUI g;
	Time t=new Time();
	double startTime;
	String output="";
	public RuntimeGroup(GUI _g,Double _startTime){
		g=_g;
		startTime=_startTime;
	}  
	//updates the output string for each racer so it can be printed out to the running display
	public void run() {
		try {
			while (true) {
				//thread sleeps and then runs every second
				Thread.sleep(1000);
				output=t.computeTime(startTime, t.start());
				g.updateTimeGroup(output+" R");
			}
		} catch (InterruptedException e) {
			return;
		}
	}
}
