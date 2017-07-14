package com.pranav.geeksforgeeks;

import java.util.LinkedList;
import java.util.Queue;
/*http://practice.geeksforgeeks.org/problems/connect-nodes-at-same-level/1
*/public class ConnectNodesAtSameLevel {
	class Node {
		int data;
		Node left, right, nextRight;

		Node(int item) {
			data = item;
			left = right = nextRight = null;

		}
	}

	class GfG {
		void connect(Node root) {
			if (root != null) {
				Queue<Node> queue = new LinkedList<>();
				queue.add(root);
				queue.add(null);
				while (!queue.isEmpty()) {
					Node current = queue.remove();
					if ((current == null) && (!queue.isEmpty())) {
						queue.add(null);
					} else if(current!=null){
						if (current.left != null) {
							queue.add(current.left);
						}
						if (current.right != null) {
							queue.add(current.right);
						}
						current.nextRight = queue.peek();
					}
				}
			}
		}
	}
}
