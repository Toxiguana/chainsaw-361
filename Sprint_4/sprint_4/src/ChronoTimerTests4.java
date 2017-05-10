import static org.junit.Assert.*;

import org.junit.Test;

public class ChronoTimerTests4 { //PARGRP Tests

	ChronoTimer t = new ChronoTimer();
	Time t1 = new Time();

	@Test
	public void PARGROUPTest1() {
		t.power();
		t.setEventType("PARGRP");
		t.newRun();
		
		assertTrue(t.racerQueue1.isEmpty());
		
		t.togChannel(1);
		t.togChannel(2);
		t.togChannel(3);
		
		t.addRacer(13);
		t.addRacer(14);
		t.addRacer(15);
		
		t.trigChannel(1);
		assertTrue(t.AlreadyStarted);
		assertEquals(0, t.racerQueue1.size());
		assertTrue(t.racerQueue2.isEmpty());
		int num = 0;
		for(int i = 0; i < t.racerRunPARGRP.length; i++){
			if(t.racerRunPARGRP[i] != null){
				num++;
			}
		}
		assertEquals(3, num);
		assertTrue(t.racerRun1.isEmpty());
		assertTrue(t.racerRun2.isEmpty());

		t.trigChannel(1);
		assertFalse(t.trigChannel(4));
		assertFalse(t.trigChannel(5));
		assertEquals(13, t.racerFinish2.peek().getNum());
		assertTrue(t.racerFinish1.isEmpty());
		t.trigChannel(3);
		t.trigChannel(2);
		assertEquals(3, t.racerFinish2.size());
		
		t.power();
		assertFalse(t.isPowerOn());
	}
	
	@Test
	public void PARGROUPTest2() {
		t.power();
		t.setEventType("PARGRP");
		t.newRun();
		
		assertTrue(t.racerQueue1.isEmpty());
		
		t.togChannel(1);
		t.togChannel(2);
		t.togChannel(3);
		
		t.addRacer(13);
		t.addRacer(14);
		t.addRacer(15);
		t.addRacer(16);
		t.addRacer(17);
		t.addRacer(18);
		t.addRacer(19);
		t.addRacer(20);
		t.addRacer(21);
		
		t.trigChannel(1);
		assertTrue(t.AlreadyStarted);
		assertEquals(0, t.racerQueue1.size());
		assertTrue(t.racerQueue2.isEmpty());
		int num = 0;
		for(int i = 0; i < t.racerRunPARGRP.length; i++){
			if(t.racerRunPARGRP[i] != null){
				num++;
			}
		}
		assertEquals(8, num);
		assertTrue(t.racerRun1.isEmpty());
		assertTrue(t.racerRun2.isEmpty());

		t.trigChannel(1);
		assertFalse(t.trigChannel(4));
		assertFalse(t.trigChannel(5));
		assertEquals(13, t.racerFinish2.peek().getNum());
		assertTrue(t.racerFinish1.isEmpty());
		t.trigChannel(3);
		assertEquals(2, t.racerFinish2.size());
		
		t.endRun();
		
		assertEquals(8, t.runList.get(0).getFinish2().size());
		t.power();
		assertFalse(t.isPowerOn());
	}
	
	@Test
	public void testClear() {
		t.power();
		t.setEventType("PARGRP");
		t.newRun();
		
		t.addRacer(1);
		t.addRacer(2);
		t.addRacer(3);
		
		t.clear(2);
		
		Racer r = t.racerQueue1.remove();
		Racer r2 = t.racerQueue1.remove();
		
		assertEquals(3, r2.getNum());
		
		
		t.power();
		assertFalse(t.isPowerOn());	
	}
	
}
