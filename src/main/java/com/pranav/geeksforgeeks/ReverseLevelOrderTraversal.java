package com.pranav.geeksforgeeks;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*http://practice.geeksforgeeks.org/problems/reverse-level-order-traversal/1
*/
public class ReverseLevelOrderTraversal {
	class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	class GfG {
		void reversePrint(Node node) {
			Queue<Node> queue = new LinkedList<>();
			Stack<Node> stack = new Stack<>();
			if (node == null) {
				return;
			} else {
				queue.add(node);
				while (!queue.isEmpty()) {
					Node qNode = queue.remove();
					if (qNode.right != null) {
						queue.add(qNode.right);
					}
					if (qNode.left != null) {
						queue.add(qNode.left);
					}
					stack.push(qNode);
				}
				while (!stack.isEmpty()) {
					System.out.print(stack.pop().data + " ");
				}
			}
		}
	}
}
