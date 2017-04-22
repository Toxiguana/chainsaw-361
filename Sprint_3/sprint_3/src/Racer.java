public class Racer {

	private int numRacer;
	private double startTime;
	private double endTime;
	private String elapsedTime;
	private int stateRacer; //0 - in Queue, 1 - Racing, 2 - Done Racing
	private Time t = new Time();
	
	public Racer(int nR, double sT, double enT, String elT, int sR){
		numRacer = nR;
		startTime = sT;
		endTime = enT;
		elapsedTime = elT;
		stateRacer = sR;
	}
	public void setStart(double sT){
		this.startTime = sT;
	}
	
	public void setState(int sR){
		this.stateRacer = sR;
	}
	
	public void setEnd(double enT){
		this.endTime = enT;
	}
	
	public void setElapsed(double sT, double enT){
		this.elapsedTime = t.computeTime(sT, enT);
	}
	public int getNum(){
		return numRacer;
	}
	public double getStart(){
		return startTime;
	}
}
