import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class Simulator {
Scanner input=new Scanner(System.in);
boolean fileNameLoop;
String filename;
File file;
DirectoryEditor d = new DirectoryEditor();
public void getinput(){
	while(fileNameLoop){
		System.out.println("Please input the file name.");
		filename = input.nextLine();

		file = new File(filename);

		try(Scanner reader = new Scanner(new FileReader(file))){
			fileNameLoop = false;

			while(reader.hasNextLine()){
				d.sendCommand(reader.nextLine());
			}

		}catch(IOException e){
			System.out.println("Bad File");
		}
	}
}
}
