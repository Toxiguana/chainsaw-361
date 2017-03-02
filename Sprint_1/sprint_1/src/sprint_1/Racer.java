package sprint_1;

public class Racer {

	private int numRacer;
	private double startTime;
	private double endTime;
	private double elapsedTime;
	private int stateRacer; //0 - in Queue, 1 - Racing, 2 - Done Racing
	
	public Racer(int nR, double sT, double enT, double elT, int sR){
		numRacer = nR;
		startTime = sT;
		endTime = enT;
		elapsedTime = elT;
		stateRacer = sR;
	
		void setStart(double sT){
			this.startTime = sT;
		}
		
		void setState(int st){
			this.stateRacer = st;
		}
		
		void setEnd(double enT){
			this.endTime = enT;
		}
	
	}
}
