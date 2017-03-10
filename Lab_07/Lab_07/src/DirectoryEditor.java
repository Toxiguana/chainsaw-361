import java.io.File;
import java.util.Scanner;

public class DirectoryEditor {
	static boolean run = true;
	DirectoryProxy d = new DirectoryProxy();
	public static void main(String[] args) {
		DirectoryProxy d = new DirectoryProxy();
		Scanner s = new Scanner(System.in);

		if(promptBoolean(s, "load file? (y/n)")){
						Simulator Simulator = new Simulator();
						Simulator.getInput();
		}
		else{
			while(run){
				String in = promptString(s, "Please enter a command (add, print, clr, quit)", "add", "clr", "print", "quit");
				switch(in.toLowerCase()){
				case "add": 
					System.out.println("ADD");
					boolean cont = true;
					while(cont){
						String firstName = promptString(s, "First Name");
						if(firstName.equals("end")){
							d.end();
							break;
						}
						String lastName = promptString(s, "Last Name");
						if(lastName.equals("end")){
							d.end();
							break;
						}
						String department = promptString(s, "Department");
						if(department.equals("end")){
							d.end();
							break;
						}
						String phoneNumber = promptString(s, "Phone Number");
						if(phoneNumber.equals("end")){
							d.end();
							break;
						}
						d.add(lastName, firstName, phoneNumber, department);
					}
					break;
					
				case "clr":
					d.clear();
					System.out.println("directory cleared");
					break;
				case "print":
					d.print();
					break;
				case "quit":
					run = false;
					break;
				}
			}
		}
	}

	public void sendCommand(String line){
		if(line.contains("END")){
//			System.out.println("END");
			d.end();
		}
		else if(line.contains("CLR")){
//			System.out.println("CLR");
			d.clear();
		}
		else if(line.contains("ADD")){
//			System.out.println("ADD");
		}
		else if(line.contains("PRINT")){
			d.print();
		}
		else{
			String[] s = line.split(" ");
			String firstName=s[0];
			String lastName=s[1];
			String department=s[2];
			String phoneNumber=s[3];
			d.add(lastName, firstName, phoneNumber,department);
		}
	}
	/**
	 * Prompts the user for input.  'String... acceptedvalue' is an arbitrary number of parameters which is used for input validation
	 * example:
	 * promptString(s, "do you like cake?", "yes", "no") will re-prompt the user until they either enter "yes" or "no" exactly
	 * promptString(s, "what is your favorite cake?") will not re-prompt the user and will return whatever the user enters
	 * 
	 * @param Scanner s : Scanner to use inside of method
	 * @param String prompt : Instructions to be printed to user
	 * @param String[] acceptedValue : Value to be used for input validation.  You can provide as few or as many parameters as you want.  
	 * @return String entered by user
	 */
	public static String promptString(Scanner s, String prompt, String... acceptedValue){
		String input = "";
		boolean cont = true;
		do{
			System.out.println(prompt);
			if(s.hasNext()){
				input = s.next();
			}
			if(acceptedValue.length == 0){
				cont = false;
			}
			else{
				for(int i = 0; i < acceptedValue.length; i++){
					if(input.equals(acceptedValue[i])){
						cont = false;
					}
				}
			}
		}while(cont);
		//re-prompts the user if the allowed string is not detected
		return input;
	}

	public static boolean promptBoolean(Scanner s, String prompt){
		String input = "";
		do{
			System.out.println(prompt);
			if(s.hasNext()){
				input = s.next();
			}
		}while(!input.equals("y") && !input.equals("n")); //re-prompts the user if the allowed string is not detected
		if(input.equals("y")){
			return true;
		}
		return false;
	}

	//	d.add("Bob", "Smith", "4149909899", "ACCT");
	//	d.add("d", "l", "3", "dklfajl");
	//	d.end();
	//	d.print();
	//	d.add("l", "r2", "4", "SM");
	//	d.end();
	//	d.print();
	//	d.clear();
	//	d.print();
}
