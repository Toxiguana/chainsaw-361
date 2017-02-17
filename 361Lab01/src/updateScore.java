//	public int[][] frames;
//
//	public static int SCORE;
//
//	public void updateScore(){ 
//
//		for(int i = 0; i<9; i++){
//			int z = frames[0][i];
//			int x = frames[1][i];
//
//			if(z > -1){				
//				if(x > -1){
//					add(z, x, i);
//				}else;
//			}		
//		}
//	}
//
//
//	private void strike(int i){
//		int strikeScore = 10;
//		for( int s = 1; s < 2; s++){
//			if(i+s > 9) {
//				return;	
//			}
//
//			if(frames[0][i+s] > -1){
//				strikeScore += frames[0][i+s];
//
//			}else return;
//
//			if(frames[1][i+s] > -1){
//				strikeScore += frames[1][i+s];
//
//			}else return;			
//
//		}frames[0][i] = strikeScore;
//		frames[1][i] = 0;
//	}
//
//	private void add(int a, int b, int i){
//		if(a == 10 || b == 10){
//			strike(i);
//		}
//		if(a + b == 10){
//			spare(i);	
//		}
//		else SCORE += (a+b);	
//
//	}
//
//	private void spare(int i){
//		int spareScore = 10;
//		if(i == 9){
//			SCORE += (frames[0][i]);
//			SCORE += (frames[1][i]);
//		}
//
//		if(frames[0][i+1] > -1){
//			spareScore += frames[0][i+1];
//		}else return;
//
//		if(frames[1][i+1] > -1){
//			spareScore += frames[1][i+1];
//
//		}else return;				
//
//		frames[0][i] = spareScore;
//		frames[1][i] = 0;
//	}
//}
//
