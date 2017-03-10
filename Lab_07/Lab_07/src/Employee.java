public class Employee implements Comparable {
	//something
	//LastName, FirstName, Phone, Department
	private String lastName;
	private String firstName;
	private String phoneNum;
	private String depart;
	
	public Employee(String lN, String fN, String pN, String d){
		lastName = lN;
		firstName = fN;
		phoneNum = pN;
		depart = d;
	}
	
	public String getLast(){
		return lastName;
	}
	public String getFirst(){
		return firstName;
	}
	@Override
	public String toString(){
		return lastName + " " + firstName + " " + phoneNum + " " + depart;
	}

	@Override
	public int compareTo(Object arg0) {
		EmployeeComparator e = new EmployeeComparator();
		return e.compare(this, arg0);
	}
}
