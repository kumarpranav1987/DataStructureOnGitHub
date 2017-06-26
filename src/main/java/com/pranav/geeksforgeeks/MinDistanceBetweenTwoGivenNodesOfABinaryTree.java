package com.pranav.geeksforgeeks;
/*http://practice.geeksforgeeks.org/problems/min-distance-between-two-given-nodes-of-a-binary-tree/1
*/public class MinDistanceBetweenTwoGivenNodesOfABinaryTree {
	class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	/*
	 * Should return minimum distance between a and b in a tree with given root
	 */
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
		int findDistance(Node fromNode,int data){
			if(fromNode == null){
				return 0;
			}else if(fromNode.data==data) {
				return 1;
			}
			
			int left = findDistance(fromNode.left, data);
			int right=0; 
			if(left==0){
				right = findDistance(fromNode.right, data);	
			}
			if(left>0){
				return left+1;
			}else if (right>0) {
				return right+1;
			}else {
				return 0;
			}
		}
		
		int findDist(Node root, int a, int b) {
			Node lca = LCA(root, a, b);
			int lofA = findDistance(root, a)-1;
			int lofb = findDistance(root, b)-1;
			int l = findDistance(root, lca.data)-1;
			return (lofA+lofb-(2*l));
			
		}
	}
}
