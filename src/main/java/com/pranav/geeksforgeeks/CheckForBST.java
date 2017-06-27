package com.pranav.geeksforgeeks;

public class CheckForBST {
	class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	class GfG {
		class Result {
			int min=Integer.MAX_VALUE;
			int max=Integer.MIN_VALUE;
		}

		int isBST(Node root) {
			Result result = new Result();
			return isBSTT(root, result) ? 1 : 0;
		}

		boolean isBSTT(Node root, Result result) {
			if (root == null) {
				return true;
			} else {
				Result leftResult = new Result();
				boolean left = isBSTT(root.left, leftResult);
				Result rightResult = new Result();
				boolean right = isBSTT(root.right, rightResult);
				result.max = Math.max(leftResult.max, Math.max(rightResult.max, root.data));
				result.min = Math.min(leftResult.min, Math.min(rightResult.min, root.data));
				return (left && right && ((root.data > leftResult.max) && (root.data < rightResult.min)));
			}
		}
	}
}
