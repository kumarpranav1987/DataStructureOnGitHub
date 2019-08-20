package com.pranav.hackerearth;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class TopologicalSort {
	private static Set<Integer> zeroIndegreeSet = new TreeSet<Integer>(Comparator.reverseOrder());
	private static int n;
	private static boolean[] visited;
	private static LinkedList<TreeSet<Integer>> adjList;
	private static Stack<Integer>stack = new Stack<Integer>();
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		int m = s.nextInt();
		adjList = new LinkedList<TreeSet<Integer>>();
		for (int i = 0; i <= n; i++) {
			adjList.add(new TreeSet<Integer>(Comparator.reverseOrder()));
		}
		int[] inDegree = new int[n + 1];
		for (int i = 0; i < m; i++) {
			int x = s.nextInt();
			int y = s.nextInt();
			adjList.get(x).add(y);
			inDegree[y] = inDegree[y] + 1;
		}

		for (int i = 1; i <= n; i++) {
			if (inDegree[i] == 0) {
				zeroIndegreeSet.add(i);
			}
		}
		visited = new boolean[n + 1];
		for (int i : zeroIndegreeSet) {
				topSort(i);
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
		s.close();

	}

	private static void topSort(int x) {
		visited[x]=true;
		for(int neighbour : adjList.get(x)) {
			if(!visited[neighbour]) {
				topSort(neighbour);
			}
		}
		stack.push(x);
	}

}
