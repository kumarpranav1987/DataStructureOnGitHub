package com.pranav.geeksforgeeks;
/*http://practice.geeksforgeeks.org/problems/transform-to-sum-tree/1
*/public class TransformToSumTree {
	class Tree{
	int data;
	Tree left,right;
	Tree(int d){
		data=d;
		left=null;
		right=null;
	}
	}
	class GfG{
	    public void toSumTree(Tree root){
	         sumTree(root);
	    }
	    public int sumTree(Tree root) {
			if(root == null){
				return 0;
			}else {
				int sumOfLeftSubTree= sumTree(root.left);
				int sumOfRightSubTree=sumTree(root.right);
				int data = root.data;
				root.data=sumOfLeftSubTree+sumOfRightSubTree;
				return data+root.data;
			}
			
		}
	}
	
}
