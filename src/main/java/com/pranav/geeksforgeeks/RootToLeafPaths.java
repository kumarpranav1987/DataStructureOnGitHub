package com.pranav.geeksforgeeks;

import java.util.LinkedList;
import java.util.List;

public class RootToLeafPaths {
	class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = right = null;
		}
	}

	public void printPaths(Node root) {
		List<Integer> list = new LinkedList<>();
		printPaths(root,list);
	}

	private void printPaths(Node root, List<Integer> list) {
		if(root == null) {
			return;
		}
		if(root.left == null && root.right == null) {
			for(Integer i : list) {
				System.out.print(i+" ");
			}
			System.out.print(root.data+" #");
			return;
		}else {
			list.add(root.data);
			printPaths(root.left, list);
			printPaths(root.right, list);
			list.remove(new Integer(root.data));
		}
		
	}
	
}
