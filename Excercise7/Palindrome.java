package lists.doublylinked;

import java.util.Scanner;

public class Palindrome extends DList<Character> {

	DList<Character> wordList = new DList<Character> ();

	public Palindrome (String word){
		String wordLower = word.toLowerCase(); // Convert the word to lower case in order to not run into case problems.
		int characters = word.length();
		for (int ii = 0; ii < characters; ii++) {
			wordList.addLast(wordLower.charAt(ii));
		}
	}

	public boolean isPalindrome() {
		String forward = "";
		String backward = "";
		int index = 0;
		DNode<Character> travelerNodeF = wordList.header.nextNode;
		DNode<Character> travelerNodeB = wordList.trailer.previousNode;
		while (forward.equals(backward) && index < wordList.getSize()) {
			forward = forward + travelerNodeF.getElement();
			backward = backward + travelerNodeB.getElement();
			travelerNodeF = travelerNodeF.getNextNode();
			travelerNodeB = travelerNodeB.getPreviousNode();
			index++;
		}
		if (!forward.equals(backward)){
			System.out.println("Discrepancy found at index " + index + ", printing last step: " + "\n" +  "Forward: " + forward + "\n" + "Backward: " + backward);
			return false;
		}
		System.out.println("The word is a palindrome.");
		return true;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please introduce the word you would like to check.");
		Palindrome word = new Palindrome(input.next());
		word.isPalindrome();
		input.close();
	}
}
