
public class DirectoryProxy {
//calls methods from MainDirectory
	MainDirectory m = new MainDirectory();
	
	public void print(){
		m.print();
	}
	
	public void end(){
		m.end();
	}
	
	public boolean add(String lastName, String firstName, String phoneNumber, String department){
		return m.add(lastName, firstName, phoneNumber, department);
	}
	
	public void clear(){
		m.clear();
	}
}
