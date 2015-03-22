package exercise11;

import java.util.ArrayList;

public class Company {
	// Attributes
	String name;
	ArrayList<Employee> roster = new ArrayList<Employee>();

	// Constructors
	public Company(String n, ArrayList<Employee> l) {
		this.name = n;
		this.roster = l;
	}

	public Company(String n) {
		this.name = n;
	}

	// Methods
	public Employee[] toArray() {
		Employee[] array = new Employee[roster.size()];
		roster.toArray(array);
		return array;
	}

	public void hireEmployee(Employee e) {
		this.roster.add(e);
	}

	public int employeesNumber() {
		return roster.size();
	}

	public boolean existEmployee(Employee e) {
		if (this.roster.contains(e)) {
			return true;
		} else {
			return false;
		}
	}

	public void fireEverybody() {
		this.roster.clear();
	}

	public boolean fireEmployee(Employee e) {
		if (this.roster.contains(e)) {
			this.roster.remove(e);
			return true;
		} else {
			return false;
		}
	}

	public String toString() {
		String s = "";
		if (!this.roster.isEmpty()) {
			for (int counter = 0; counter < this.roster.size(); counter++) {
				s = s + this.roster.get(counter) + ", ";
			}
		}
		return s;
	}
}
