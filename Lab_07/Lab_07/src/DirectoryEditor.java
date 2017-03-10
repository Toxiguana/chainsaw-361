
public class DirectoryEditor {
	DirectoryProxy d = new DirectoryProxy();
	boolean addloop=false;
	public static void main(String[] args) {
		DirectoryProxy d = new DirectoryProxy();
		d.add("r", "l",3,"S");
		d.add("d", "l",3,"dklfajl");
		d.end();
		d.print();
		d.add("l", "r2",4,"SM");
		d.end();
		d.print();
		d.clear();
		d.print();
		d.add("r","l",3, "S");
	}
	public void sendCommand(String line){
		while(addloop){
			if(line.contains("END")){
				d.end();
			}
			else{
				String[] s = line.split(" ");
				String firstName=s[0];
				String lastName=s[1];
				String department=s[2];
				int phoneNumber=Integer.parseInt(s[3]);
				d.add(lastName, firstName, phoneNumber,department);
			}
		}
		if(line.contains("CLR")){
			d.clear();
		}
		else if(line.contains("ADD")){
			addloop=true;
		}
		else if(line.contains("PRINT")){
			d.print();
		}
	}
}
