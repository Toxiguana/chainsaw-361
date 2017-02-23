
public class Account {
	int accountNum;
	int PIN;
	double bal;
	
	public Account(int acc, int PINC, double startBal){
		accountNum = acc;
		PIN = PINC;
		bal = startBal;
	}
	
	public boolean withdrawal(double amount){
		if(amount >= 0){
			if(bal - amount >= 0){
				bal -= amount;
				return true;
			}
			else{
				return false;
			}
		}
		return false;
	}
	public double getBalance(){
		return bal;
	}
}
