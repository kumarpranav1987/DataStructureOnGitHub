package com.pranav.datastructure.stack;

public class MainStackSort {

	public static void main(String[] args) {
		SortingStack myStack = new SortingStack(3);
		SortingStack helperStack = new SortingStack(3);

		myStack.push(17);
		myStack.push(44);
		myStack.push(19);
		myStack.push(33);
		myStack.push(21);

		while (!myStack.isEmpty()) {
			int tempStack = myStack.pop();

			while (!helperStack.isEmpty() && helperStack.peak() > tempStack) {

				myStack.push(helperStack.pop());
			}
			helperStack.push(tempStack);

		}
		while (!helperStack.isEmpty()) {
			int num = helperStack.pop();
			System.out.println(num);
		}
	}

}
