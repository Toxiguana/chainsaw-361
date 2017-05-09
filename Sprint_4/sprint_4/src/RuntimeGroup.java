import java.util.ArrayList;

public class RuntimeGroup implements Runnable {
	GUI g;
	Time t=new Time();
	String output="";
	ChronoTimer c=new ChronoTimer();
	public RuntimeGroup(GUI _g,ChronoTimer _c){
		g=_g;
		c=_c;
	}  
	//updates the output string for each racer so it can be printed out to the running display
	public void run() {
		try {
			while (true) {
				//thread sleeps and then runs every second
				Thread.sleep(1);
				output=t.computeTime(c.groupStart, t.start());
				g.updateTimeGroup(output+" R");
			}
		} catch (InterruptedException e) {
			return;
		}
	}
}
