package com.pranav.geeksforgeeks;

import java.util.Stack;

/*http://practice.geeksforgeeks.org/problems/check-if-subtree/1
*/public class CheckIfSubtree {
	class Tree {
		int data;
		Tree left, right;

		Tree(int d) {
			data = d;
			left = null;
			right = null;
		}
	}

	class GfG {
		public boolean isSubtree(Tree T, Tree S) {
			Stack<Tree> stack = new Stack<>();
			findAllRoots(T, S, stack);
			boolean result = false;
			while (!stack.isEmpty()) {
				result = checkIfSame(stack.pop(), S);
				if (result) {
					break;
				}
			}
			return result;
		}

		private boolean checkIfSame(Tree root1, Tree root2) {
			if ((root1 == null) && (root2 == null)) {
				return true;
			} else if (((root1 == null) && (root2 != null)) || (((root1 != null) && (root2 == null)))) {
				return false;
			}
			return (root1.data == root2.data) && (checkIfSame(root1.left, root2.left))
					&& (checkIfSame(root1.right, root2.right));
		}

		public void findAllRoots(Tree T, Tree S, Stack<Tree> result) {
			if (T == null) {
				return;
			} else {
				if (T.data == S.data) {
					result.push(T);
				}
				findAllRoots(T.left, S, result);
				findAllRoots(T.right, S, result);
			}
		}
	}
}
