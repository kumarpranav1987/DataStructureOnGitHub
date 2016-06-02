package com.pranav.datastructure.linkedlist;

public class LList {
	private Node head;

	public void print() {
		Node current = head;
		while (current != null) {
			System.out.print(current.getData() + " -> ");
			current = current.getNext();
		}
	}

	public void insertLast(int data) {
		Node temp = new Node();
		temp.setData(data);
		temp.setNext(null);
		if (head == null) {
			head = temp;
		} else {
			Node current = head;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(temp);
		}
	}
}
