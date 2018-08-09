package com.pranav.geeksforgeeks;

public class GFG1 {

	void printKdistance(Node root, int k) {
		if (root == null) {
			return;
		}
		if (k == 0) {
			System.out.print(root.data + " ");
			return;
		}
		printKdistance(root.left, k - 1);
		printKdistance(root.right, k - 1);
	}

	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}
}
