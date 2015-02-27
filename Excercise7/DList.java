package lists.doublylinked;

import lists.interfaces.IList;

/**
 * A double-linked list class with sentinel nodes
 */

public class DList<E> implements IList<E> {

	DNode<E> header;
	DNode<E> trailer;

	public DList() {
		header = new DNode<E>(null);
		trailer = new DNode<E>(null);
		header.nextNode = trailer;
		trailer.previousNode = header;
	}

	/**
	 * Adds the parameter elem as the first element of the list. This element
	 * will have position 0.
	 */
	@Override
	public void addFirst(E elem) {
		DNode<E> newNode = new DNode<E>(elem);
		newNode.nextNode = header.nextNode;
		newNode.previousNode = header;
		header.nextNode.previousNode = newNode;
		header.nextNode = newNode;
	}

	/**
	 * Adds the parameter elem as the last position of the list.
	 */
	@Override
	public void addLast(E elem) {
		DNode<E> newNode = new DNode<E>(elem);
		newNode.nextNode = trailer;
		newNode.previousNode = trailer.previousNode;
		trailer.previousNode.nextNode = newNode;
		trailer.previousNode = newNode;
	}

	/**
	 * Inserts the parameter elem at a position specified by the index
	 * parameter. Returns error message if the index is out of bounds.
	 */
	@Override
	public void insertAt(int index, E elem) {
		DNode<E> newNode = new DNode<E>(elem);
		int i = 0;
		for (DNode<E> nodeIt = header; nodeIt != trailer; nodeIt = nodeIt.nextNode) {
			if (i == index) {
				newNode.nextNode = nodeIt.nextNode;
				newNode.previousNode = nodeIt;
				nodeIt.nextNode.previousNode = newNode;
				nodeIt.nextNode = newNode;
				return;
			}
			++i;
		}
		System.out.println("DList: Insertion out of bounds");
	}

	/**
	 * Returns true if the list is empty. Returns false if the list is not
	 * empty.
	 */
	@Override
	public boolean isEmpty() {
		return (header.nextNode == trailer);
	}

	/**
	 * Returns true if the element specified as a parameter is contained in the
	 * list. Returns false if it is not contained in the list.
	 */
	@Override
	public boolean contains(E elem) {
		for (DNode<E> travelerNode = header; travelerNode != trailer; travelerNode = travelerNode.nextNode) {
			if (travelerNode.getElement() == elem) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns the integer value of the position of the element specified as a
	 * parameter. Returns -1 if the element does not appear in the list.
	 */
	@Override
	public int getIndexOf(E elem) {
		int index = 0;
		DNode<E> travelerNode = header.nextNode;
		for (; travelerNode != trailer; travelerNode = travelerNode.nextNode) {
			if (travelerNode.getElement() == elem) {
				return index;
			} else {
				index++;
			}
		}
		return -1;
	}

	/**
	 * Removes the first element in the list.
	 */
	@Override
	public void removeFirst() {
		if (isEmpty()) {
			System.out.println("DList: List is empty");
			return;
		}
		header.nextNode = header.nextNode.nextNode;
		header.nextNode.previousNode = header;
	}

	/**
	 * Removes the last element in the list.
	 */
	@Override
	public void removeLast() {
		if (isEmpty()) {
			System.out.println("DList: List is empty");
			return;
		}
		trailer.previousNode = trailer.previousNode.previousNode;
		trailer.previousNode.nextNode = trailer;
	}

	/**
	 * Removes all occurrences of the element specified as a parameter. Nothing
	 * happens if parameter is not in the list.
	 */
	@Override
	public void removeAll(E elem) {
		// TODO does not work if parameter is set to null
		while (this.contains(elem)) {
			this.removeAt(this.getIndexOf(elem));
		}
	}

	/**
	 * Removes the element at the specified position.
	 */
	@Override
	public void removeAt(int index) {
		int i = 0;
		for (DNode<E> nodeTraveler = header.nextNode; nodeTraveler != trailer; nodeTraveler = nodeTraveler.nextNode) {
			if (i == index) {
				nodeTraveler.previousNode.nextNode = nodeTraveler.nextNode;
				nodeTraveler.nextNode.previousNode = nodeTraveler.previousNode;
				return;
			}
			++i;
		}
		System.out.println("DList: Deletion out of bounds");
	}

	/**
	 * Returns the size of the list expressed as an integer value.
	 */
	@Override
	public int getSize() {
		int index = 0;
		if (!isEmpty()) {
			DNode<E> nodeTraveler = header.nextNode;
			for (; nodeTraveler != trailer; nodeTraveler = nodeTraveler.nextNode) {
				index++;
			}
			return index;
		} else {

			return 0;
		}
	}

	/**
	 * Returns the first element in the list.
	 */
	@Override
	public E getFirst() {
		if (!this.isEmpty()) {
			return header.nextNode.getElement();
		}
		return null;
	}

	/**
	 * Returns the last element in the list.
	 */
	@Override
	public E getLast() {
		if (!this.isEmpty()) {
			return trailer.previousNode.getElement();
		}
		return null;
	}

	/**
	 * Returns the element in the position specified by the parameter.
	 */
	@Override
	public E getAt(int index) {
		if (index < this.getSize() && index >= 0) {
			int i = 0;
			for (DNode<E> nodeTraveler = header.nextNode; nodeTraveler != trailer; nodeTraveler = nodeTraveler.nextNode) {
				if (i == index) {
					return nodeTraveler.getElement();
				}
				++i;
			}
		} else {
			System.out.println("Index Out of Bounds.");
			return null;
		}
		return null;
	}

	/**
	 * Returns the String representation of all the elements that are part of
	 * the list
	 */
	@Override
	public String toString() {
		String str = "";
		DNode<E> nodeTraveler = header.nextNode;
		for (; nodeTraveler != trailer; nodeTraveler = nodeTraveler.nextNode) {
			str = str + nodeTraveler.getElement() + " ";
		}
		return str;
	}

	/**
	 * Prints each element of the list.
	 */
	public void show() {
		DNode<E> showing = header.nextNode;
		for (; showing != trailer; showing = showing.nextNode) {
			System.out.println(showing.getElement());
		}

	}

	public DNode<E> getFirstNode() {
		return header.nextNode;
	}

	public DNode<E> getLastNode() {
		return trailer.previousNode;
	}

	public DNode<E> getHeader() {
		return header;
	}

	public DNode<E> getTrailer() {
		return trailer;
	}

}
