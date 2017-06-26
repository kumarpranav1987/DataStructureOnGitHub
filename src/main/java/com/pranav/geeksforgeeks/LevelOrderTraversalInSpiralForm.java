package com.pranav.geeksforgeeks;

import java.util.LinkedList;
import java.util.Queue;

/*http://practice.geeksforgeeks.org/problems/level-order-traversal-in-spiral-form/1
*/
public class LevelOrderTraversalInSpiralForm {
	// A Binary Tree node
	class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	class GfG {
		void printSpiral(Node node) {
			Queue<Node> queue = new LinkedList<>();
			queue.add(node);
			queue.add(null);
			boolean left = true;
			while (!queue.isEmpty()) {
				Node currentNode = queue.remove();
				if (currentNode != null) {
					System.out.print(currentNode.data + " ");
					if (left) {
						if (currentNode.left != null) {
							queue.add(currentNode.left);
						}
						if (currentNode.right != null) {
							queue.add(currentNode.right);
						}
					} else {
						if (currentNode.right != null) {
							queue.add(currentNode.right);
						}
						if (currentNode.left != null) {
							queue.add(currentNode.left);
						}
					}
				} else {
					if(!queue.isEmpty()){
						left = left ? false:true;
						queue.add(null);
					}
				}
			}
		}
	}

}
