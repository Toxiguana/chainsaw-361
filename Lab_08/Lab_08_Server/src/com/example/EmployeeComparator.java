package com.example;


import java.util.Comparator;

public class EmployeeComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Employee e1 = (Employee) o1;
		Employee e2 = (Employee) o2;
		
		int lastNameComp = e1.getLast().compareTo(e2.getLast());
		int firstNameComp = e1.getFirst().compareTo(e2.getFirst());
		
		if(lastNameComp == 0){
			return firstNameComp;
		}
		return lastNameComp;
	}
}