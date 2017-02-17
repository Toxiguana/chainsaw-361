public class bowling {

	public int numPins;
	public int numFrame;
	public int numThrow;
	public int finalScore;
	public int[][] frames;
	public int countStrike;
	public int countSpare;
	
	public bowling(){
		numPins = 0;
		numFrame = 1;
		numThrow = 1;
		finalScore = 0;
		frames = new int[2][10];
		countStrike = 0;
		countSpare = 0;
	}
	
	public void throwBall(int score){
		if(score < 0 || score > 10){
			throw new IllegalArgumentException();
		}
		if(numFrame > 10){
			throw new IllegalStateException();
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
				countStrike = 1;
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
				countSpare = 1;
			}
			numThrow = 1;
			numFrame++;
			numPins = 0;
		}
	}
	
	public void updateScore(){
		int i = frames[numThrow-1][numFrame-1];
		finalScore += i;
		
		if(countStrike > 0){
			if(countStrike == 1 || countStrike == 2 || countStrike == 3){
				finalScore += i;
				countStrike++;
			}
			else if(countStrike == 4){
				finalScore += i;
				countStrike = 0;
			}
		}
		if(countSpare > 0){
			if(countSpare == 1){
				finalScore += i;
				countSpare++;
			}
			else if(countSpare == 2){
				finalScore += i;
				countSpare = 0;
			}
		}
	}
}
