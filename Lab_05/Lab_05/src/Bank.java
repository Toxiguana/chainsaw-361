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
	
	/**
	 * 
	 * @param acc : account number to validate
	 * @return the account object if it is found, or null if the account is not found
	 */
	public Account validateAccount(int acc){
		for(Account a:accounts){
			if(a.accountNum == acc){
				return a;
			}
		}
		return null;
	}
	
	public boolean validatePin(Account acc, int PINC){
		if(acc.PIN == PINC){
			return true;
		}
		else{
			return false;
		}
	}

}
