
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
				String tl=t.computeTime(r.getStart(), t.start());
				tl=tl.substring(0,tl.indexOf('.'));
				g.updateTime(r.getNum()+" "+tl+" R");
			}
		} catch (InterruptedException e) {
			return;
		}
	}
}
