public class bowling {

	public int numPins;
	public int numFrame;
	public int numThrow;
	public int finalScore;
	public int[][] frames;
	
	public bowling(){
		numPins = 0;
		numFrame = 1;
		numThrow = 1;
		finalScore = 0;
		frames = new int[2][10];
	}
	
	public void throwBall(int score){
		if(score < 0 || score > 10){
			throw new IllegalArgumentException();
		}
		//throw 1 - strike
		//throw 1 - other
			//update numThrow, numPins
		if(numThrow == 1){
			frames[numThrow-1][numFrame-1] = score;
			updateScore();
			
			if(score == 10){
				frames[numThrow][numFrame-1] = 0;
				numThrow = 1;
				numFrame++;
				//strike count
			}
			else{
				numThrow = 2;
				numPins = score;
			}
		}
		//throw 2 - spare
		//throw 2 - other
			//update numThrow, numPins, frames
		else if(numThrow == 2){
			if((score + numPins) > 10){
				throw new IllegalArgumentException();
			}
			
			frames[numThrow-1][numFrame-1] = score;
			updateScore();
			
			if(score + numPins == 10){
				//spare count
			}
			numThrow = 1;
			numFrame++;
			numPins = 0;
		}
	}
	
	public void updateScore(){
		
	}
}
