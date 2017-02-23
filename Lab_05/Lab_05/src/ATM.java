import java.util.Scanner;

public class ATM {

	static boolean run = true;

	public static void main (String args[]){
		Bank Bank = new Bank();
		Scanner s = new Scanner(System.in);
		Printer Printer = new Printer();

		Bank.createAccount(1234, 6789, 80.0);
		Bank.createAccount(6789, 4321, 60.0);

		int accountNum = 0000;
		int pinCode = 0000;
		Account a = null;
		
		while(run){ //main loop
			accountNum = 0000; //re-initialize all the variables at the beginning of the loop for safety
			pinCode = 0000;
			a = null;
//===================================================================== Get Account Number
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
//===================================================================== Get PIN code
			while(!Bank.validatePin(a, pinCode)){ //pin code loop
				pinCode = promptInt(s, "Please enter your 4-digit PIN code ('c' to cancel)");
				if(pinCode == -1){ //if user enters 'c' to cancel, breaks out of pin code loop
					break;
				}
			}
			if(pinCode == -1){ //resets main loop to beginning if user cancels
				continue;
			}
//===================================================================== Do Transaction
			boolean cont = true;
			double amount = 0.00;
			while(cont){
				String in = promptString(s, "Enter 'w' for Withdraw 'b' to check balance or 'c' to cancel");
				if(in.equals("c")){ //user cancels
					cont = false;
				}
				else if(in.equals("b")){ //user checks balance
					System.out.println("current Balance is $" + a.getBalance());
				}
				else if(in.equals("w")){ //user withdraws
					double value = promptDouble(s, "Enter dollar amount to Withdraw ($0.00)");
					if(a.withdraw(value)){
						System.out.println("success, you have withdrawn $" + value);
						amount += value;
					}
					else{
						System.out.println("error: insufficient funds");
					}
				}
			}
			if(amount > 0){
				Printer.print("Withdraw", amount);
			}
			else{
				Printer.print("Cancel", 0.00);
			}
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
				s.next(); //very important, moves to the next user input so it doesn't keep reading the same value forever
				return -1;
			}
			else if(s.hasNext("q")){
				s.next();
				run = false; //stops the main loop
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
		}while(!input.equals("w") && !input.equals("b") && !input.equals("c")); //re-prompts the user if the allowed string is not detected
		return input;
	}

	public static double promptDouble(Scanner s, String prompt){
		double input = 0;
		do{
			System.out.println(prompt);
			if(s.hasNextDouble()){
				input = s.nextDouble();
			}
		}while(input < 0); //Re-prompts user if input is negative
		return input;
	}
}
