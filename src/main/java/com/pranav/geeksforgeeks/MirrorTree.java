package com.pranav.geeksforgeeks;

/*http://practice.geeksforgeeks.org/problems/mirror-tree/1
*/public class MirrorTree {
	class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	class GfG {
		void mirror(Node node) {
			if(node==null){
				return ;
			}else {
				mirror(node.left);
				mirror(node.right);
				Node temp = node.left;
				node.left=node.right;
				node.right=temp;
			}
			
		}
	}
}
