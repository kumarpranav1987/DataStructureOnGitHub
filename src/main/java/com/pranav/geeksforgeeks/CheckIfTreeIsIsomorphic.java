package com.pranav.geeksforgeeks;
/*http://practice.geeksforgeeks.org/problems/check-if-tree-is-isomorphic/1
*/public class CheckIfTreeIsIsomorphic {
	class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = right = null;
		}
	}

	class GfG {
		public boolean isIsomorphic(Node root1, Node root2) {
			if ((root1 == null) && (root2 == null)) {
				return true;
			} else if (((root1 != null) && (root2 == null)) || ((root1 == null) && (root2 != null))) {
				return false;
			} else {
				boolean current = (root1.data == root2.data);
				boolean left=false;
				boolean right=false;
				if(((root1.left!=null)&&(root2.left!=null))&&(root1.left.data==root2.left.data)){
					left=isIsomorphic(root1.left, root2.left);
					right =isIsomorphic(root1.right, root2.right);
				}else {
					left=isIsomorphic(root1.left, root2.right);
					right =isIsomorphic(root1.right, root2.left);
				}
				return current&&left&&right;
			}
		}
	}
}
