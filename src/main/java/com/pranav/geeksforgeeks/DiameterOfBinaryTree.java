package com.pranav.geeksforgeeks;

import java.util.LinkedList;
import java.util.Queue;
/*http://practice.geeksforgeeks.org/problems/maximum-width-of-tree/1
*/public class DiameterOfBinaryTree {
	class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	class GfG {

		int getMaxWidth(Node root) {
			Queue<Node> queue = new LinkedList<>();
			if (root == null) {
				return 0;
			} else {
				int result = 0;
				queue.add(root);
				queue.add(null);
				int count = 0;
				while (!queue.isEmpty()) {
					Node qNode = queue.remove();
					if (qNode != null) {
						count++;
						if (qNode.left != null) {
							queue.add(qNode.left);
						}
						if (qNode.right != null) {
							queue.add(qNode.right);
						}
					}else {
						if(!queue.isEmpty()){
							queue.add(null);
						}
						if(count>result){
							result=count;
						}
						count=0;
					}
				}
				return result;
			}
			
		}
	}
}