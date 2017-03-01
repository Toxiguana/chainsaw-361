package sprint_1;

public class Racer {

	private int numRacer;
	private double startTime;
	private double endTime;
	private int stateRacer; //0 - in Queue, 1 - Racing, 2 - Done Racing
	
	public Racer(int nR, double sT, double eT, int sR){
		numRacer = nR;
		startTime = sT;
		endTime = eT;
		stateRacer = sR;
	}
}
