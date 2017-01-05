package com.pranav.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//https://www.hackerrank.com/challenges/merging-communities
class Node {
	private int data;
	private Node parent;
	private int rank = 1;

	public Node(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

}

class DisjointSet {
	private Map<Integer, Node> nodeMap = new HashMap<>();

	public DisjointSet(int n) {
		for (int i = 1; i <= n; i++) {
			Node node = new Node(i);
			node.setParent(node);
			nodeMap.put(i, node);
		}
	}

	public Node find(int data) {
		return find(nodeMap.get(data));
	}

	private Node find(Node node) {
		if (node.getParent() == node) {
			return node;
		}
		node.setParent(find(node.getParent()));
		return node.getParent();
	}

	public void merge(int i, int j) {
		Node rep_i = find(i);
		Node rep_j = find(j);
		if (rep_i == rep_j) {
			return;
		} else {
			if (rep_i.getRank() == rep_j.getRank()) {
				rep_i.setParent(rep_j);
				rep_j.setRank(rep_i.getRank() + rep_j.getRank());
			} else if (rep_i.getRank() < rep_j.getRank()) {
				rep_i.setParent(rep_j);
				rep_j.setRank(rep_i.getRank() + rep_j.getRank());
			} else {
				rep_j.setParent(rep_i);
				rep_i.setRank(rep_i.getRank() + rep_j.getRank());
			}
		}
	}

	public int size(int data) {
		Node node = find(data);
		return node.getRank();
	}
}

public class MergingCommunities {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int setSize = s.nextInt();
		DisjointSet disjointSet = new DisjointSet(setSize);
		int numberOfQueries = s.nextInt();
		for(int i=0;i<numberOfQueries;i++){
			String query = s.next();
			if(query.equals("Q")){
				System.out.println(disjointSet.size(s.nextInt()));
			}else if (query.equals("M")) {
				disjointSet.merge(s.nextInt(), s.nextInt());
			}
		}
	}
}
