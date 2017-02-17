import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

    Bank b;
    
    @Test
    public void withdrawalOne() {
       b = new Bank();
       b.validatePin(1234, 9876, -20);
       assertSame();         // assert that the balance is now 60;
    }
    
    @Test
    public void withdrawalTwo() {
        b = new Bank();
        b.validatePin(1234, 9876, -80);
        assertSame();     //assert that the balance is now 0;
    }
    
    @Test
    public void incorrectValidation() {
        b = new Bank();
        b.validatePin(6789, 6969, -20)
        assertSame();     //assert balance == starting balance;
    }
    
    @Test
    public void deposit() {
       b = new Bank();
       b.validatePin(6789, 4321, 20);
       assertSame();     //assert balance == balance+20;
    }
//    Show the results for the following tests:
//        a.
//        Successful validate and withdrawal of $20 from account 1234;
//        b.
//        Successful validate and withdrawal of $80 from account 1234;
//        c.
//        Incorrect validation on account 6789;
//        d.
//        Successful deposit of $20 to account 6789
}