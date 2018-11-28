package com.pranav.hackerearth.stronglyconnectedcomponent;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

//https://www.hackerearth.com/practice/algorithms/graphs/strongly-connected-components/tutorial/
//Strongly Connected Components Brute Force method 
public class Question1 {
	static boolean visited[];

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		visited = new boolean[n];
		int m = s.nextInt();
		Map<Integer, List<Integer>> adjList = new HashMap<>();
		Set<Integer> vertices = new HashSet<>();
		for (int i = 1; i <= n; i++) {
			adjList.put(i, new LinkedList<>());
			vertices.add(i);
		}
		for (int i = 1; i <= m; i++) {
			int start = s.nextInt();
			int end = s.nextInt();
			adjList.get(start).add(end);
		}
		int odd =0;
		int even =0;
		for(Set<Integer> set : getAllStronglyConnectedComponents(vertices, adjList)) {
			if((set.size()%2) == 0) {
				even+=set.size();
			}else {
				odd+=set.size();
			}
		}
		System.out.println(odd - even);
	}

	private static List<Set<Integer>> getAllStronglyConnectedComponents(Set<Integer> vertices,
		Map<Integer, List<Integer>> adjList) {
		List<Set<Integer>> result = new LinkedList<>();
		Set<Integer> allExploredVertices = new HashSet<>();
		while (!allExploredVertices.containsAll(vertices)) {
			Set<Integer> unExploredVertices = new HashSet<>(vertices);
			unExploredVertices.removeAll(allExploredVertices);
			Iterator<Integer> itr = unExploredVertices.iterator();
			int start = itr.next();
			Set<Integer> currentComponet = new HashSet<>();
			currentComponet.add(start);
			result.add(currentComponet);
			while (itr.hasNext()) {
				Integer integer = itr.next();
				if (hasPath(start, integer, adjList, getVisited()) && hasPath(integer, start, adjList, getVisited())) {
					currentComponet.add(integer);
				}
			}
			allExploredVertices.addAll(currentComponet);

		}
		return result;
	}

	private static boolean hasPath(int start, Integer integer, Map<Integer, List<Integer>> adjList, boolean[] visited) {
		for (Integer i : adjList.get(start)) {
			if (i == integer) {
				return true;
			} else if (!visited[i - 1]) {
				visited[i - 1] = true;
				if (hasPath(i, integer, adjList, visited)) {
					return true;
				}
			}
		}
		return false;
	}

	static boolean[] getVisited() {
		Arrays.fill(visited, false);
		return visited;
	}
}
