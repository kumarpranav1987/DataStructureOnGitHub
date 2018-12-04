package com.pranav.hackerearth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class UnreachableNodes {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		boolean[] visited = new boolean[n];
		Arrays.fill(visited, false);
		List<List<Integer>> adjList = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			adjList.add(i, new LinkedList<>());
		}
		for (int i = 0; i < m; i++) {
			int start = s.nextInt();
			int end = s.nextInt();
			adjList.get(start - 1).add(end - 1);
			adjList.get(end - 1).add(start - 1);
		}
		int startNode = s.nextInt() - 1;
		dfs(startNode, adjList, visited);
		int unreachbleCount = 0;
		for(int i=0;i<n;i++) {
			if(!visited[i]) {
				unreachbleCount++;
			}
		}
		System.out.println(unreachbleCount);
		s.close();
	}

	private static void dfs(int startNode, List<List<Integer>> adjList, boolean[] visited) {
		visited[startNode] = true;
		for (int i : adjList.get(startNode)) {
			if (!visited[i]) {
				dfs(i, adjList, visited);
			}
		}

	}
}
