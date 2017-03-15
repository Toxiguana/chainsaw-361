package sprint_2;

import static org.junit.Assert.*;

import org.junit.Test;

public class ChronoTimerTests {

	ChronoTimer t = new ChronoTimer();
	Time t1 = new Time();
	
	@Test(expected = IllegalStateException.class)
	public void powerNotOn() {
		t.addRacer(22);
	}
	
	@Test
	public void triggerFail() {
		t.power();
		t.runType = 1;
		boolean b = t.trigChannel(1);
		
		assertFalse(b);
		assertFalse(t.getEnabled(0, 0));
		assertEquals(0.0, t.getTimes(0, 0), 0);
		
		t.power();
		assertFalse(t.isPowerOn());
	}
	
	@Test
	public void triggerWorks1Racer(){
		t.power();
		t.runType = 1;
		t.addRacer(22);
		
		assertTrue(!t.racerQueue1.isEmpty());
		assertTrue(t.racerRun1.isEmpty());
		assertTrue(t.racerFinish.isEmpty());
		
		t.togChannel(1);
		assertTrue(t.getEnabled(0, 0));
		
		t.trigChannel(1);
		assertEquals(t1.start(), t.getTimes(0, 0), 0);
		
		t.power();
		assertFalse(t.isPowerOn());
	}
	
	@Test
	public void triggerWorks2Racers(){
		t.power();
		t.runType = 1;
		t.addRacer(22);
		t.addRacer(23);
		
		assertTrue(!t.racerQueue1.isEmpty());
		assertTrue(t.racerRun1.isEmpty());
		assertTrue(t.racerFinish.isEmpty());
		
		t.togChannel(1);
		t.togChannel(2);
		t.togChannel(3);
		assertTrue(t.getEnabled(0, 0));
		assertTrue(t.getEnabled(1, 0));
		assertTrue(t.getEnabled(0, 1));
		
		t.trigChannel(1);
		assertEquals(t1.start(), t.getTimes(0, 0), 0);
		
		assertTrue(!t.racerQueue1.isEmpty());
		assertTrue(!t.racerRun1.isEmpty());
		assertTrue(t.racerFinish.isEmpty());
		
		t.trigChannel(3);
		assertTrue(t.racerQueue1.isEmpty());
		assertTrue(!t.racerRun1.isEmpty());
		assertTrue(t.racerFinish.isEmpty());

		t.trigChannel(2);
		assertEquals(t1.start(), t.getTimes(0, 1), 0);
		assertEquals(t1.end(), t.getTimes(1, 0), 0);
		
		assertTrue(t.racerQueue1.isEmpty());
		assertTrue(!t.racerRun1.isEmpty());
		assertTrue(!t.racerFinish.isEmpty());
	}
	
	@Test
	public void cancelRacer(){
		t.power();
		t.runType = 1;
		t.addRacer(25);
		
		assertTrue(!t.racerQueue1.isEmpty());
		assertTrue(t.racerRun1.isEmpty());
		assertTrue(t.racerFinish.isEmpty());
		
		t.togChannel(1);
		assertTrue(t.getEnabled(0, 0));
		
		t.trigChannel(1);
		assertEquals(t1.start(), t.getTimes(0, 0), 0);
		
		t.cancelRacer();
		assertEquals(0.0, t.getTimes(0, 0), 0);
		assertEquals(0.0, t.getTimes(1, 0), 0);
		
		t.power();
		assertFalse(t.isPowerOn());
	}
	
	@Test
	public void dnfRacer(){
		t.power();
		t.runType = 1;
		t.addRacer(27);
		
		t.togChannel(1);
		assertTrue(t.getEnabled(0, 0));
		
		t.trigChannel(1);
		assertEquals(t1.start(), t.getTimes(0, 0), 0);
		
		t.dnfRacer();
		assertEquals(0.0, t.getTimes(1, 0), 0);
		
		assertTrue(t.racerRun1.isEmpty());
		assertTrue(!t.racerFinish.isEmpty());
		
		t.power();
		assertFalse(t.isPowerOn());
	}
	
	@Test
	public void startFinish(){
		t.power();
		t.runType = 1;
		t.addRacer(27);
		
		t.togChannel(1);
		assertTrue(t.getEnabled(0, 0));
		t.togChannel(2);
		assertTrue(t.getEnabled(1, 0));
		
		t.start();
		assertEquals(t1.start(), t.getTimes(0, 0), 0);
		
		t.finish();
		assertEquals(t1.end(), t.getTimes(1, 0), 0);
		
		assertTrue(t.racerRun1.isEmpty());
		assertTrue(!t.racerFinish.isEmpty());
		
		t.power();
		assertFalse(t.isPowerOn());
	}
	
	@Test
	public void resetSystem(){
		t.power();
		t.runType = 1;
		t.addRacer(27);
		t.addRacer(28);
		
		t.togChannel(1);
		assertTrue(t.getEnabled(0, 0));
		t.togChannel(2);
		assertTrue(t.getEnabled(1, 0));
		
		t.start();
		assertEquals(t1.start(), t.getTimes(0, 0), 0);
		
		t.finish();
		assertEquals(t1.end(), t.getTimes(1, 0), 0);
		
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
		t.runType = 1;
		t.addRacer(25);
		t.addRacer(26);
	
		t.togChannel(1);
		t.togChannel(3);
		
		t.trigChannel(1);
		t.trigChannel(3);
		
		t.cancelRacer();
		assertEquals(1, t.racerRun1.size());
		assertEquals(0.0, t.getTimes(0, 0), 0);
		assertTrue(t.getAvailable(0));
		
		t.trigChannel(1);
		assertFalse(t.getAvailable(0));
		assertEquals(2, t.racerRun1.size());
		
		t.power();
		assertFalse(t.isPowerOn());
	}
}
