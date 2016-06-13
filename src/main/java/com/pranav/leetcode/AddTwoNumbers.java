package com.pranav.leetcode;
/**
 * https://leetcode.com/problems/add-two-numbers/
 * @author Pranav.Kumar
 *
 */
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
	public void print(ListNode head){
		ListNode current = head;
		while (current!=null) {
			System.out.print(current.val + "  " );
			current = current.next;
		}
	}
}

public class AddTwoNumbers {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next=new ListNode(2);
		ListNode l2 = new ListNode(3);
		l2.next = new ListNode(4);
		ListNode result = addTwoNumbers(l1, l2);
		result.print(result);

	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		ListNode head = null;
		ListNode current = null;
		if (l1 == null && l2 == null) {
			return head;
		} else {
			while (l1 != null && l2 != null) {
				ListNode temp = new ListNode((l1.val + l2.val+carry) % 10);
				carry = (l1.val + l2.val+carry) / 10;
				if (head == null) {
					head = temp;
					current = temp;
				} else {
					current.next = temp;
					current = temp;
				}
				l1=l1.next;
				l2=l2.next;
			}
			
			if(l1!=null){
				while (l1!=null) {
					ListNode temp = new ListNode((l1.val + carry) % 10);
					carry = (l1.val +carry) / 10;
					if (head == null) {
						head = temp;
						current = temp;
					} else {
						current.next = temp;
						current = temp;
					}
					l1=l1.next;
				}
				
			}else if(l2!=null){
				while (l2!=null) {
					ListNode temp = new ListNode((l2.val + carry) % 10);
					carry = (l2.val +carry) / 10;
					if (head == null) {
						head = temp;
						current = temp;
					} else {
						current.next = temp;
						current = temp;
					}
					l2=l2.next;
				}
				
			
			}
			
			if(carry!=0){
				ListNode temp = new ListNode(carry);
				current.next=temp;
			}
		}
		return head;
	}
}
