package exercise11;

public class Test {
	public static void main(String[] args) {
		Employee e1 = new Employee(100, "Pedro", "Goncalvez");
		Employee e2 = new Employee(200, "Marta", "Nena");
		Employee e3 = new Employee(300, "Mario", "Bros");
		Company c1 = new Company("Sony");
		// System.out.println(e1.toString());
		// System.out.println(e2.toString());
		// System.out.println(e3.toString());
		c1.hireEmployee(e1);
		// System.out.println(c1.toString());
		c1.hireEmployee(e2);
		// System.out.println(c1.toString());
		c1.hireEmployee(e3);
		// System.out.println(c1.toString());
		Employee[] a1 = c1.toArray();
		for (int ii = 0; ii < a1.length; ii++) {
			System.out.println(a1[ii]);
		}
	}
}
