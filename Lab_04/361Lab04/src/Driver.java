import java.util.Scanner;
public class Driver {
	static boolean run = true;
	public static void main (String args[]){
		Bank Bank = new Bank();
		Scanner s = new Scanner(System.in);

		Bank.createAccount(1234, 6789, 80.0);
		Bank.createAccount(6789, 4321, 60.0);
		
		int accountNum = 0000;
		int pinCode = 0000;
		while(run){
			accountNum = promptInt(s, "Please input 4 digit account number (0000)");
			pinCode = promptInt(s, "Please input 4 digit pin code");
			if(Bank.validatePin(accountNum, pinCode)){
				String in = promptString(s, "input 'w' for withdraw or 'd' for deposit");
				if(in.equals("w")){
					double value = promptDouble(s, "insert dollar amount to withdraw ($0.00)");
					
				}
			}
			else{
				continue; //returns back to beginning of loop if invalid account number or pin
			}
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
		}while(!input.equals("w") || !input.equals("d"));
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
}
