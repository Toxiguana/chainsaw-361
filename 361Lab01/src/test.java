import static org.junit.Assert.*;
import org.junit.Test;
public class test {
	
	bowling b;
	//frames[throws][frames]
	@Test
	public void testOneThrow() {
		b= new bowling();
		b.throwBall(7);
		b.updateScore();
		assertSame(7,b.finalScore);
		assertSame(7,b.frames[0][0]);
		assertSame(null,b.frames[1][0]);
	}
	@Test
	public void testTwoThrows(){
		b= new bowling();
		b.throwBall(5);
		b.throwBall(2);
		b.updateScore();
		assertSame(7,b.finalScore);
		assertSame(5,b.frames[0][0]);
		assertSame(2,b.frames[1][0]);
		assertSame(null,b.frames[0][1]);
	}
	@Test
	public void testThreeThrows(){
		b= new bowling();
		b.throwBall(5);
		b.throwBall(2);
		b.throwBall(5);
		b.updateScore();
		assertSame(12,b.finalScore);
		assertSame(5,b.frames[0][0]);
		assertSame(2,b.frames[1][0]);
		assertSame(2,b.frames[0][1]);
	}
	@Test
	public void testSpareCountsNextFrameScore(){
		b=new bowling();
		b.throwBall(7);
		b.throwBall(3);
		b.throwBall(5);
		b.throwBall(4);
		b.updateScore();
		assertSame(28,b.finalScore);
		assertSame(7,b.frames[0][0]);
		assertSame(3,b.frames[1][0]);
		assertSame(5,b.frames[0][1]);
		assertSame(4,b.frames[1][1]);
	}
	@Test
	public void testStrikeMovesToNextFrame(){
		b=new bowling();
		b.throwBall(10);
		assertSame(10,b.frames[0][0]);
		assertSame(0,b.frames[1][0]);
		assertSame(2,b.numFrame);
	}
	@Test
	public void testStrikeCountsNextFrameScores(){
		b=new bowling();
		b.throwBall(10);
		b.throwBall(3);
		b.throwBall(5);
		b.throwBall(6);
		b.throwBall(1);
		b.updateScore();
		assertSame(40,b.finalScore);
		b.throwBall(4);
		b.throwBall(4);
		b.updateScore();
		assertSame(48,b.finalScore);
	}
	@Test
	public void testSpareOnLastFrame(){
		b=new bowling();
		b.throwBall(3);
		b.throwBall(3);
		b.throwBall(3);
		b.throwBall(3);
		b.throwBall(3);
		b.throwBall(3);
		b.throwBall(3);
		b.throwBall(3);
		b.throwBall(3);
		b.throwBall(3);
		b.throwBall(3);
		b.throwBall(3);
		b.throwBall(3);
		b.throwBall(3);
		b.throwBall(3);
		b.throwBall(3);
		b.throwBall(3);
		b.throwBall(3);
		b.throwBall(5);
		b.throwBall(5);
		
	}
}
