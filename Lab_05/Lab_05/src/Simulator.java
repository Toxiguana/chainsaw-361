import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Simulator {

	private ATM atm = new ATM();
	private Bank bank = new Bank();

	//////////////////////////////////////////////

	public void display(String in){
		System.out.println(in);
	}

	public void print(String in){
		System.out.println("PRINT: " + in);
	}

	public void load(File file){

		try {
			Scanner f = new Scanner(file);
			while(f.hasNextLine()){
				String s = f.nextLine();
				if (s.contains("cr")){
					String amount[] = s.split(" ");
					Integer arg = Integer.parseInt(amount[1]); 
					bank.validateAccount(arg);
				}
				if (s.contains("n")){
					String amount[] = s.split(" ");
					Integer arg = Integer.parseInt(amount[1]); 
					if(bank.validateAccount(arg)==false){
						///TODO: What are we supposed to do if it's false?
					}
									
				}
				if (s.contains("w")){
					//TODO
				}
				if (s.contains("cb")){
					//TODO
				}
				if (s.contains("ca")){
					//TODO
				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("file not found");
		}
		//TODO
	}

}
