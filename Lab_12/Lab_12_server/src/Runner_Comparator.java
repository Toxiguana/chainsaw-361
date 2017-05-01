import java.util.Comparator;

public class Runner_Comparator implements Comparator{
	
	
	@Override
	public int compare(Object o1, Object o2) {
		
		
		
		Racer r1 = (Racer) o1;
		Racer r2 = (Racer) o2;
			if (r1.getTime() == "DNF" || r2.getTime() == "DNF") {
				if (r1.getTime() == "DNF" && r2.getTime()== "DNF") {
					return 0;
				} else if (r1.getTime() == "DNF") {
					return 1;
				} else if (r2.getTime() == "DNF") {
					return -1;
				}
			}
			int hourscompare=r2.getHours()-r1.getHours();
			int minutescompare=r2.getMinutes()-r1.getMinutes();
			int secondscompare=r2.getSeconds()-r1.getSeconds();
			if(hourscompare>0){
				return -1;
			}
			else if(hourscompare<0){
				return 1;
			}
			else{
				if(minutescompare>0){
					return -1;
				}
				else if(minutescompare<0){
					return 1;
				}
				else{
					if(secondscompare>0){
						return -1;
					}
					else if(secondscompare<0){
						return 1;
					}
					else{
						return 0;
					}
				}
			}
}

	
}
