
public class Racer {
 
	private String firstIntial;
	private String lastName;
	private String time;
	private String runNumber;
	private int hours;
	private int minutes;
	private int seconds;
	
	public Racer(String firstIntial, String lastName, String runNumber,String time) {
		this.firstIntial = firstIntial;
		this.lastName = lastName;
		this.runNumber=runNumber;
		this.time=time;
		setTime(this.time);
	}

	public void setTime(String s) {
		if (s.contains(":")) {
			String numHours = s.substring(0, s.indexOf(":"));
			s = s.substring(s.indexOf(":") + 1, s.length());
			hours = Integer.parseInt(numHours);
			if (s.contains(":")) {
				String numMinutes = s.substring(0, s.indexOf(":"));
				minutes = Integer.parseInt(numMinutes);
				s = s.substring(s.indexOf(":") + 1, s.length());
				seconds = Integer.parseInt(s);
			} else {
				time = "DNF";
			}
		} else {
			time = "DNF";
		}
	}
	@Override
	public String toString() {
		return runNumber+ " "+firstIntial + " "+lastName+" "+time;
	}

	public String getLast() {
		return lastName;
	}
	public String getFirstIntial() {
		return firstIntial;
	}
	public String getTime() {
		return time;
	}
	public String getRunNumber() {
		return runNumber;
	}
	public int getHours(){
		return hours;
		
	}
	public int getMinutes(){
		return minutes;
	}
	public int getSeconds(){
		return seconds;
	}

}


