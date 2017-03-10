
public class DirectoryEditor {
	public static void main(String[] args) {
		MainDirectory m = new MainDirectory();
		m.add("r", "l", 3, "S");
		m.add("d", "l", 3, "dklfajl");
		m.end();
		m.print();
		m.add("l", "r2", 4, "SM");
		m.end();
		m.print();
		m.clear();
		m.print();
	}
}
