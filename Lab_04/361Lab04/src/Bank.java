import java.util.ArrayList;

public class Bank {
	ArrayList<Account> accounts = new ArrayList<Account>();

	public void createAccount(int accountNumber, int PIN,double startBal){
		//you should probably search accounts and make sure that there aren't any accounts with the same account number 
		//that you are trying to create.
		accounts.add(new Account(accountNumber, PIN, startBal));
	}
	public class Account{
		int accountNumber;
		int PINCode;
		double balance;
		public Account(int _accountnumber, int _PIN, double startbal){
			accountNumber = _accountnumber;
			PINCode = _PIN;
			balance = startbal;
		}
		public boolean validateOperation(double amount){
			if(amount < 0){ //withdrawal
				if(balance + amount >= 0){
					balance += amount;
					return true;
				}
				else{
					return false;
				}
			}
			else{
				balance += amount;
				return true;
			}
		}

	}
	public boolean validatePin(int accountnumber, int pin, double amount){
		for(Account a:accounts){
			if(a.accountNumber == accountnumber){
				if(a.PINCode == pin){
					if(a.validateOperation(amount)){
						return true;
					}
					else{
						return false;
					}
				}
			}
		}
		throw new IllegalStateException("Account number not found");
	}
}
