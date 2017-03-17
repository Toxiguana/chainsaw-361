package sprint_2;

public class Time {
//	It is recommended that you create a Time class to handle complex time 
//	management.
	public String getSystemTime(){
//		long s =  //one millisecond == 1 1000th of a second
////		long s = 12337127; //3hr 25min 37sec 127millisec
//		
//		int seconds = (int) (s/1000);
//		int milliseconds = (int)(s%1000);
//		int minutes = seconds/60;
//		seconds = seconds%60;
//		int hours = minutes/60;
//		minutes = minutes%60;
//		int days = hours/24;
//		
//		String result = days + " " +hours+":"+minutes+":"+seconds+"."+milliseconds;
//		return result;
////		double sec = s/1000.0;
////		double round = Math.round(sec*100.0)/100.0;
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
