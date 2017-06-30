package com.pranav.geeksforgeeks;

import java.util.Scanner;
import java.util.Stack;
/*http://practice.geeksforgeeks.org/problems/preorder-to-postorder/0
*/
public class PreorderToPostorder {
	class Node {
		int data;
		Node left;
		Node right;
	}

	public static void main(String[] args) {
		PreorderToPostorder main = new PreorderToPostorder();
		main.extracted();
	}

	private void extracted() {
		Scanner s = new Scanner(System.in);
		int numberOfTestCases = s.nextInt();
		for (int i = 0; i < numberOfTestCases; i++) {
			int size = s.nextInt();
			int[] pre = new int[size];
			for (int j = 0; j < size; j++) {
				pre[j] = s.nextInt();
			}
			boolean result = isBST(pre);
			if (result) {
				Node root = buildTree(pre, 0, pre.length - 1);
				postOrder(root);
			} else {
				System.out.print("NO");
			}
			System.out.println();
		}
	}

	private void postOrder(Node root) {
		if(root==null){
			return;
		}else {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data+" ");
		}
		
	}

	private Node buildTree(int[] pre, int start, int end) {
		if (start > end) {
			return null;
		} else if (start == end) {
			Node temp = new Node();
			temp.data = pre[start];
			temp.left = null;
			temp.right = null;
			return temp;
		} else {
			int indexOfRightRoot = findRightRoot(pre,pre[start], start + 1, end);
			if(indexOfRightRoot!=-1){
				Node left = buildTree(pre, start + 1, indexOfRightRoot - 1);
				Node right = buildTree(pre, indexOfRightRoot, end);
				Node root = new Node();
				root.data = pre[start];
				root.left = left;
				root.right = right;
				return root;
			}else {
				Node left = buildTree(pre, start + 1, end);
				Node root = new Node();
				root.data = pre[start];
				root.left = left;
				root.right = null;
				return root;
			}
			
		}

	}

	private int findRightRoot(int[] pre,int root, int start, int end) {
		int result=-1;
		for(int i=start;i<=end;i++){
			if(pre[i]>root){
				result=i;
				break;
			}
		}
		return result;
	}

	private boolean isBST(int[] pre) {
		Stack<Integer> stack = new Stack<>();
		int root = Integer.MIN_VALUE;
		boolean result = true;
		for (int i = 0; i < pre.length; i++) {
			if (pre[i] < root) {
				result = false;
				break;
			} else if (stack.isEmpty()) {
				stack.push(pre[i]);
			} else {
				while ((!stack.isEmpty()) && (stack.peek() < pre[i])) {
					root = stack.pop();
				}
				stack.push(pre[i]);
			}
		}
		return result;
	}
}
