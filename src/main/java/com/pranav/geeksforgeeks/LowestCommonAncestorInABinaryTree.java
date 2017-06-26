package com.pranav.geeksforgeeks;

/*http://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-binary-tree/1
*/
public class LowestCommonAncestorInABinaryTree {
	class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	class GfG {
		Node LCA(Node root, int n1, int n2) {
			if(root==null){
				return null;
			}else if ((root.data==n1)||(root.data==n2)) {
				return root;
			}
			Node left = LCA(root.left, n1, n2);
			Node right = LCA(root.right, n1, n2);
			if((left!=null)&&(right!=null)){
				return root;
			}else {
				
				return left==null?right:left;
			}
		}
	}
}
