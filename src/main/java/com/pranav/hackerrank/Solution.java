package com.pranav.hackerrank;

import java.util.Scanner;


public class Solution {
public static class Node {
	private int data;
	private Node next;
	public Node(int data) {
		this.data = data;
		
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
}

public static class Stack{
	private Node head;

	public void push(int data){
		if(head == null){
			head = new Node(data);
		}else {
			Node n = new Node(data);
			n.setNext(head);
			head = n;
		}
	}
	
	public int pop(){
		int num=0;
		if( head !=null){
			num = head.getData();
			head = head.getNext();
			
		}
		return num;
	}
	
	public int peek(){
		int num =0;
		if (head !=null) {
			num = head.getData();
		}
		return num;
	}
	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public boolean isEmpty() {
		if(head == null){
			return true;
		}else {
			return false;
		}
		
	}
	
}
	public static void main(String[] args) {
		
		
		Scanner s = new Scanner(System.in);
		int testCases = s.nextInt();
		Stack mainStack = new Stack();
		Stack maxStack = new Stack();
		String currentInput;
		for (int i = 0; i < testCases; i++) {
			currentInput = s.nextLine();
			if (!currentInput.isEmpty()) {
				String[] numbers = currentInput.split("\\s");
				if (Integer.parseInt(numbers[0]) == 1) {
					int currentnum = Integer.parseInt(numbers[1]);
					if (mainStack.isEmpty()) {
						mainStack.push(currentnum);
						maxStack.push(currentnum);
					} else {
						mainStack.push(currentnum);
						if (currentnum > maxStack.peek()) {
							maxStack.push(currentnum);
						} else {
							maxStack.push(maxStack.peek());
						}
					}
				} else if (Integer.parseInt(numbers[0]) == 2) {
					mainStack.pop();
					maxStack.pop();
				} else if (Integer.parseInt(numbers[0]) == 3) {
					System.out.println(maxStack.peek());
				}
			}
		}
		s.close();
	}

}
