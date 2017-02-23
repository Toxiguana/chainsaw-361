import java.util.Scanner;

public class ATM {

	static boolean run = true;

	public static void main (String args[]){
		Bank Bank = new Bank();
		Scanner s = new Scanner(System.in);

		Bank.createAccount(1234, 6789, 80.0);
		Bank.createAccount(6789, 4321, 60.0);

		int accountNum = 0000;
		int pinCode = 0000;
		
		while(run){ //main loop
			
			accountNum = promptInt(s, "Please enter 4-digit Account Number (0000).");
			while(!Bank.validateAccount(accountNum)){
				accountNum = promptInt(s, "Invalid Account Number.  Please enter a valid 4-digit Account Number (0000)");
			}
			
			pinCode = promptInt(s, "Please enter your 4-digit PIN Code");
			while(!Bank.validatePin(accountNum, pinCode)){
				pinCode = promptInt(s, "Invalid PIN code.  Please re-enter your 4-digit PIN code");
			}
			
			String in = promptString(s, "Enter 'w' for Withdraw or 'd' for Deposit");
			if(in.equals("w")){
				double value = promptDouble(s, "Enter dollar amount to Withdraw ($0.00)");
			}
			
			if(Bank.validateAccount(accountNum)){
				Account a2 = null;
				for(Account a:Bank.accounts){
					if(a.accountNum == accountNum){
						a2 = a;
					}
				}
				boolean b = false;
				while(b == false){
					pinCode = promptInt(s, "Please input 4-digit PIN Code (0000).");
					try{
						b = Bank.validatePin(accountNum, pinCode);
						b = true;
					}catch(IllegalArgumentException e){
					}
				}
				String in = promptString(s, "Input 'w' for Withdrawal or 'd' for Deposit.");
				if(in.equals("w")){
					boolean b2 = false;
					while(!b2){
						double value = promptDouble(s, "Insert dollar amount to Withdraw (0.00).");
						double newVal = value*-1;
						b2 = a2.doOperation(newVal);
						if(b2 == false){
							System.out.println("Could not complete transaction! Enter a different amount (0.00).");
							System.out.println("");
						}
					}
					System.out.println("Successful Transaction! You're account balance is now $" + a2.getBalance()
					+ ". Please take your receipt!");
				}
				else{
					double value = promptDouble(s, "Insert dollar amount to Deposit (0.00).");
					a2.doOperation(value);
					System.out.println("Successful Transaction! You're account balance is now $" + a2.getBalance() 
					+ ". Please take your receipt!");
				}
			}
			else{
				continue; //returns back to beginning of loop if invalid account number or pin
			}
			run = false;
		}	
		s.close();
	}
	/**
	 * Method to validate user input and return an int value
	 * @param s Scanner to use in method
	 * @param prompt String containing directions to print to user
	 * @return int inputted by user
	 */
	public static int promptInt(Scanner s, String prompt){
		int input = 0;
		do{
			System.out.println(prompt);
			if(s.hasNextInt()){
				input = s.nextInt();
			}
		}while(input < 0 || String.valueOf(input).length() != 4); //Re-prompts user if int is negative or not 4 digits
		return input;
	}

	public static String promptString(Scanner s, String prompt){
		String input = "";
		do{
			System.out.println(prompt);
			if(s.hasNext()){
				input = s.next();
			}
		}while(!input.equals("w") && !input.equals("d"));
		return input;
	}

	public static double promptDouble(Scanner s, String prompt){
		double input = 0;
		do{
			System.out.println(prompt);
			if(s.hasNextDouble()){
				input = s.nextDouble();
			}
		}while(input < 0); //Re-prompts user if double is negative
		return input;
	}
	
	public static void display(String s){
		System.out.println(s);
	}
}
