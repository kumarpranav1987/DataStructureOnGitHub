package com.pranav.geeksforgeeks;

import java.util.Scanner;

/*http://practice.geeksforgeeks.org/problems/array-to-bst/0
*/
public class ArrayToBST {
	class Node {
		int data;
		Node left;
		Node right;
	}

	public static void main(String[] args) {
		ArrayToBST bst = new ArrayToBST();
		bst.extracted();
	}

	private void extracted() {
		Scanner s = new Scanner(System.in);
		int numberOfTestCases = s.nextInt();
		for (int i = 0; i < numberOfTestCases; i++) {
			int size = s.nextInt();
			int[] input = new int[size];
			for (int j = 0; j < size; j++) {
				input[j] = s.nextInt();
			}
			Node root = buildTree(input, 0, size - 1);
			preorder(root);
				System.out.println();
			
		}
	}

	private void preorder(Node root) {
		if(root==null){
			return;
		}else {
			System.out.print(root.data+" ");
			preorder(root.left);
			preorder(root.right);
		}
		
	}

	private Node buildTree(int[] input, int start, int end) {
		if (start > end) {
			return null;
		} else if (start == end) {
			Node temp = new Node();
			temp.left = null;
			temp.right = null;
			temp.data = input[start];
			return temp;
		} else {
			int indexOfRoot = (start + end) / 2;
			Node left = buildTree(input, start, indexOfRoot - 1);
			Node right = buildTree(input, indexOfRoot + 1, end);

			Node root = new Node();
			root.data = input[indexOfRoot];
			root.left = left;
			root.right = right;
			return root;
		}

	}
}
