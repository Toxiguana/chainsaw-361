import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Simulator {
	//Issues events for the ChronoTimer by reading in text from file, console, or GUI.

	String inputType; //stores if reading from file, console, or GUI
	boolean inputloop = true; //loops thru to get type of input
	Scanner input = new Scanner(System.in); //reads file/console input

	boolean fileNameLoop = true; //loops thru to continue getting events from file
	String filename; //stores filename and passes it to be read
	File file; //file being read
	ChronoTimer test = new ChronoTimer(); //used to do read file


	public String getInput(){
		System.out.println("Do you want to take input from the Console, a File, or a GUI?");
		
		while(inputloop){
			System.out.println("Enter 'U':User/Console Input, 'T':Text File, or 'G':GUI Input.");
			inputType = input.nextLine();
			if(inputType.equalsIgnoreCase("U") || inputType.equalsIgnoreCase("T") || inputType.equalsIgnoreCase("G")){
				inputloop = false;
			}
		}
		if(inputType.equalsIgnoreCase("U")){ //user input
			while(true){
				// TODO: Make this look pretty!
				System.out.println("Enter a Command.");
				System.out.println("1. Power | 2. Reset | 3. Time | 4. Event Type");
				System.out.println("5. New Run | 6. Add Runner | 7. Toggle");
				System.out.println("8. Trigger | 9. Start | 10. Finish");
				System.out.println("11. DNF | 12. Cancel | 13. Swap");
				System.out.println("14. Connect Sensor | 15. Disconnect Sensor");
				System.out.println("16. Group Racer Number Set | 17. End Run");
				System.out.println("18. Print | 19. Export | 20. Exit");
				
				int menuChoice = input.nextInt();

				switch(menuChoice){
				
				case 1:
					return "POWER";
				case 2:
					return "RESET";
				case 3:
					System.out.println("What is the time? (hours:minutes:seconds)");
					String time = input.nextLine();
					time = input.nextLine();
					return "TIME " + time;
				case 4: 
					while(true){
						System.out.println("Please Choose the Event Type:");
						System.out.println("1. Individual Run");
						System.out.println("2. Parallel Individual Run");
						System.out.println("3. Group Run");
						// TODO: ADD PARGRP!
						int runChoice = input.nextInt();
						switch (runChoice){
						case 1:
							return "EVENT IND";
						case 2:
							return "EVENT PARIND";
						case 3:
							return "EVENT GRP";
						// TODO: ADD PARGRP!
						default:
							System.out.println("Invalid Input.");
						}
					}
				case 5:
					return "NEWRUN";
				case 6:
					System.out.println("What is the number of the runner you want to add?");
					int runnerNum = input.nextInt();
					return "NUM " + runnerNum;
				case 7:
					while(true){
						System.out.print("What channel do you want to toggle?");
						int toggleInput = input.nextInt();
						if(toggleInput >= 1 && toggleInput <= 8){
							return "TOG " + toggleInput;
						}
						else{
							System.out.println("Invalid Input.");
						}
					}
				case 8:
					while(true){
						System.out.print("What channel do you want to trigger?");
						int triggerInput = input.nextInt();
						if(triggerInput >= 1 && triggerInput <= 8){
							return "TRIG " + triggerInput;
						}
						else{
							System.out.println("Invalid Input.");
						}
					}
				case 9:
					return "START";
				case 10:
					return "FINISH";
				case 11:
					return "DNF";
				case 12:
					return "CANCEL";
				case 13:
					return "SWAP";
				case 14:
					System.out.println("Which channel do you want to connect a sensor to?");
					int con = input.nextInt();
					if(con >= 1 && con <= 8){
						return "CONN " + con;
					}
					else{
						System.out.println("Invalid Input.");
					}
				case 15:
					System.out.println("Which channel do you want to disconnect a sensor from?");
					int discon = input.nextInt();
					if(discon >= 1 && discon <= 8){
						return "DISC " + discon;
					}
					else{
						System.out.println("Invalid Input.");
					}
				case 16:
					System.out.println("What is the number you want to set the GRP racer to?");
					int gN = input.nextInt();
					return "GROUP " + gN;
				case 17:
					return "ENDRUN";
				case 18:
					System.out.println("Which run do you want to print out?");
					int runNum = input.nextInt();
					return "PRINT " + runNum;
				case 19:
					System.out.println("Which run do you want to export?");
					int runNumExport = input.nextInt();
					return "EXPORT " + runNumExport;
				case 20:
					return "EXIT";
				default:
					System.out.println("Invalid Input.");
					break;
				}
			} //end while	
		} //end if
		else if(inputType.equalsIgnoreCase("T")){ //text input
			while(fileNameLoop){
				System.out.println("Please input the file name.");
				filename = input.nextLine();

				file = new File(filename);

				try(Scanner reader = new Scanner(new FileReader(file))){
					fileNameLoop = false;

					while(reader.hasNextLine()){
						test.sendCommand(reader.nextLine());
					}

				}catch(IOException e){
					System.out.println("Bad File");
				}
			} //end while
			return "";
		}
		else{ //GUI input
			return "GUI";
		}
	} //end getInput()

}