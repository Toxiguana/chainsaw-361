import java.util.Scanner;

public class Atm {

	int cardNum;
	Scanner stdIn;
	
	public Atm(){
		cardNum = 0;
		stdIn = new Scanner(System.in);
	}
	
	public void withdrawal(){
		System.out.print("Enter your card number.");
		cardNum = stdIn.nextInt();
		
		
	}
	
	public void deposit(){
		
	}
	
	
}
