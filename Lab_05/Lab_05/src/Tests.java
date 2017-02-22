import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

	Bank b;
	Account a1;
	Account a2;

	@Test
	public void withdrawalOne() {
		b = new Bank();
		a1 = b.createAccount(1234, 6789, 80.0);
		a2 = b.createAccount(6789, 4321, 60.0);
		b.validatePin(1234, 6789);
		a1.doOperation(-20.0);       
		assertEquals(60.0, a1.getBalance(), 0); // assert that the balance is now 60;
		assertEquals(60.0, a2.getBalance(), 0);
	}

	@Test
	public void withdrawalTwo() {
		b = new Bank();
		a1 = b.createAccount(1234, 6789, 80.0);
		a2 = b.createAccount(6789, 4321, 60.0);
		b.validatePin(1234, 6789);
		a1.doOperation(-80.0);
		assertEquals(0.0, a1.getBalance(), 0); //assert that the balance is now 0;
		assertEquals(60.0, a2.getBalance(), 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void incorrectValidation() {
		b = new Bank();
		a1 = b.createAccount(1234, 6789, 80.0);
		a2 = b.createAccount(6789, 4321, 60.0);
		b.validatePin(6789, 6969);
	}

	@Test
	public void deposit() {
		b = new Bank();
		a1 = b.createAccount(1234, 6789, 80.0);
		a2 = b.createAccount(6789, 4321, 60.0);
		b.validatePin(6789, 4321);
		a2.doOperation(20.0);
		assertEquals(80.0, a2.getBalance(), 0);     //assert balance == balance+20;
		assertEquals(80.0, a1.getBalance(), 0);
	}

}
