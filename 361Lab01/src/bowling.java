import java.util.*;

public class bowling {

	public int[][] frames;

	public static int SCORE;


	public void throwBall(int score){
		//throw 1 - strike
		//throw 1 - other
		//update numThrow
		//update numPins
		//throw 2 - spare
		//throw 2 - other
		//update numThrow
		//update numPins
		//update frames
	}

	public boolean isStrike(){
		return false;
	}

	public boolean isSpare(){
		return false;
	}

	public void updateScore(int a){ 
		if(a>=0 && a <= 10){
			for(int i = 0; i<9; i++){
				int temp = 0;
				Object z = frames[0][i];
				Object x = frames[1][i];
				if(z != null){
					//strike trigger & method call
					//spare trigger & method call
					temp += frames[0][i];
				}else frames[0][i]= a;
				;

				if(x != null){
					//strike trigger & method call
					//spare trigger & method call
					temp += frames [0][1];
				}
				else frames[0][i]=a;
				;
				SCORE +=temp;
			}
		}
		else System.out.println("Invalid input. Please enter an integer between 1 and 10.");
	}
}
