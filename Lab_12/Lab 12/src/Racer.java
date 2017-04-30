
public class Racer implements Comparable<Object>{
 
	private String firstName;
	private String lastName;
	private String time;
	private String runNumber;
	private int hours;
	private int minutes;
	private int seconds;
	public Racer(String firstName, String lastName, String runNumber,String time) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.runNumber=runNumber;
		this.time=time;
		setTime(time);
	}

	public void setTime(String s) {
		if (time.contains(":")) {
			String numHours = time.substring(0, s.indexOf(":"));
			s = s.substring(s.indexOf(":") + 1, s.length() - 1);
			hours = Integer.parseInt(numHours);
			if (s.contains(":")) {
				String numMinutes = time.substring(0, s.indexOf(":"));
				s = s.substring(s.indexOf(":") + 1, s.length() - 1);
				minutes = Integer.parseInt(numMinutes);
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
		return runNumber+ " "+firstName + " "+lastName+" "+time;
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Racer) {
			Racer other = (Racer) o;
			if (time == "DNF" || other.time == "DNF") {
				if (time == "DNF" && other.time == "DNF") {
					return 2;
				} else if (time == "DNF") {
					return -1;
				} else if (other.time == "DNF") {
					return 1;
				}
			}
			int hourscompare=Math.max(other.hours, hours);
			int minutescompare=Math.max(other.minutes, minutes);
			int secondscompare=Math.max(other.seconds, seconds);
		}
		return 0;
	}

}

