package com.pranav.datastructure;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.*;
import java.util.LinkedList;
import java.util.Queue;

class N{
	N(){

	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public N getLeft() {
		return left;
	}
	public void setLeft(N left) {
		this.left = left;
	}
	public N getRight() {
		return right;
	}
	public void setRight(N right) {
		this.right = right;
	}
	private int data;
	private N left;
	private N right;
}

class BT{
	N root;
	BT(int data){
		this.root = new N();
		this.root.setData(data);
	}
	void insertLeft(N current,int data){
		N  temp = new N();
		temp.setData(data);
		current.setLeft(temp);

	}

	void insertRight(N current,int data){
		N temp = new N();
		temp.setData(data);;
		current.setRight(temp);
	}
	void inorder(N root){
		if(root == null)
			return;
		inorder(root.getLeft());
		System.out.print(root.getData()+"  ");
		inorder(root.getRight());
	}

	void rightView(N root){
		int level =-1;
		Queue<QueueNode> q = new LinkedList<>();
		if (root == null)
			return;
		QueueNode qn = new QueueNode(root,0);
		q.add(qn);
		while (!q.isEmpty()) {
			QueueNode current = q.poll();
			if(current.currentLevel > level){
				System.out.print(current.getNode().getData());
				level++;
			}
			if(current.getNode().getRight() != null)
				q.add(new QueueNode(current.getNode().getRight(),current.currentLevel+1));
			if(current.getNode().getLeft() != null)
				q.add(new QueueNode(current.getNode().getLeft(),current.currentLevel+1));


		}
	}
	private static class QueueNode{

		public QueueNode(N node, int currentLevel) {
			super();
			this.node = node;
			this.currentLevel = currentLevel;
		}
		N node;
		public N getNode() {
			return node;
		}
		public void setNode(N node) {
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

}
class TreeExample {

	public static void main(String args[]) throws Exception {      
		BT b = new BT(1);
		b.insertLeft(b.root, 2);
		b.insertRight(b.root, 3);
		b.insertLeft(b.root.getLeft(), 4);
		b.insertRight(b.root.getLeft(), 5);
		b.insertLeft(b.root.getRight(), 6);
		b.insertRight(b.root.getRight(), 7);
		b.inorder(b.root);
		System.out.println("");
		b.rightView(b.root);

	}
}