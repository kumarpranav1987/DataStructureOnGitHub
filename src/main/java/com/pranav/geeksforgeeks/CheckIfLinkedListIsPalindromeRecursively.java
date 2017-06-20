package com.pranav.geeksforgeeks;
/*http://practice.geeksforgeeks.org/problems/check-if-linked-list-is-pallindrome/1
*/public class CheckIfLinkedListIsPalindromeRecursively {

}

class Node {
	int data;
	Node next;

	Node(int d) {
		data = d;
		next = null;
	}
}

class GfG {
	boolean isPalindrome(Node head) {
		Node left = new Node(0);
		left.next=head;
		return isPalindrome(left, head);
	}

	private boolean isPalindrome(Node left, Node right) {
		if (right == null) {
			return true;
		}
		boolean result = isPalindrome(left, right.next) && (left.next.data == right.data);
		left.next = left.next.next;
		return result;
	}
}