package exercise9;

import edalib.list.singlelink.*;

public class Expression {
	// Attributes
	String operation = "";
	SStack<Character> groupings = new SStack<Character>();

	// Constructors
	public Expression(String s) {
		this.operation = s;
	}

	// Methods
	public boolean balancer() {
		for (int ii = 0; ii < operation.length(); ii++) { // Repeats this to cover the whole length of the string.
			switch (operation.charAt(ii)) { 
			case '(':
			case '[':
			case '{':
				groupings.push(operation.charAt(ii)); // If it find an open grouper, adds it to the stack.
				break; // Once added, gets out of the switch and straight into the if below.
			case ')':
			case ']':
			case '}':
				if (!groupings.isEmpty()
						&& ((operation.charAt(ii) == ')' && groupings.top() == '(')
								|| (operation.charAt(ii) == ']' && groupings.top() == '[') || 
								(operation.charAt(ii) == '}' && groupings.top() == '{'))) {
					groupings.pop(); // Removes the last element in the stack if said element coincides (open to closed grouping) with the one being analyzed in the string.
				} else { // If they do not coincide, the ordering is wrong.
					System.out.println("The equation is not balanced.");
					return false;
				}
				break;
			} // end switch.
		} // end for.
		if (groupings.isEmpty()) { // If all elements were removed from the stack successfully, the equation is balanced.
			System.out.println("The equation is balanced.");
		} else {
			System.out.println("The equation is not balanced.");
			return false;
		}
		return true;
	}
}
