package com.pranav.hackerearth.stronglyconnectedcomponent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

//https://www.hackerearth.com/practice/algorithms/graphs/strongly-connected-components/tutorial/
//Submitted in 	Java OPenJDK 1.7
public class KosarajuAlgoForStronglyConnectedComponent {
	private static List<List<Integer>> adjList = new ArrayList<List<Integer>>();
	private static Set<Set<Integer>> scComponents = new HashSet<Set<Integer>>();
	private static int n;
	private static List<List<Integer>> reverseGraph;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		int m = s.nextInt();
		for (int i = 0; i <= n; i++) {
			adjList.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < m; i++) {
			int u = s.nextInt();
			int v = s.nextInt();
			adjList.get(u).add(v);
		}
		Stack<Integer> stack = new Stack<Integer>();
		boolean[] visited = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				dfsToGetStatck(i, stack, visited);
			}
		}
		reverseGraph = reverseGraph();
		Arrays.fill(visited, false);
		while (!stack.isEmpty()) {
			int current = stack.pop();
			if (!visited[current]) {
				Set<Integer> set = new HashSet<Integer>();
				connectedComponents(current, visited, set);
				scComponents.add(set);
			}
		}
		int odd = 0;
		int even = 0;
		for (Set<Integer> set : scComponents) {
			if (set.size() % 2 == 0) {
				even += set.size();
			} else {
				odd += set.size();
			}
		}
		System.out.println(odd - even);
		s.close();
	}

	private static void connectedComponents(int current, boolean[] visited, Set<Integer> set) {
		visited[current] = true;
		set.add(current);
		for (int v : reverseGraph.get(current)) {
			if (!visited[v]) {
				connectedComponents(v, visited, set);
			}
		}

	}

	private static List<List<Integer>> reverseGraph() {
		List<List<Integer>> reverseGraph = new ArrayList<List<Integer>>();
		for (int i = 0; i <= n; i++) {
			reverseGraph.add(new ArrayList<Integer>());
		}
		for (int i = 1; i <= n; i++) {
			for (int j : adjList.get(i)) {
				reverseGraph.get(j).add(i);
			}
		}
		return reverseGraph;
	}

	private static void dfsToGetStatck(int u, Stack<Integer> stack, boolean[] visited) {
		visited[u] = true;
		for (int v : adjList.get(u)) {
			if (!visited[v]) {
				dfsToGetStatck(v, stack, visited);
			}
		}
		stack.push(u);
	}
}
