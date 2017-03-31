package com.example;


public class Employee implements Comparable<Object>{
	
	private String firstName;
	private String lastName;
	private String department;
	private String phoneNumber;
	private String gender;
	private String title;
	
	public Employee(String firstName, String lastName, String department, String phoneNum, String g, String t) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.phoneNumber = phoneNum;
		this.gender = g;
		this.title = t;
	}
	
	@Override
	public String toString() {
		return title + " " + firstName + " " + lastName + " in the " + department + 
				" department has phone number of " + phoneNumber + 
				" and is a " + gender + ".";
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Employee) {
			Employee other = (Employee) o;
			return lastName.compareTo(other.lastName);
		}
		return 0;
	}

	public String getLast() {
		return lastName;
	}

	public String getFirst() {
		return firstName;
	}

}
