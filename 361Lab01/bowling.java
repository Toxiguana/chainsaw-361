public class bowling{

	public int[][] frames = new int[2][10];

	public static int SCORE;


	public void updateScore(){ 

		for(int i = 0; i<9; i++){
			int z = frames[0][i];
			int x = frames[1][i];

			if(z > -1){				
				if(x > -1){
					add(z, x, i);
				}else;
			}		
		}
	}


	private void strike(int i){
		int strikeScore = 10;
		for( int s = 1; s < 2; s++){
			if(i+s > 9) {
				return;	
			}

			if(frames[0][i+s] > -1){
				strikeScore += frames[0][i+s];

			}else return;

			if(frames[1][i+s] > -1){
				strikeScore += frames[1][i+s];

			}else return;			

		}frames[0][i] = strikeScore;
		frames[1][i] = 0;
	}

	private void add(int a, int b, int i){
		if(a == 10 || b == 10){
			strike(i);
		}
		if(a + b == 10){
			spare(i);	
		}
		else SCORE += (a+b);	

	}

	private void spare(int i){
		int spareScore = 10;
		if(i == 9){
			SCORE += (frames[0][i]);
			SCORE += (frames[1][i]);
		}

		if(frames[0][i+1] > -1){
			spareScore += frames[0][i+1];
		}else return;

		if(frames[1][i+1] > -1){
			spareScore += frames[1][i+1];

		}else return;				

		frames[0][i] = spareScore;
		frames[1][i] = 0;
	}

	////////////////////


	public int numPins;
	public int numFrame;
	public int numThrow;
	public int finalScore;


	public bowling(){
		numPins = 0;
		numFrame = 1;
		numThrow = 1;
		finalScore = 0;

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


		updateScore();
		finalScore++;
	}
}


