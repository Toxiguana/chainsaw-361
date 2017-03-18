package sprint_2;

import static org.junit.Assert.*;

import org.junit.Test;

public class ChronoTimerTests {

	ChronoTimer t = new ChronoTimer();
	Time t1 = new Time();
	
	@Test
	public void powerNotOn() {
		t.setEventType("IND");
		t.newRun();
		t.addRacer(22);
		t.togChannel(1);
		assertFalse(t.trigChannel(1));
	}
	
	@Test
	public void triggerFail() {
		t.power();
		t.setEventType("IND");
		t.newRun();
		boolean b = t.trigChannel(1);
		
		assertFalse(b);
		assertFalse(t.getEnabled(0, 0));
		
		t.power();
		assertFalse(t.isPowerOn());
	}
	
	@Test
	public void triggerWorks1Racer(){
		t.power();
		t.setEventType("IND");
		t.newRun();

		t.addRacer(22);
		
		assertTrue(!t.racerQueue1.isEmpty());
		assertTrue(t.racerRun1.isEmpty());
		assertTrue(t.racerFinish.isEmpty());
		
		t.togChannel(1);
		assertTrue(t.getEnabled(0, 0));
		
		t.trigChannel(1);
		
		t.power();
		assertFalse(t.isPowerOn());
	}
	
	@Test
	public void triggerWorks2RacersIND(){
		t.power();
		t.setEventType("IND");
		t.newRun();

		t.addRacer(22);
		t.addRacer(23);
		
		assertTrue(!t.racerQueue1.isEmpty());
		assertTrue(t.racerRun1.isEmpty());
		assertTrue(t.racerFinish.isEmpty());
		
		t.togChannel(1);
		t.togChannel(2);
		
		assertTrue(t.getEnabled(0, 0));
		assertTrue(t.getEnabled(1, 0));
		
		t.trigChannel(1);
		
		assertTrue(!t.racerQueue1.isEmpty());
		assertTrue(!t.racerRun1.isEmpty());
		assertTrue(t.racerFinish.isEmpty());
		
		assertFalse(t.trigChannel(3));

		t.trigChannel(1);
		
		assertTrue(t.racerQueue1.isEmpty());
		assertTrue(!t.racerRun1.isEmpty());
		assertTrue(t.racerFinish.isEmpty());
		
		t.trigChannel(2);
		
		assertTrue(t.racerQueue1.isEmpty());
		assertTrue(!t.racerRun1.isEmpty());
		assertTrue(!t.racerFinish.isEmpty());
		assertEquals(22, t.racerFinish.peek().getNum());
		
	}
	
	@Test
	public void cancelRacer(){
		t.power();
		t.setEventType("IND");
		t.newRun();

		t.addRacer(25);
		
		assertTrue(!t.racerQueue1.isEmpty());
		assertTrue(t.racerRun1.isEmpty());
		assertTrue(t.racerFinish.isEmpty());
		
		t.togChannel(1);
		assertTrue(t.getEnabled(0, 0));
		
		t.trigChannel(1);
		
		t.cancelRacer();
		assertEquals(25, t.racerQueue1.peek().getNum());
		assertEquals(0.0, t.racerQueue1.peek().getStart(), 0);
		
		t.power();
		assertFalse(t.isPowerOn());
	}
	
	@Test
	public void dnfRacer(){
		t.power();
		t.setEventType("IND");
		t.newRun();

		t.addRacer(27);
		
		t.togChannel(1);
		assertTrue(t.getEnabled(0, 0));
		
		t.trigChannel(1);
		
		t.dnfRacer();
		
		assertTrue(t.racerRun1.isEmpty());
		assertTrue(!t.racerFinish.isEmpty());
		
		t.power();
		assertFalse(t.isPowerOn());
	}
	
	@Test
	public void startFinish(){
		t.power();
		t.setEventType("IND");
		t.newRun();

		t.addRacer(27);
		
		t.togChannel(1);
		assertTrue(t.getEnabled(0, 0));
		
		t.togChannel(2);
		assertTrue(t.getEnabled(1, 0));
		
		t.start();
		
		t.finish();
		
		assertTrue(t.racerRun1.isEmpty());
		assertTrue(!t.racerFinish.isEmpty());
		
		t.power();
		assertFalse(t.isPowerOn());
	}
	
	@Test
	public void resetSystem(){
		t.power();
		t.setEventType("IND");
		t.newRun();

		t.addRacer(27);
		t.addRacer(28);
		
		t.togChannel(1);
		assertTrue(t.getEnabled(0, 0));
		
		t.togChannel(2);
		assertTrue(t.getEnabled(1, 0));
		
		t.start();
		
		t.finish();
		
		assertTrue(!t.racerQueue1.isEmpty());
		assertTrue(t.racerRun1.isEmpty());
		assertTrue(!t.racerFinish.isEmpty());
		
		t.reset();
		assertTrue(t.racerQueue1.isEmpty());
		assertTrue(t.racerRun1.isEmpty());
		assertTrue(t.racerFinish.isEmpty());
	}
	
	@Test
	public void testCancel(){
		t.power();
		t.setEventType("IND");
		t.newRun();

		t.addRacer(25);
		t.addRacer(26);
	
		t.togChannel(1);
		t.togChannel(2);
		
		t.trigChannel(1);
		t.trigChannel(1);
		assertFalse(t.trigChannel(3));
		
		t.cancelRacer();
		assertEquals(1, t.racerRun1.size());
		assertEquals(1, t.racerQueue1.size());
		
		t.trigChannel(1);
		assertEquals(2, t.racerRun1.size());
		
		t.power();
		assertFalse(t.isPowerOn());
	}
}
