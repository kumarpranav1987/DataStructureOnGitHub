package com.pranav.datastructure.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class Count {
	private int i;

	public Count(int i) {
		this.i = i;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public void incrementI() {
		i++;
	}
}

class Node {

	private int data;
	private Node left;
	private Node right;

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
}

class BinaryTree {
	private Node root;

	BinaryTree(int data) {
		this.root = new Node();
		this.root.setData(data);
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	void insertLeft(Node current, int data) {
		Node temp = new Node();
		temp.setData(data);
		current.setLeft(temp);

	}

	void insertRight(Node current, int data) {
		Node temp = new Node();
		temp.setData(data);
		current.setRight(temp);
	}

	public void inorder() {
		inorder(getRoot());
	}

	void inorder(Node root) {
		if (root == null)
			return;
		inorder(root.getLeft());
		System.out.print(root.getData() + "  ");
		inorder(root.getRight());
	}

	public void rightView() {
		rightView(this.root);
	}

	private void rightView(Node root) {
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

	public int height() {
		return height(getRoot());
	}

	private int height(Node root) {
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

	public void deleteTree() {
		deleteTree(getRoot());
	}

	private void deleteTree(Node root) {
		if (root == null)
			return;
		deleteTree(root.getLeft());
		deleteTree(root.getRight());
		root = null;
	}

	public void convertToMirrorImage() {
		convertToMirrorImage(getRoot());
	}

	private void convertToMirrorImage(Node root) {
		if (root == null)
			return;
		convertToMirrorImage(root.getLeft());
		convertToMirrorImage(root.getRight());
		Node temp = root.getLeft();
		root.setLeft(root.getRight());
		root.setRight(temp);

	}

	public int getMax() {
		return getMax(getRoot());
	}

	private int getMax(Node root) {
		if (null == root)
			return Integer.MIN_VALUE;
		int result = root.getData();
		int lresult = getMax(root.getLeft());
		int rresult = getMax(root.getRight());
		if (lresult > result) {
			result = lresult;
		}
		if (rresult > result) {
			result = rresult;
		}
		return result;
	}

	public void levelOrederPerLine() {
		if (null == root) {
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			System.out.print("\n");
			int size = queue.size();
			while (size > 0) {
				Node current = queue.poll();
				System.out.print(current.getData() + "  ");
				if (current.getLeft() != null) {
					queue.add(current.getLeft());
				}
				if (current.getRight() != null) {
					queue.add(current.getRight());
				}
				size--;
			}
		}
	}

	public void inorderWithoutRecursion() {
		Node current = root;
		boolean done = false;
		Stack<Node> stack = new Stack<>();
		while (!done) {
			if (current != null) {
				stack.push(current);
				current = current.getLeft();
			} else {
				if (stack.isEmpty()) {
					done = true;
				} else {
					Node node = stack.pop();
					System.out.print(node.getData() + " ");
					// if(node.getRight()!=null)
					current = node.getRight();
				}
			}
		}

	}

	public void preorderWithoutRecursion() {
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			Node node = stack.pop();
			System.out.print(node.getData() + " ");
			if (node.getRight() != null) {
				stack.push(node.getRight());
			}
			if (node.getLeft() != null) {
				stack.push(node.getLeft());
			}
		}
	}

	public void postOrderWithoutRecursionUsingTwoStacks() {
		Stack<Node> stack = new Stack<>();
		Stack<Node> finalStack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			Node node = stack.pop();
			finalStack.push(node);
			if (node.getLeft() != null) {
				stack.push(node.getLeft());
			}
			if (node.getRight() != null) {
				stack.push(node.getRight());
			}
		}
		while (!finalStack.isEmpty()) {
			System.out.print(finalStack.pop().getData() + " ");
		}

	}

	public void postorderTraversalWithoutRecuesionUsingOneStack() {
		Stack<Node> stack = new Stack<>();
		Node root = getRoot();
		do {
			while (root != null) {
				if (root.getRight() != null)
					stack.push(root.getRight());
				stack.push(root);
				root = root.getLeft();
			}
			root = stack.pop();
			if (!stack.isEmpty() && root.getRight() == stack.peek()) {
				stack.pop();
				stack.push(root);
				root = root.getRight();
			} else {
				System.out.print(root.getData() + " ");
				root = null;
			}
		} while (!stack.isEmpty());

	}

	public int maxRootToLeafPathSum() {
		return maxRootToLeafPathSum(root);
	}

	private int maxRootToLeafPathSum(Node root) {
		if (root == null) {
			return 0;
		}
		int lSum = maxRootToLeafPathSum(root.getLeft());
		int rSum = maxRootToLeafPathSum(root.getRight());
		return ((lSum + root.getData()) > (rSum + root.getData())) ? (lSum + root.getData()) : (rSum + root.getData());
	}

	public void convertToBST() {
		List<Integer> list = new ArrayList<>();
		populateListWithTreeData(root, list);
		Collections.sort(list);
		Count i = new Count(0);
		replaceWhiletravesringInorder(root, list, i);
	}

	private void replaceWhiletravesringInorder(Node root, List<Integer> list, Count i) {
		if (root == null) {
			return;
		}
		replaceWhiletravesringInorder(root.getLeft(), list, i);
		root.setData(list.get(i.getI()));
		i.incrementI();
		replaceWhiletravesringInorder(root.getRight(), list, i);
	}

	private void populateListWithTreeData(Node root, List<Integer> list) {
		if (root == null) {
			return;
		}
		populateListWithTreeData(root.getLeft(), list);
		list.add(root.getData());
		populateListWithTreeData(root.getRight(), list);
	}

	public boolean isBST_NotEfficient() {
		return isBST_NotEfficient(root);
	}

	private boolean isBST_NotEfficient(Node root) {
		if (root == null) {
			return true;
		}

		return false;
	}

	public boolean isBST_UsingInorderTraversal() {
		Node prviouslyTraversedNode = new Node();
		prviouslyTraversedNode.setData(-1);
		return isBST_UsingInorderTraversal(root, prviouslyTraversedNode);
	}

	private boolean isBST_UsingInorderTraversal(Node root, Node prviouslyTraversedNode) {
		if (root == null) {
			return true;
		}
		return isBST_UsingInorderTraversal(root.getLeft(), prviouslyTraversedNode);
	}

	public int maxInSubTreeWithGivenRoot(Node root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		int lMax = maxInSubTreeWithGivenRoot(root.getLeft());
		int rmax = maxInSubTreeWithGivenRoot(root.getRight());
		int max = (lMax > rmax ? lMax : rmax);
		max = (max > root.getData() ? max : root.getData());
		return max;
	}

	public void printBoundary() {
		Node myRoot = this.root;
		while (myRoot != null && (myRoot.getLeft() != null && myRoot.getRight() != null)) {
			System.out.print(myRoot.getData() + " ");
			myRoot = myRoot.getLeft();
		}
		printLeaf(this.root);
		printRight(root);
	}

	private void printLeaf(Node root) {
		if (root == null) {
			return;
		}
		printLeaf(root.getLeft());
		if (root.getLeft() == null && root.getRight() == null) {
			System.out.print(root.getData() + " ");
		}
		printLeaf(root.getRight());

	}

	private void printRight(Node root) {
		if (root == null) {
			return;
		}
		printRight(root.getRight());
		if (root.getLeft() != null && root.getRight() != null) {
			System.out.print(root.getData() + " ");
		}
	}

	/* Complete the function to get diameter of a binary tree */
	int diameter(Node node) {
		Node max = new Node();
		max.setData(0);
		diameter(node, max);
		return max.getData();
	}

	private int diameter(Node node, Node max) {
		if (node == null) {
			max.setData(0);
			return 0;
		} else {
			int l = diameter(node.getLeft(), max);
			int r = diameter(node.getRight(), max);
			int height = Integer.max(l, r) + 1;
			if ((l + r + 1) > max.getData()) {
				max.setData(l + r + 1);
			}
			return height;
		}
	}

	public void printPaths(Node root) {
		Queue<Node> queue = new LinkedList<>();
		printPaths(root, queue);
	}

	private void printPaths(Node root, Queue<Node> queue) {
		if (root == null) {
			return;
		} else if ((root.getLeft() == null) && (root.getRight() == null)) {
			printQueue(queue);
			System.out.print(root.getData() + " ");
			System.out.print("# ");
		} else {
			queue.add(root);
			printPaths(root.getLeft(), queue);
			printPaths(root.getRight(), queue);
			queue.remove(root);
		}

	}

	private void printQueue(Queue<Node> queue) {
		for (Node node : queue) {
			System.out.print(node.getData() + " ");
		}
	}

	boolean hasPathSum(Node node, int sum) {
		if ((node == null)) {
			return false;
		} else if ((node.getLeft() == null) && (node.getRight() == null) && (sum == node.getData())) {
			return true;
		} else {
			return hasPathSum(node.getLeft(), sum - node.getData())
					|| hasPathSum(node.getRight(), sum - node.getData());
		}
	}

	int getSumOfAllLeaves(Node root) {
		if (root == null) {
			return 0;
		} else if ((root.getLeft() == null) && (root.getRight() == null)) {
			return root.getData();
		} else {
			return getSumOfAllLeaves(root.getLeft()) + getSumOfAllLeaves(root.getRight());
		}
	}
}

class TreeExample {

	public static void main(String args[]) throws Exception {
		BinaryTree b = new BinaryTree(1);
		
		b.insertLeft(b.getRoot(), 2);
		b.insertRight(b.getRoot(), 3);

		b.insertLeft(b.getRoot().getLeft(), 4);
		b.insertRight(b.getRoot().getLeft(), 5);
		b.insertLeft(b.getRoot().getRight(), 6);
		b.insertRight(b.getRoot().getRight(), 7);

		System.out.println("*********Inorder Traversal ********");
		b.inorder();
		System.out.println("\n*********Diameter ********");
		System.out.println(b.diameter(b.getRoot()));
		System.out.println("\n*********Roo to leaf Path ********");
		b.printPaths(b.getRoot());
		System.out.println("\n*********Hash Path Sum ********");
		System.out.println(b.hasPathSum(b.getRoot(), 3));
		System.out.println("\n*********Sum of All Leaves ********");
		System.out.println(b.getSumOfAllLeaves(b.getRoot()));
		/*
		 * System.out .println(
		 * "\n*********Inorder Without Recursion Traversal ********");
		 * b.inorderWithoutRecursion(); System.out .println(
		 * "\n**********Preorder Without Recursion*********************");
		 * b.preorderWithoutRecursion(); System.out .println(
		 * "\n********************Post Order Without Recursion Using Two Stacks"
		 * ); b.postOrderWithoutRecursionUsingTwoStacks(); System.out .println(
		 * "\n**********postorderTraversalWithoutRecuesionUsingOneStack**********"
		 * ); b.postorderTraversalWithoutRecuesionUsingOneStack();
		 * System.out.println("\n*********Right View Of Tree*********\n");
		 * b.rightView(); System.out.println(
		 * "\n*********Height Of Tree*********");
		 * System.out.println(b.height());
		 * 
		 * System.out.println(
		 * "*********Inorde after Deleting Tree ***************");
		 * b.deleteTree(b.root); b.inorder(b.root);
		 * 
		 * b.convertToMirrorImage(); System.out .println(
		 * "*********Inorder Traversal After Convertion to mirror image********"
		 * ); b.inorder(); System.out.println("\nMax Value in Tree = " +
		 * b.getMax()); System.out.println("\nlevelOrederPerLine");
		 * b.levelOrederPerLine();
		 * 
		 * System.out.println("\nMax Root To Leaf Path Sum = "
		 * +b.maxRootToLeafPathSum());
		 */
		// b.convertToBST();
		// System.out.println("\nAfter converting to bst\n");
		// b.inorder();
		// System.out.println("\n" + "Max = " +
		// b.maxInSubTreeWithGivenRoot(b.getRoot()));
		// System.out.println();
		// b.printBoundary();
	}
}