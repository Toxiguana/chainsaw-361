import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Simulator {

	private ATM atm;
	private Bank bank;
	private int accountNum;
	private int state; 
	private Account acc;
	//////////////////////////////////////////////

	public Simulator(){
		atm = new ATM();
		bank = new Bank();
//		bank.createAccount(1234, 6789, 80.0);
//		bank.createAccount(6789, 4321, 60.0);
		accountNum = 0;
		state = 0; //0 - need Card#, 1 - need PIN, 2 - need Trans, 3 - need amount
	}
	
	public void display(String in){
		System.out.println(in);
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
					acc=bank.validateAccount(arg);
					if(acc!= null){
						state = 1;
					}
					else{
						
					}
					//if not validated correctly we just wait for another one.
					//ATM.display(state)
						//hopefully this will print to the screen the message like "Enter Pin."
				}
				if (s.contains("NUM")){
					
					String amount[] = s.split(" ");
					Integer arg = Integer.parseInt(amount[1]); 
					
					//this is different for different states.
					//state = 1 -> validate PIN, set state == 2
					
					//state = 3 -> get Amount, do withdrawal, then set state back to 2
							
					//ATM.display(state) 
						//print "Choose Transaction." 
						//no matter what, this should happen for both if the PIN/Amount is valid									
				}
				if (s.contains("W")){
					//set state to 3
					
				}
				if (s.contains("CB")){
					//Account.getBalance();
					//set state to 2
					
					//ATM.display(state) 
						//print "Choose Transaction." 
				}
				if (s.contains("CANCEL")){
					//set state to 0
				}

			}
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			throw new RuntimeException("file not found");
			return false;
		}
	} //end load method
}
