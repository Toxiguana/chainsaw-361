import java.util.Date;
public class Printer {
	Date date = new Date();
	public void print(String transaction, double amount){
		System.out.println("Receipt:");
		System.out.println(date.toString());
		System.out.println("Transaction : " + transaction);
		System.out.println("Amount: $" + amount);
		System.out.println();
	}
}