package exercise11;

public class Employee {
	// Attributes
	int cod_employee;
	String name;
	String surname;

	// Constructors
	public Employee(int cod, String n, String s) {
		this.cod_employee = cod;
		this.name = n;
		this.surname = s;
	}

	// Methods
	public String toString() {
		String s = "";
		s = s + this.name + " " + this.surname;
		return s;
	}

}
