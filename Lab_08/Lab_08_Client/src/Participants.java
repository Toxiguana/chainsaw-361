import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Participants {
	
	private String _name;
	private String _lname;
	private int _BIB;
	
	public Participants(String name, String lastName, int BIB) {
		_name = name;
		_lname = lastName;
		_BIB = BIB;
	}
	
	public void setName(String name) {
		_name = name;
	}
	
	public void setLastName(String lastName) {
		_lname = lastName;
	}
	
	public void setBib(int BIB) {
		_BIB = BIB;
	}
	
	@Override
	public String toString() {
		return _name + " " + _lname + " " + _BIB;
	}
	
	public static void main(String[] args) {
		Gson g = new Gson();
		ArrayList<Participants> p = new ArrayList<Participants>();
		p.add( new Participants("TT", "KK", 1));
		p.add(new Participants("T", "K", 2));
		p.add(new Participants("A", "A", 3));
		p.add(new Participants("B", "B", 4));
		
		String out = g.toJson(p);
		System.out.println(out);
		ArrayList<Participants> ep = (g.fromJson(out, new TypeToken<Collection<Participants>>(){}.getType()));
		for (Participants pp: ep) {
			System.out.println(pp);
		}
	}

}
