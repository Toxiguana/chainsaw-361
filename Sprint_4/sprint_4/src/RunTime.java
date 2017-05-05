import java.util.ArrayList;

public class RunTime implements Runnable {
	ArrayList<Racer>run;
	GUI g;
	Time t=new Time();
	public RunTime(GUI _g,ArrayList<Racer> _r){
		g=_g;
		run=_r;
	}
	public void run() {
		try {
			while (true) {
				Thread.sleep(1000);
				for(int i=0;i<run.size();i++){
				Racer r=run.get(i);
				String output=r.getNum()+" ";
				String time=t.computeTime(r.getStart(), t.start());
				time=time.substring(0,time.indexOf('.'));
				output+=time;
				r.setOutput(output);
				g.updateTime(run);
				}
			}
		} catch (InterruptedException e) {
			return;
		}
	}
}
