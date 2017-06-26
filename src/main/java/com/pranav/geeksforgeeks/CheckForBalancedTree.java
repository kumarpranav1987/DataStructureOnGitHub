package com.pranav.geeksforgeeks;

/*http://practice.geeksforgeeks.org/problems/check-for-balanced-tree/1
*/public class CheckForBalancedTree {
	class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = right = null;
		}
	}

	class GfG {

		/*
		 * This function should return tree if passed tree is balanced, else
		 * false. Time complexity should be O(n) where n is number of nodes in
		 * tree
		 */
		boolean isBalanced(Node root) {
			if(root==null){
				return true;
			}else {
				int leftHeight= getHeight(root.left);
				int rightHeight = getHeight(root.right);
				return ((Math.abs(leftHeight-rightHeight)<=1)&&(isBalanced(root.left))&&(isBalanced(root.right)));
			}
			
		}

		int getHeight(Node root) {
			if (root == null) {
				return 0;
			} else if ((root.left == null) && (root.right == null)) {
				return 1;
			}
			return 1 + Integer.max(getHeight(root.left), getHeight(root.right));
		}
	}

}
