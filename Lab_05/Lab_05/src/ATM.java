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
		Account a = null;
		
		while(run){ //main loop
			accountNum = 0000;
			pinCode = 0000;
			a = null;
//=====================================================================			
			while(a==null){ //Account Number loop
				accountNum = promptInt(s, "Please enter 4-digit Account Number ('c' to cancel)");
				if(accountNum == -1){ //if user enters 'c' to cancel, breaks out of Account Number loop
					break;
				}
				a = Bank.validateAccount(accountNum);
				if(a == null){
					System.out.println("Error: Account Not Found");
				}
			}
			if(accountNum == -1){ //resets main loop to beginning if the user cancels
				continue;
			}
//=====================================================================			
			while(!Bank.validatePin(a, pinCode)){ //pin code loop
				pinCode = promptInt(s, "Please enter your 4-digit PIN code ('c' to cancel)");
				if(pinCode == -1){ //if user enters 'c' to cancel, breaks out of pin code loop
					break;
				}
			}
			if(pinCode == -1){ //resets main loop to beginning if user cancels
				continue;
			}
//=====================================================================
			boolean cont = true;
			while(cont){
				String in = promptString(s, "Enter 'w' for Withdraw 'b' to check balance or 'c' to cancel");
				if(in.equals("c")){
					cont = false;
				}
				else if(in.equals("b")){
					System.out.print(a.getBalance());
				}
				else if(in.equals("w")){
					double value = promptDouble(s, "Enter dollar amount to Withdraw ($0.00)");
					if(a.withdraw(value)){
						System.out.println("success, you have withdrawn $" + value);
					}
					else{
						System.out.println("error: insufficient funds");
					}
				}
			}
//====================================================================== OLD CODE
//			if(Bank.validateAccount(accountNum)){
//				Account a2 = null;
//				for(Account a:Bank.accounts){
//					if(a.accountNum == accountNum){
//						a2 = a;
//					}
//				}
//				boolean b = false;
//				while(b == false){
//					pinCode = promptInt(s, "Please input 4-digit PIN Code (0000).");
//					try{
//						b = Bank.validatePin(accountNum, pinCode);
//						b = true;
//					}catch(IllegalArgumentException e){
//					}
//				}
//				String in = promptString(s, "Input 'w' for Withdrawal or 'd' for Deposit.");
//				if(in.equals("w")){
//					boolean b2 = false;
//					while(!b2){
//						double value = promptDouble(s, "Insert dollar amount to Withdraw (0.00).");
//						double newVal = value*-1;
//						b2 = a2.doOperation(newVal);
//						if(b2 == false){
//							System.out.println("Could not complete transaction! Enter a different amount (0.00).");
//							System.out.println("");
//						}
//					}
//					System.out.println("Successful Transaction! You're account balance is now $" + a2.getBalance()
//					+ ". Please take your receipt!");
//				}
//				else{
//					double value = promptDouble(s, "Insert dollar amount to Deposit (0.00).");
//					a2.doOperation(value);
//					System.out.println("Successful Transaction! You're account balance is now $" + a2.getBalance() 
//					+ ". Please take your receipt!");
//				}
//			}
//			else{
//				continue; //returns back to beginning of loop if invalid account number or pin
//			}
//			run = false;
		}	
		s.close();
	}
	/**
	 * Method to prompt user to input a value and re-prompts if more or less than 4 digits are inputted.
	 * @param s : Scanner to use in method
	 * @param prompt : String containing directions to print to user
	 * @return int inputted by user or -1 if user enters "c"
	 */
	public static int promptInt(Scanner s, String prompt){
		int input = 0;
		do{
			System.out.println(prompt);
			if(s.hasNextInt()){
				input = s.nextInt();
			}
			else if(s.hasNext("c")){
				return -1;
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
		}while(!input.equals("w") && !input.equals("b") && !input.equals("c"));
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
