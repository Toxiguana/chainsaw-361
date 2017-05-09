import java.util.Comparator;

public class RacerComparator implements Comparator{
	
	@Override
	public int compare(Object o1, Object o2){
		Racer r1 = (Racer) o1;
		Racer r2 = (Racer) o2;
		if(r1.getElapsedTimeSec() == r2.getElapsedTimeSec()){
			return 0;
		}
		else if(r1.getElapsedTimeSec() == -1){
			return -1;
		}
		else if(r2.getElapsedTimeSec() == -1){
			return 1;
		}
		else if(r1.getElapsedTimeSec() > r2.getElapsedTimeSec()){
			return 1;
		}
		else if(r1.getElapsedTimeSec() < r2.getElapsedTimeSec()){
			return -1;
		}
		else{
			return 0;
		}
	}
}
