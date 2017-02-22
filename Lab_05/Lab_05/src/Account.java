
public class Account {
	int accountNum;
	int PIN;
	double bal;
	
	public Account(int acc, int PINC, double startBal){
		accountNum = acc;
		PIN = PINC;
		bal = startBal;
	}
	
	public boolean doOperation(double amount){
		if(amount < 0){ //withdrawal
			if(bal + amount >= 0){
				bal += amount;
				return true;
			}
			else{
				return false;
			}
		}
		else{
			bal += amount;
			return true;
		}
	}
	public double getBalance(){
		return bal;
	}
}
