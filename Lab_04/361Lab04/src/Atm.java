import java.util.Scanner;

public class Atm {
	Bank b= new Bank();
	int cardNum;
	Scanner stdIn;
	int pin;
	double amount;
	
	public Atm(){
		cardNum = 0;
		stdIn = new Scanner(System.in);
	}
	
	public void withdrawal(){
		System.out.println("Enter your card number.");
		cardNum = stdIn.nextInt();
		System.out.println("Please Enter your Pin");
		pin=stdIn.nextInt();
		System.out.print("Please enter the amount you want to talk out");
		amount=stdIn.nextDouble();
		b.validatePin(, pin, amount)
	}
	
	public void deposit(){
		
	}
	
	
}
