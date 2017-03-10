import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class MainDirectory {
	//actually has methods
	private Gson g = new Gson();
	private ArrayList<Employee> employees = new ArrayList<Employee>();
	private String stuff =  "";
	
	public boolean add(String lN, String fN, String pN, String d){
		Employee e = new Employee(lN, fN, pN, d);
		employees.add(e);

		return true;
	}
	
	public void end(){
		stuff = g.toJson(employees);
//		System.out.println(stuff);
	}
	
	public void print(){
		//print things
		ArrayList<Employee> em = (g.fromJson(stuff, new TypeToken<Collection<Employee>>(){}.getType()));
		
		if(em != null && !em.isEmpty()){
			for(Employee e: em) {
				System.out.println(e);
			}
			System.out.println("");
		}
		else{
			System.out.println("No elements in the MainDirectory");
		}
		
	}
	
	public void clear(){
		employees = new ArrayList<Employee>();
		stuff = g.toJson(employees);
		System.out.println("YAYYYY!");
	}
}
