
public class Racer {
 
	private String firstInitial;
	private String lastName;
	private String time;
	private String runNumber;
	public Racer(String firstIntial, String lastName, String runNumber,String time) {
		this.firstInitial = firstIntial;
		this.lastName = lastName;
		this.runNumber=runNumber;
		this.time=time;
	}
	@Override
	public String toString() {
		return runNumber+ " "+firstInitial + " "+lastName+" "+time;
	}

}

