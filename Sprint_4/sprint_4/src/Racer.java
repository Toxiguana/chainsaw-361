public class Racer { //used to represent a person and store data about their race

	private int numRacer;
	private double startTime; //in seconds.milliseconds 0000000000.00
	private double endTime;
	private String elapsedTime; //in minutes:seconds int:double
	private double elapsedTimeSec; //elapsed time in seconds.milliseconds
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
	
	public double getElapsedTimeSec(){
		return elapsedTimeSec;
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
		
		if(elapsedTime.equals("DNF")){
			elapsedTimeSec = -1;
		}
		else{
			elapsedTimeSec = endTime - startTime;
		}
	}
	
	public void setState(int sR){
		this.stateRacer = sR;
	}
	public void setOutput(String s){
		output=s;
	}
}
