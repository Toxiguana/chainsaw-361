
public class DirectoryEditor {
	public static void main(String[] args) {
		DirectoryProxy d = new DirectoryProxy();
		d.add("r", "l", 3, "S");
		d.add("d", "l", 3, "dklfajl");
		d.end();
		d.print();
		d.add("l", "r2", 4, "SM");
		d.end();
		d.print();
		d.clear();
		d.print();
	}
}
