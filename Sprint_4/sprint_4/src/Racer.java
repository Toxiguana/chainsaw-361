public class Racer { //used to represent a person and store data about their race

	private int numRacer;
	private double startTime;
	private double endTime;
	private String elapsedTime;
	private int stateRacer; //0 - in Queue, 1 - Racing, 2 - Done Racing
	private Time t = new Time();
	public String output="";
	public Racer(int nR, double sT, double enT, String elT, int sR){
		numRacer = nR;
		startTime = sT;
		endTime = enT;
		elapsedTime = elT;
		stateRacer = sR;
	}
	
	//Getters
	public int getNum(){
		return numRacer;
	}
	
	public double getStart(){
		return startTime;
	}
	
	public double getEnd(){
		return endTime;
	}
	
	public String getElapsedTime(){
		return elapsedTime;
	}
	
	public int getState(){
		return stateRacer;
	}
	public String getOutput(){
		return output;
	}
	
	//Setters
	public void setNum(int nR){
		this.numRacer = nR;
	}
	
	public void setStart(double sT){
		this.startTime = sT;
	}
	
	public void setEnd(double enT){
		this.endTime = enT;
	}
	
	public void setElapsed(double sT, double enT){
		this.elapsedTime = t.computeTime(sT, enT);
	}
	
	public void setState(int sR){
		this.stateRacer = sR;
	}
	public void setOutput(String s){
		output=s;
	}
}
