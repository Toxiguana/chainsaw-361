import static org.junit.Assert.*;

import org.junit.Test;

public class ChronoTimerTests3 { //Sprint 3 Tests
	
	ChronoTimer t = new ChronoTimer();
	Time t1 = new Time();
	
	@Test
	public void groupTest() {
		t.power();
		t.setEventType("GRP");
		t.newRun();
		
		assertTrue(t.racerQueue1.isEmpty());
		
		t.togChannel(1);
		t.togChannel(2);
		assertTrue(t.getEnabled(0, 0));
		assertTrue(t.getEnabled(1, 0));
		
		t.trigChannel(1);
		assertTrue(t.racerQueue1.isEmpty());
		assertTrue(t.racerRun1.isEmpty());

		t.trigChannel(2);
		t.trigChannel(2);
		t.trigChannel(2);
		
		assertTrue(!t.racerFinish1.isEmpty());
		assertTrue(t.racerFinish2.isEmpty());

		assertEquals(1, t.racerFinish1.peek().getNum());
		
		t.power();
		assertFalse(t.isPowerOn());
	}
	
	@Test
	public void groupTestAddNum() {
		t.power();
		t.setEventType("GRP");
		t.newRun();
		
		assertTrue(t.racerQueue1.isEmpty());
		
		t.togChannel(1);
		t.togChannel(2);
		assertTrue(t.getEnabled(0, 0));
		assertTrue(t.getEnabled(1, 0));
		
		t.trigChannel(1);
		assertTrue(t.racerQueue1.isEmpty());
		assertTrue(t.racerRun1.isEmpty());

		t.trigChannel(2);
		t.trigChannel(2);
		t.trigChannel(2);
		
		assertTrue(!t.racerFinish1.isEmpty());
		assertTrue(t.racerFinish2.isEmpty());

		assertEquals(1, t.racerFinish1.peek().getNum());
		assertEquals(3, t.racerFinish1.size());
		
		assertTrue(t.setGroupRacerNum(15));
		t.setGroupRacerNum(20);
		t.setGroupRacerNum(25);
		
		assertFalse(t.setGroupRacerNum(2));
		
		assertTrue(t.racerFinish1.isEmpty());
		assertEquals(3, t.racerFinish2.size());

		
		t.power();
		assertFalse(t.isPowerOn());
	}
	
	@Test
	public void groupTestAddNumAfterRun() {
		t.power();
		t.setEventType("GRP");
		t.newRun();
		
		assertTrue(t.racerQueue1.isEmpty());
		
		t.togChannel(1);
		t.togChannel(2);
		assertTrue(t.getEnabled(0, 0));
		assertTrue(t.getEnabled(1, 0));
		
		t.trigChannel(1);
		assertTrue(t.racerQueue1.isEmpty());
		assertTrue(t.racerRun1.isEmpty());

		t.trigChannel(2);
		t.trigChannel(2);
		t.trigChannel(2);
		
		assertTrue(!t.racerFinish1.isEmpty());
		assertTrue(t.racerFinish2.isEmpty());

		assertEquals(1, t.racerFinish1.peek().getNum());
		assertEquals(3, t.racerFinish1.size());
		
		t.endRun();
		
		Run r = t.runList.get(0);
		
		r.setRacerNum(0, 15);
		r.setRacerNum(0, 20);
		assertTrue(r.setRacerNum(0, 25));
		
		assertFalse(r.setRacerNum(1, 30));
		assertFalse(t.setGroupRacerNum(2)); //cant call setgroupracernum after the run is ended		
		
		assertTrue(t.racerFinish1.isEmpty());
		assertEquals(0, t.racerFinish2.size());

		
		t.power();
		assertFalse(t.isPowerOn());
	}
	
	@Test
	public void groupTestConn() {
		t.power();
		t.setEventType("GRP");
		t.newRun();
		
		assertTrue(t.racerQueue1.isEmpty());
		
		t.connectSensor(1);
		t.connectSensor(2);
		
		t.togChannel(1);
		t.togChannel(2);
		
		assertEquals(1, t.getConnected(0, 0).getChannelNum());
		assertEquals(2, t.getConnected(1, 0).getChannelNum());
		
		t.disconnectSensor(1);
		t.disconnectSensor(2);
		
		assertNull(t.getConnected(0, 0));
		assertNull(t.getConnected(1, 0));
	}
	
	@Test
	public void swapTest(){
		t.power();
		t.setEventType("IND");
		t.newRun();
				
		t.addRacer(12);
		t.addRacer(13);
		
		t.togChannel(1);
		t.togChannel(2);
		assertTrue(t.getEnabled(0, 0));
		assertTrue(t.getEnabled(1, 0));
		
		t.trigChannel(1);
		t.trigChannel(1);
		
		t.swap();
		
		assertEquals(13, t.racerRun1.peek().getNum());

	}

}
