import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Time {
//	It is recommended that you create a Time class to handle complex time 
//	management.
	public String getSystemTime(){
		String time = new SimpleDateFormat("HH:mm:ss.S").format(Calendar.getInstance().getTime());
		
		return time;
	}
	
	public double start(){		
		long s = System.currentTimeMillis(); //one millisecond == 1 1000th of a second
		double sec = s/1000.0;
		double round = Math.round(sec*100.0)/100.0;
		
		return round;
	}
	
	public double end(){
		long s = System.currentTimeMillis(); //one millisecond == 1 1000th of a second
		double sec = s/1000.0;
		double round = Math.round(sec*100.0)/100.0;
		
		return round;
	}
	
	public String computeTime(double start, double end){
		double totalSeconds = Math.round((end-start)*100.0)/100.0;
		int seconds = (int) totalSeconds;
		int endMinutes = seconds/60;
		double minutes = totalSeconds/60.0;
		double endSeconds = (minutes - endMinutes)*60.0;
		
		return endMinutes + ":" + endSeconds;
	}
}
