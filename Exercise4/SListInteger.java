package edalib.list.singlelink;

public class SListInteger extends SList<Integer> {

	public int sum() {
		SNode<Integer> nodeTraveler = firstNode;
		int sum = 0;
		while (nodeTraveler != null) {
			sum = sum + nodeTraveler.getElement();
			nodeTraveler = nodeTraveler.nextNode;
		}
		return sum;
	}

	public String evenNumbers() {
		String numbers = "";
		SNode<Integer> nodeTraveler = firstNode;
		while (nodeTraveler != null) {
			if (nodeTraveler.getElement() % 2 == 0) {
				numbers = numbers + nodeTraveler.getElement() + " ";
			}
			nodeTraveler = nodeTraveler.nextNode;
		}
		return numbers;
	}
}
