package com.example;


import java.util.ArrayList;
import java.util.Collection;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Directory {
	private Gson g = new Gson();
	private ArrayList<Employee> employees = new ArrayList<Employee>();
	private String stuff =  "";
	
	public boolean add(String lN, String fN, String pN, String d, String g, String t){
		Employee e = new Employee(lN, fN, pN, d, g, t);
		employees.add(e);
		
		return true;
	}
	
	public String print(){
		//print things
		String s = "";
		EmployeeComparator ec = new EmployeeComparator();
		employees.sort(ec);
		if(employees != null && !employees.isEmpty()){
			s += "Printing... ";
			for(Employee e: employees) {
				System.out.println(e);
				s += "\n" + e.toString();
			}
			System.out.println("");
		}
		else{
			System.out.println("No employees in the Directory!");
		}
		return s;
	}
	
	public void clear(){
		employees = new ArrayList<Employee>();
		stuff = g.toJson(employees);
	}
}
