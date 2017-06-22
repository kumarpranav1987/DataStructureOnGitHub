package com.pranav.geeksforgeeks;
/*http://practice.geeksforgeeks.org/problems/two-mirror-trees/1
*/
public class TwoMirrorTrees {
	
	class Node
	{
	    int data;
	    Node left, right;
	   Node(int item)    {
	        data = item;
	        left = right = null;
	    }
	} 

	class GfG
	{
	    boolean areMirror(Node a, Node b) 
	    {
	    	if((a==null)&&(b==null)){
	    		return true;
	    	}else if ((a==null)&&(b!=null)) {
				return false;
			}else if((a!=null)&&(b==null)) {
				return false;
			}else {
				return areMirror(a.left, b.right) && areMirror(a.right, b.left) && (a.data==b.data);
			}
	    }
	}
}
