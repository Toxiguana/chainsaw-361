import static org.junit.Assert.*;

import org.junit.Test;

public class ChronoTimerTests2 { //PARIND Tests

	ChronoTimer t = new ChronoTimer();
	Time t1 = new Time();
	
	@Test
	public void triggerWorks3RacersPARIND(){
		t.power();
		t.setEventType("PARIND");
		assertEquals(2, t.getEventType());
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
	
	@Test
	public void triggerWorks4RacersPARIND(){
		t.power();
		t.setEventType("PARIND");
		t.newRun();

		t.addRacer(22);
		t.addRacer(23);
		t.addRacer(24);
		t.addRacer(29);
		
		assertEquals(2, t.racerQueue1.size());
		assertEquals(2, t.racerQueue2.size());
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
		
		assertTrue(t.trigChannel(3));
		assertFalse(t.trigChannel(5));
		assertFalse(t.trigChannel(3));
		assertEquals(22, t.racerRun1.peek().getNum());
		assertEquals(23, t.racerRun2.peek().getNum());
		
		t.trigChannel(2);
		t.trigChannel(4);
		
		assertEquals(22, t.racerFinish2.peek().getNum());
		
		t.power();
		assertFalse(t.isPowerOn());
	}
	
	@Test
	public void testNewRun(){
		t.power();
		t.setEventType("IND");
		t.newRun();
		
		assertEquals(1, t.getRunNum());
		assertTrue(t.getRunStart());
	}
	
	@Test
	public void testEndRun(){
		t.power();
		t.setEventType("IND");
		t.newRun();
		t.addRacer(22);
		t.addRacer(23);
		t.togChannel(1);
		t.togChannel(2);
		t.trigChannel(1);
		t.trigChannel(2);
		
		assertEquals(1, t.getRunNum());

		t.endRun();
		
		assertFalse(t.runList.isEmpty());
		assertTrue(t.racerRun1.isEmpty());
		assertEquals(2, t.getRunNum());
		assertEquals(1, t.runList.get(0).getRunNum());
	}
}
