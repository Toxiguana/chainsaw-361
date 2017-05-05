import static org.junit.Assert.*;

import org.junit.Test;

public class ChronoTimerTests2 { //PARIND Tests

	ChronoTimer t = new ChronoTimer();
	Time t1 = new Time();
	
	@Test
	public void triggerWorks2RacersPARIND(){
		t.power();
		t.setEventType("PARIND");
		t.newRun();

		t.addRacer(22);
		t.addRacer(23);
		t.addRacer(24);
		
		assertEquals(2, t.racerQueue1.size());
		assertEquals(1, t.racerQueue2.size());
		assertTrue(t.racerRun1.isEmpty());
		assertTrue(t.racerFinish2.isEmpty());
		
		t.togChannel(1);
		assertTrue(t.getEnabled(0, 0));
		t.togChannel(2);
		t.togChannel(3);
		t.togChannel(4);
		
		t.trigChannel(1);
		t.trigChannel(1);
		t.trigChannel(3);
		
		assertFalse(t.trigChannel(3));
		assertEquals(22, t.racerRun1.peek().getNum());
		assertEquals(23, t.racerRun2.peek().getNum());
		
		
		t.power();
		assertFalse(t.isPowerOn());
	}
}
