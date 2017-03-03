package sprint_1;

import static org.junit.Assert.*;

import org.junit.Test;

public class ChronoTimerTests {

	ChronoTimer t = new ChronoTimer();
	Time t1 = new Time();
	
	@Test
	public void triggerFail() {
		boolean b = t.trigChannel(1);
		assertFalse(b);
		assertFalse(t.getEnabled(0, 0));
		assertEquals(0.0, t.getTimes(0, 0), 0);
	}
	@Test
	public void triggerWorks(){
		t.addRacer(22);
		assertTrue(!t.racerQueue.isEmpty());
		assertTrue(t.racerRun.isEmpty());
		assertTrue(t.racerFinish.isEmpty());
		t.togChannel(1);
		assertTrue(t.getEnabled(0, 0));
		t.trigChannel(1);
		assertEquals(t1.start(), t.getTimes(0, 0), 0);
	}

}
