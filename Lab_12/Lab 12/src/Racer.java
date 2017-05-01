
public class Racer {
 
	private String firstIntial;
	private String lastName;
	private String time;
	private String runNumber;
	public Racer(String firstIntial, String lastName, String runNumber,String time) {
		this.firstIntial = firstIntial;
		this.lastName = lastName;
		this.runNumber=runNumber;
		this.time=time;
	}
	@Override
	public String toString() {
		return runNumber+ " "+firstIntial + " "+lastName+" "+time;
	}

}

