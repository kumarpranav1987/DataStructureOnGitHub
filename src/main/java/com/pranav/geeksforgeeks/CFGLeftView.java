package com.pranav.geeksforgeeks;

import java.util.LinkedList;
import java.util.Queue;

public class CFGLeftView {
	void leftView(Node root) {
		if(root == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		Node previous=null;
		queue.add(root);
		queue.add(null);
	
		while (!queue.isEmpty()) {
			Node currentNode = queue.remove();
			if(currentNode == null) {
				if(queue.isEmpty()) {
					break;
				}else {
					previous=currentNode;
					queue.add(null);
				}
			}else {
				if(previous==null) {
					System.out.print(currentNode.data+" ");
				}
				if(currentNode.left!=null) {
					queue.add(currentNode.left);
				}
				if(currentNode.right!=null) {
					queue.add(currentNode.right);
				}
				previous=currentNode;
			}
		}
	}

	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}

	}
}
