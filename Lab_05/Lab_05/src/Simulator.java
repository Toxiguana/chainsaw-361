import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Simulator {

//	private ATM atm;
	private Bank bank;
	private int accountNum;
	private int state; 
	private Account acc;
	//////////////////////////////////////////////

	public Simulator(Bank b){
//		atm = new ATM();
		bank = b;
//		bank.createAccount(1234, 6789, 80.0);
//		bank.createAccount(6789, 4321, 60.0);
		accountNum = 0;
		state = 0; //0 - need Card#, 1 - need PIN, 2 - need Trans, 3 - need amount
	}
	
	public void display(int i){
		if(i == 0){
			//nothing
		}
		else if(i == 1){
			System.out.println("Enter Pin.");
		}
		else if(i == 2){
			System.out.println("Choose Transaction.");
		}
		else if(i == 3){
			System.out.println("Amount?");
		}
	}

	public void print(String in){
		System.out.println("PRINT: " + in);
	}

	public boolean load(File file){

		try {
			Scanner f = new Scanner(file);
			while(f.hasNextLine()){
				String s = f.nextLine();
				if (s.contains("CARDREAD")){
					
					String amount[] = s.split(" ");
					Integer arg = Integer.parseInt(amount[2]); 
					acc = bank.validateAccount(arg);
					if(acc != null){
						state = 1;
					}
				
					display(state);
				}
				if (s.contains("NUM")){
					
					String amount[] = s.split(" ");
					Integer arg = Integer.parseInt(amount[2]); 
					if(state == 1){
						if(bank.validatePin(acc, arg)){
							state = 2;
						}
					}
					else if(state == 3){
						acc.withdraw(arg);
						state = 2;
					}
					
					display(state);
				}
				if (s.contains("W")){
					state = 3;
					display(state);
					
				}
				if (s.contains("CB")){
					acc.getBalance();
					state = 2;
					
					display(state);
				}
				if (s.contains("CANCEL")){
					state = 0;
				}

			}
			return true;
		} catch (IOException e) {
			return false;
		}
	} //end load method
}
