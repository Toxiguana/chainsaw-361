
public class Sensor {

	private int channelNum;
	private int sensorType; //1 = start, 2 = end
	
	public Sensor(){
		channelNum = -1;
//		sensorType = sT;
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
	
	public int getType(){
		return sensorType;
	}
}
