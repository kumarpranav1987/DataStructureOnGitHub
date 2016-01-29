package com.pranav.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

class Node {
	Node() {

	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	private int data;
	private Node left;
	private Node right;
}

class BinaryTree {
	Node root;

	BinaryTree(int data) {
		this.root = new Node();
		this.root.setData(data);
	}

	void insertLeft(Node current, int data) {
		Node temp = new Node();
		temp.setData(data);
		current.setLeft(temp);

	}

	void insertRight(Node current, int data) {
		Node temp = new Node();
		temp.setData(data);
		;
		current.setRight(temp);
	}

	void inorder(Node root) {
		if (root == null)
			return;
		inorder(root.getLeft());
		System.out.print(root.getData() + "  ");
		inorder(root.getRight());
	}

	void rightView(Node root) {
		int level = -1;
		Queue<QueueNode> q = new LinkedList<>();
		if (root == null)
			return;
		QueueNode qn = new QueueNode(root, 0);
		q.add(qn);
		while (!q.isEmpty()) {
			QueueNode current = q.poll();
			if (current.currentLevel > level) {
				System.out.print(" " + current.getNode().getData());
				level++;
			}
			if (current.getNode().getRight() != null)
				q.add(new QueueNode(current.getNode().getRight(), current.currentLevel + 1));
			if (current.getNode().getLeft() != null)
				q.add(new QueueNode(current.getNode().getLeft(), current.currentLevel + 1));

		}

	}

	int height(Node root) {
		if (root == null)
			return 0;
		int l = height(root.getLeft());
		int r = height(root.getRight());
		if (l > r)
			return l + 1;
		else
			return r + 1;

	}

	private static class QueueNode {

		public QueueNode(Node node, int currentLevel) {
			super();
			this.node = node;
			this.currentLevel = currentLevel;
		}

		Node node;

		public Node getNode() {
			return node;
		}

		public void setNode(Node node) {
			this.node = node;
		}

		public int getCurrentLevel() {
			return currentLevel;
		}

		public void setCurrentLevel(int currentLevel) {
			this.currentLevel = currentLevel;
		}

		int currentLevel;
	}

	void deleteTree(Node root) {
		if (root == null)
			return;
		deleteTree(root.getLeft());
		deleteTree(root.getRight());
		root = null;
	}

	void convertToMirrorImage(Node root) {
		if (root == null)
			return;
		convertToMirrorImage(root.getLeft());
		convertToMirrorImage(root.getRight());
		Node temp = root.getLeft();
		root.setLeft(root.getRight());
		root.setRight(temp);

	}

}

class TreeExample {

	public static void main(String args[]) throws Exception {
		BinaryTree b = new BinaryTree(1);
		b.insertLeft(b.root, 2);
		b.insertRight(b.root, 3);
		b.insertLeft(b.root.getLeft(), 4);
		b.insertRight(b.root.getLeft(), 5);
		b.insertLeft(b.root.getRight(), 6);
		b.insertRight(b.root.getRight(), 7);
		System.out.println("*********Inorder Traversal ********");
		b.inorder(b.root);
		System.out.println("\n*********Right View Of Tree*********\n");
		b.rightView(b.root);
		System.out.println("\n*********Height Of Tree*********");
		System.out.println(b.height(b.root));
		/*
		 * System.out.println(
		 * "*********Inorde after Deleting Tree ***************");
		 * b.deleteTree(b.root); b.inorder(b.root);
		 */
		b.convertToMirrorImage(b.root);
		System.out.println("*********Inorder Traversal After Convertion to mirror image********");
		b.inorder(b.root);

	}
}