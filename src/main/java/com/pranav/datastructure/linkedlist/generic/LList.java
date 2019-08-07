package com.pranav.datastructure.linkedlist.generic;

public class LList<E extends Comparable<E>> {
	private Node<E> head;

	public void print() {
		Node<E> current = head;
		while (current != null) {
			System.out.print(current.getData() + " -> ");
			current = current.getNext();
		}
	}

	public void addAtStart(Node<E> newNode) {
		if (head == null) {
			head = newNode;
		} else {
			newNode.setNext(head);
			head = newNode;
		}
	}

	public void selectionSort() {
		Node<E> temp = head;
		while (temp != null) {
			Node<E> min = temp;
			Node<E> r = temp.getNext();
			while (r != null) {
				if (min.getData().compareTo(r.getData()) > 0)
					min = r;
				r = r.getNext();
			}
			E x = temp.getData();
			temp.setData(min.getData());
			min.setData(x);
			temp = temp.getNext();
		}
	}

	public boolean search(E x) {
		Node<E> current = head;
		while (current != null) {
			if (current.getData().compareTo(x) == 0)
				return true;
			current = current.getNext();
		}

		return false;
	}

}
