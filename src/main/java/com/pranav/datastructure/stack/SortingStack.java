package com.pranav.datastructure.stack;

public class SortingStack {
	int top;
	int maxSize;

	int myArrStack[];

	public SortingStack(int size) {
		this.maxSize = size;
		this.myArrStack = new int[maxSize];

		top = -1;
	}

	public void push(int n) {
		if (isFull()) {

			System.out.println("The stack is full");
		} else
			top++;
		myArrStack[top] = n;

	}

	public int pop() {
		int tempTop = 0;
		if (isEmpty()) {
			System.out.println("The stack is Empty");
			return 1;
		} else
			tempTop = top;

		top--;

		return myArrStack[tempTop];

	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isFull() {
		return (maxSize - 1 == top);
	}

	public int peak() {
		return myArrStack[top];
	}

}