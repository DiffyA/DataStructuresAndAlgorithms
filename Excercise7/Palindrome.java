package lists.doublylinked;

public class Palindrome extends DList<Character> {

	DList<Character> wordList = new DList<Character> ();

	public Palindrome (String word){
		String wordLower = word.toLowerCase(); // Convert the structure to lower case in order to not run into case problems.
		int characters = word.length();
		for (int ii = 0; ii < characters; ii++) {
			wordList.addLast(wordLower.charAt(ii));
		}
	}

	/**
	 * Checks if structure is a palindrome. Also works for sentences, so long as words are separated by a space.
	 * @return True if the structure is a palindrome. False and an error message detailing the position of the discrepancy if not.
	 */
	public boolean isPalindrome() {
		String forward = "";
		String backward = "";
		int index = 0;
		DNode<Character> travelerNodeF = wordList.header.nextNode;
		DNode<Character> travelerNodeB = wordList.trailer.previousNode;
		while (index < wordList.getSize()) {
			if (travelerNodeF.getElement() != ' '){
				forward = forward + travelerNodeF.getElement();
			}
			if (travelerNodeB.getElement() != ' '){
				backward = backward + travelerNodeB.getElement();
			}
			travelerNodeF = travelerNodeF.getNextNode();
			travelerNodeB = travelerNodeB.getPreviousNode();
			index++;
		}
		if (!forward.equals(backward)){
			System.out.println("Discrepancy found at index " + index + ", printing last step: " + "\n" +  "Forward: " + forward + "\n" + "Backward: " + backward);
			return false;
		}
		System.out.println("The word(s) is a palindrome.");
		return true;
	}
}
