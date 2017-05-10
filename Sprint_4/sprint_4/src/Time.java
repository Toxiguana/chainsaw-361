import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Time {
	
	public String getSystemTime(){
		/**
		 * returns the system time as a string in format "Hours:Minutes:Seconds.Milliseconds"
		 * for example if it is 8:29 pm and 34.583 seconds, it will print out "20:29:34:583"
		 */
		String time = new SimpleDateFormat("HH:mm:ss.S").format(Calendar.getInstance().getTime());
		
		return time;
	}
	
	/**
	 * Start Time in Seconds.
	 * @return double: the rounded start time from System Time
	 */
	public double start(){
		long s = System.currentTimeMillis(); //one millisecond == 1 1000th of a second
		double sec = s/1000.0;
		double round = Math.round(sec*100.0)/100.0;
		
		return round;
	}
	
	/**
	 * End Time in Seconds.
	 * @return double: the rounded end time from System Time
	 */
	public double end(){ //end time in seconds
		long s = System.currentTimeMillis(); //one millisecond == 1 1000th of a second
		double sec = s/1000.0;
		double round = Math.round(sec*100.0)/100.0;
		
		return round;
	}
	
	/**
	 * Computes the Time from Start & End Times.
	 * @param start: start time of Racer (double)
	 * @param end: end time of Racer (double)
	 * @return String: if DNF, return "DNF" | else return "minutes:seconds"
	 */
	public String computeTime(double start, double end){ //computes time from start & end
		if(end == -1){
			return "DNF";
		}
		double totalSeconds = Math.round((end-start)*100.0)/100.0;
		int seconds = (int) totalSeconds;
		int endMinutes = seconds/60;
		double minutes = totalSeconds/60.0;
		double endSeconds = (minutes - endMinutes)*60.0;
		endSeconds=Math.round(endSeconds*100.0)/100.0;
		return endMinutes + ":" + endSeconds;
	}
 
}
