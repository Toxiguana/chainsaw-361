public class Employee {
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
	@Override
	public String toString(){
		return lastName + " " + firstName + " " + phoneNum + " " + depart;
	}
}
