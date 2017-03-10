
public class DirectoryProxy {
//calls methods from MainDirectory
	MainDirectory m = new MainDirectory();
	
	public void print(){
		m.print();
	}
	
	public void end(){
		m.end();
	}
	
	public boolean add(String lN, String fN, int pN, String d){
		return m.add(lN, fN, pN, d);
	}
	
	public void clear(){
		m.clear();
	}
}
