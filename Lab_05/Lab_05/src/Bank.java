import java.util.ArrayList;

public class Bank {
	
	ArrayList <Account> accounts;

	public Bank(){
		accounts = new ArrayList<Account>();
	}

	public Account createAccount(int acc, int PINC, double startBal){
		Account new1 = new Account(acc, PINC, startBal);
		accounts.add(new1);
		return new1;
	}
	
	public boolean validateAccount(int acc){
		for(Account a:accounts){
			if(a.accountNum == acc){
				return true;
			}
		}
		return false;
	}
	
	public boolean validatePin(int acc, int PINC){
		for(Account a:accounts){
			if(a.accountNum == acc){
				if(a.PIN != PINC){
					throw new IllegalArgumentException("Bad pin number");
				}
				return true;
			}
		}
		return false;
	}
}
