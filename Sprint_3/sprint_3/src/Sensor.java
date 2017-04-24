
public class Sensor {

	private int channelNum;
	
	public Sensor(int cN){
		channelNum = -1;
	}
	
	public boolean connect(int cN){
		if(channelNum == -1){
			channelNum = cN;
			return true;
		}
		System.out.println("Sensor is already connected.");
		return false;
	}
	
	public boolean disconnect(){
		if(channelNum != -1){
			channelNum = -1;
			return true;
		}
		System.out.println("Sensor is not connected.");
		return true;
	}
}
