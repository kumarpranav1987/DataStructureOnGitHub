package com.pranav.hackerearth.stronglyconnectedcomponent;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

//https://www.hackerearth.com/practice/algorithms/graphs/strongly-connected-components/practice-problems/algorithm/a-walk-to-remember-qualifier2/
public class AWalkToRemember {
	static boolean visited[];
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		Map<Integer, List<Integer>> adjList = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			adjList.put(i, new LinkedList<>());
		}
		for (int i = 1; i <= m; i++) {
			int start = s.nextInt();
			int end = s.nextInt();
			adjList.get(start).add(end);
		}
		visited = new boolean[n];
		Arrays.fill(visited, false);
		Stack<Integer> stack = new Stack<>();
		Input input = new Input();
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				input.i = i+1;
				input.adjList = adjList;
				input.stack = stack;
				dfs(input);
			}
		}
		Map<Integer, List<Integer>> reverseAdjList = transposeGraph(n, adjList);
		Set<Set<Integer>> setOfConnentedComponents = new HashSet<>();
		Arrays.fill(visited, false);
		
		while (!stack.isEmpty()) {
			int ele = stack.pop();
			if (!visited[ele - 1]) {
				Set<Integer> component = new HashSet<>();
				input.i = ele;
				input.adjList = reverseAdjList;
				input.stack = component;
				dfs(input);
				setOfConnentedComponents.add(component);
			}
		}
		for (int i = 1; i <= n; i++) {
			int result = 0;
			for (Set<Integer> set : setOfConnentedComponents) {
				if (set.contains(i) && set.size() > 1) {
					result = 1;
					break;
				}
			}
			System.out.print(result + " ");
		}
	}

	private static Map<Integer, List<Integer>> transposeGraph(int n, Map<Integer, List<Integer>> adjList) {
		Map<Integer, List<Integer>> reverseAdjList = new HashMap<>();
		for(int i=1;i<=n;i++) {
			reverseAdjList.put(i, new LinkedList<>());
		}
		for(int i=1;i<=n;i++) {
			for(Integer adj : adjList.get(i)) {
				reverseAdjList.get(adj).add(i);
			}
		}
		return reverseAdjList;
	}

	private static void dfs(Input input) {
		if (visited[input.i - 1]) {
			return;
		}
		visited[input.i-1] = true;
		for (Integer j : input.adjList.get(input.i)) {
			if (!visited[j - 1]) {
				dfs(input);
			}
		}
		input.stack.add(input.i);
	}
	static class Input{
		int i; 
		Map<Integer, List<Integer>> adjList;
		Collection<Integer> stack;
		public Input(){
			
		}
		public Input(int i, Map<Integer, List<Integer>> adjList, Collection<Integer> stack) {
			this.i = i;
			this.adjList = adjList;
			this.stack = stack;
		}
		
	}
}
