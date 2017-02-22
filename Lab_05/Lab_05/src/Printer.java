import java.util.Date;
public class Printer {
	 Date date = new Date();
public void print(String transaction,double amount){
	System.out.println(date.toString()+" transaction :"+transaction+" amount: "+amount);
	
}
}