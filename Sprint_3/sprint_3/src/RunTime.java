
public class RunTime implements Runnable {
	Racer r;
	GUI g;
	Time t=new Time();
	public RunTime(GUI _g,Racer _r){
		g=_g;
		r=_r;
	}
	public void run() {
		try {
			while (true) {
				Thread.sleep(1000);
				t.computeTime(r.getStart(), t.currentTime());
				g.updateTime(r.getNum()+" "+r.getElapsedTime()+" R");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
