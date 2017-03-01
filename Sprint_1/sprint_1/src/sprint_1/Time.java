package sprint_1;

public class Time {
//	It is recommended that you create a Time class to handle complex time 
//	management.
	
	public double start(){
//		double start = 0.0;
		
		long s = System.currentTimeMillis();
//		System.out.println(s); //one millisecond == 1 1000th of a second
		double sec = s/1000.0;
//		System.out.println(sec);
		double round = Math.round(sec*100.0)/100.0;
//		System.out.println(round);
//		start = round;
		
		return round;
	}
	
	public double end(){
		
		long s = System.currentTimeMillis();
//		System.out.println(s); //one millisecond == 1 1000th of a second
		double sec = s/1000.0;
//		System.out.println(sec);
		double round = Math.round(sec*100.0)/100.0;
//		System.out.println(round);
		
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
