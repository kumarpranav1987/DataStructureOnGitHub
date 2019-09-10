package com.pranav.geeksforgeeks;

import java.util.Arrays;
import java.util.LinkedList;

public class DetectCycleInAnUndirectedGraph {
	public static void main(String[] args) {
		LinkedList<Integer>[] alist  = new LinkedList[4];
		LinkedList<Integer> l = new LinkedList<>();
		l.add(1);
		alist[0] = l;
		l = new LinkedList<>();
		l.add(2);
		l.add(0);
		alist[1] = l;
		l = new LinkedList<>();
		l.add(3);
		l.add(1);
		alist[2] = l;
		l = new LinkedList<>();
		l.add(2);
		alist[3] = l;

		System.out.println(isCyclic(4, alist));
	}
	static Boolean  isCyclic(int V, LinkedList<Integer>[] alist) {
		boolean result = false;
		boolean visited[] = new boolean[V];
		Arrays.fill(visited, false);
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				result = dfs(i, -1, alist, visited);
			}
		}
		return result;
	}

	private static  boolean dfs(int i, int parent, LinkedList<Integer>[] alist, boolean visited[]) {
		visited[i] = true;
		for(int adj : alist[i]) {
			if(!visited[adj]) {
				if(dfs(adj, i, alist, visited));
			}else if(i != parent){
				return true;
			}
		}
		return false;
	}
}
