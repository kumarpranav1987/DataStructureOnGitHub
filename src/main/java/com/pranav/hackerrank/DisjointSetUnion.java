package com.pranav.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
//https://www.hackerearth.com/practice/data-structures/disjoint-data-strutures/basics-of-disjoint-data-structures/tutorial/
public class DisjointSetUnion {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		DisJointSet ds = new DisJointSet();
		for (int i = 1; i <= n; i++) {
			ds.makeSet(i);
		}
		for (int i = 0; i < m; i++) {
			int start = s.nextInt();
			int end = s.nextInt();
			ds.mergeSet(start, end);
			List<Integer> sizes = new ArrayList<>(ds.rootToSizeMap.values());
			Collections.sort(sizes);
			sizes.forEach((key) -> System.out.print(key + " "));
			System.out.println();
		}
	}

	static class DisJointSet {
		private Map<Integer, Node> nodeMap = new HashMap<>();
		private Map<Integer, Integer> rootToSizeMap = new HashMap<>();

		public void makeSet(int key) {
			Node node = new Node(key, 1);
			node.parent = node;
			nodeMap.put(key, node);
			rootToSizeMap.put(key, 1);
		}

		public Node find(int key) {
			return find(nodeMap.get(key));
		}

		private Node find(Node node) {
			while (node.parent != node) {
				node = node.parent;
			}
			return node;
		}

		public void mergeSet(int key1, int key2) {
			Node a = find(key1);
			Node b = find(key2);
			if (a != b) {
				if (a.rank == b.rank) {
					b.parent = a;
					a.rank += 1;
					int sizeOfb = rootToSizeMap.remove(b.key);
					int sizeOfa = rootToSizeMap.get(a.key);
					rootToSizeMap.put(a.key, sizeOfa + sizeOfb);
				} else if (a.rank > b.rank) {
					b.parent = a;
					int sizeOfb = rootToSizeMap.remove(b.key);
					int sizeOfa = rootToSizeMap.get(a.key);
					rootToSizeMap.put(a.key, sizeOfa + sizeOfb);
				} else {
					a.parent = b;
					int sizeOfa = rootToSizeMap.remove(a.key);
					int sizeOfb = rootToSizeMap.get(b.key);
					rootToSizeMap.put(b.key, sizeOfa + sizeOfb);
				}
			}
		}

		static class Node {
			private Node parent;
			private int key;
			private int rank;

			public Node(int key, int rank) {
				this.key = key;
				this.rank = rank;
			}

		}
	}

}
