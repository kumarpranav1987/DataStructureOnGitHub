package com.pranav.datastructure.tree;

import javax.naming.spi.DirStateFactory.Result;

class BNode {
	private BNode left;
	private BNode right;
	private int data;

	public BNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public BNode getLeft() {
		return left;
	}

	public void setLeft(BNode left) {
		this.left = left;
	}

	public BNode getRight() {
		return right;
	}

	public void setRight(BNode right) {
		this.right = right;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

}

class BST {
	private BNode root;

	public BNode getRoot() {
		return root;
	}

	public void setRoot(BNode root) {
		this.root = root;
	}

	public void insert_Recursive(int data) {

		root = insert_Recursive(root, data);

	}

	private BNode insert_Recursive(BNode root, int data) {
		if (root == null) {
			root = new BNode(data);
			return root;
		}
		if (data > root.getData()) {
			root.setRight(insert_Recursive(root.getRight(), data));
		} else {
			root.setLeft(insert_Recursive(root.getLeft(), data));
		}
		return root;
	}

	public void delete_Iterative(int data) {
		BNode currentNode = root;
		BNode parentOfCurrent=null;
		while (currentNode != null && currentNode.getData() != data) {
			if (data > currentNode.getData()) {
				parentOfCurrent = currentNode;
				currentNode = currentNode.getRight();
			} else {
				parentOfCurrent = currentNode;
				currentNode = currentNode.getLeft();
			}
		}
		if (currentNode == null) {
			System.out.println("Data Not Found");
			return;
		}
		if (parentOfCurrent == null) {
			
		}
		/*Both Child exists*/
		if (currentNode.getLeft() != null && currentNode.getRight() != null) {
			BNode successor = currentNode.getRight();
			BNode parentOfSuccessor = currentNode;
			while (successor.getLeft()!=null) {
				parentOfSuccessor = successor;
				successor = successor.getLeft();
			}
			currentNode.setData(successor.getData());
			delete_OnlyRightChildExists(successor, parentOfSuccessor);
			
		}else if (currentNode.getLeft() != null) {/* Only left child exists*/
			delete_OnlyLeftChildExists(currentNode, parentOfCurrent);
		}else if(currentNode.getRight() != null){/* Only right child exists*/
			delete_OnlyRightChildExists(currentNode, parentOfCurrent);
		}else {/* Leaf*/
			if (parentOfCurrent == null) {
				this.root = null;
				return;
			}
			if(currentNode == parentOfCurrent.getLeft()){
				parentOfCurrent.setLeft(null);
			}else {
				parentOfCurrent.setRight(null);
			}
		}
	}

	private void delete_OnlyRightChildExists(BNode currentNode, BNode parentOfCurrent) {
		if (parentOfCurrent == null) {//Deleting root
			this.root = currentNode.getRight();
			return ;
		}
		/*Check if current node is left child or right child of its parent*/
		if (currentNode == parentOfCurrent.getLeft()) { 
			parentOfCurrent.setLeft(currentNode.getRight());
		}else {
			parentOfCurrent.setRight(currentNode.getRight());
		}
	}

	private void delete_OnlyLeftChildExists(BNode currentNode, BNode parentOfCurrent) {
		if (parentOfCurrent == null) {/*Deleting root*/
			this.root = currentNode.getLeft();
			return;
		}
		/*Check if current node is left child or right child of its parent*/
		if (currentNode == parentOfCurrent.getLeft()) { 
			parentOfCurrent.setLeft(currentNode.getLeft());
		}else {
			parentOfCurrent.setRight(currentNode.getLeft());
		}
	}

	public void insert_Iterative(int data){
		BNode currentNode = root;
		BNode parentOfCurrentNode =null;
		while (currentNode!=null ) {
			if (data > currentNode.getData()) {
				parentOfCurrentNode = currentNode;
				currentNode = currentNode.getRight();
			}else {
				parentOfCurrentNode = currentNode;
				currentNode = currentNode.getLeft();
			}
		}
		if (parentOfCurrentNode == null) {
			this.root = new BNode(data);
		}else {
			if (currentNode == parentOfCurrentNode.getLeft()) {
				parentOfCurrentNode.setLeft(new BNode(data));
			}else {
				parentOfCurrentNode.setRight(new BNode(data));
			}
		}
	}
	
	public int inorderSuccessorIterative(int data) {
		BNode currentNode = root;
		BNode probaleSuccessor = null;
		while (currentNode.getData() != data) {
			if (data > currentNode.getData()) {
				currentNode = currentNode.getRight();
			} else {
				probaleSuccessor = currentNode;
				currentNode = currentNode.getLeft();
			}
		}
		BNode successor = null;
		if (currentNode.getRight() != null) {
			successor = currentNode.getRight();
			while (successor.getLeft() != null) {
				successor = successor.getLeft();
			}
			return successor.getData();
		} else if (probaleSuccessor == null) {
			return -1;// No Successor exists
		} else {
			return probaleSuccessor.getData();
		}
	}
	
	/*public int inorderSuccessor(int data){
		return inorderSuccessor(data,root,null);
	}*/
	/*private int inorderSuccessor(int data, BNode currentNode, BNode parentOfCurrentNode) {
		if (currentNode == null) {
			return -1;// Take a value which does not exists in BST
		} else if (currentNode.getData() == data) {
			if (currentNode.getRight() != null) {
				BNode successor = currentNode.getRight();
				while (successor.getLeft() != null) {
					successor = successor.getLeft();
				}
				return successor.getData();
			} else {
				return -1;
			}
		} else {
			if (data > currentNode.getData()) {
				int result = inorderSuccessor(data, currentNode.getRight(), currentNode);
				if (result == -1) {
					if (currentNode == parentOfCurrentNode.getLeft()) {
						return parentOfCurrentNode.getData();
					} else {
						result = -1;
					}
				}
			} else {
				int result = inorderSuccessor(data, currentNode.getLeft(), currentNode);
				if (result == -1) {
					if (currentNode == parentOfCurrentNode.getLeft()) {
						result = parentOfCurrentNode.getData();
					} else {
						return -1;
					}
				}
			}
		}

	}
*/
	public void inorder() {
		inorder(root);
	}

	private void inorder(BNode root) {
		if (root == null) {
			return;
		}
		inorder(root.getLeft());
		System.out.print(root.getData() + "  ");
		inorder(root.getRight());
	}

}

public class BSTMain {

	public static void main(String[] args) {
		BST bst = new BST();
		/*bst.insert_Recursive(2);
		bst.insert_Recursive(1);
		bst.insert_Recursive(3);*/
		bst.insert_Iterative(10);
		bst.insert_Iterative(5);
		bst.insert_Iterative(20);
		bst.insert_Iterative(15);
		bst.insert_Iterative(14);
		bst.insert_Iterative(30);
		bst.insert_Iterative(25);
		bst.inorder();
		//bst.delete_Iterative(3);
		//bst.delete_Iterative(1);
		//bst.delete(2);
		//System.out.println("\n"+"After deleting 3 and 1");
		//bst.inorder();
		System.out.println("\n"+bst.inorderSuccessorIterative(15));
	}

}
