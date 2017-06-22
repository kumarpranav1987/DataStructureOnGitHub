package com.pranav.geeksforgeeks;
/*http://practice.geeksforgeeks.org/problems/root-to-leaf-path-sum/1
*/public class RootToLeafPathSum {
	
	class Node
	{
	    int data;
	    Node left, right;

	    Node(int item)
	    {
	        data = item;
	        left = right = null;
	    }
	} 

	class GfG
	{
	    /*you are required to complete this function */
	    boolean hasPathSum(Node node, int sum)
	    {
	        if((node==null)){
	        	return false;
	        }else if((node.left==null)&&(node.right==null)&&(sum==node.data)){
				return true;
			}else {
				return hasPathSum(node.left, sum-node.data)||hasPathSum(node.right, sum-node.data);
			}
	    }
	}
}
