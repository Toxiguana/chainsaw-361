public class Sensor { //used to represent sensor hardware

	private int channelNum;
	private String sensorType;
	public Sensor(int cN){
		channelNum = cN;
	}
	
	public int getChannelNum(){
		return channelNum;
	}
}
