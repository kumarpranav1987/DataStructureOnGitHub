package com.pranav.datastructure.linkedlist.generic;

public class Main {
	public static void main(String[] args) {
		LList<Integer> ll = new LList<Integer>();
		ll.addAtStart(new Node<Integer>(10));
		ll.addAtStart(new Node<Integer>(5));
		ll.addAtStart(new Node<Integer>(1));
		ll.addAtStart(new Node<Integer>(200));
		ll.addAtStart(new Node<Integer>(15));
		ll.print();
		ll.selectionSort();
		System.out.println("\nAfter Sorting");
		ll.print();
	}
}
