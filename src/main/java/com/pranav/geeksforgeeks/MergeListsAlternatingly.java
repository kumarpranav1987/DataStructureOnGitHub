package com.pranav.geeksforgeeks;

public class MergeListsAlternatingly {
	public void mergeAlt(Node head1, Node head2) {
		if ((head1 == null) && (head2 == null)) {
			return;
		}
		Node current1 = head1;
		Node current2 = head2;
		
		while (current1!=null) {
			if(current2!=null) {
				Node next1 = current1.next;
				Node next2 = current2.next;
				current1.next = current2;
				current2.next=next1;
				current1=next1;
				current2=next2;
			}else {
				break;
			}
		}
	}

	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}
}
