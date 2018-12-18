package com.pranav.hackerrank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
//https://www.hackerearth.com/practice/algorithms/graphs/minimum-spanning-tree/tutorial/
public class MinimumSpanningTree_Krushkal {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		PriorityQueue<Edge> edges = new PriorityQueue<>();
		for (int i = 0; i < m; i++) {
			int start = s.nextInt();
			int end = s.nextInt();
			int weight = s.nextInt();
			edges.add(new Edge(start, end, weight));
		}
		int cost = 0;
		int edgeCount = 1;
		List<Set<Integer>> sets = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			Set<Integer> set = new HashSet<>();
			set.add(i);
			sets.add(set);
		}
		while (edgeCount < n) {
			Edge e = edges.poll();
			int s1 = findset(e.start, sets);
			int s2 = findset(e.end, sets);
			if (s1 == s2) {
				continue;
			} else {
				edgeCount++;
				sets.get(s1).addAll(sets.remove(s2));
				cost += e.weight;
			}
		}
		System.out.println(cost);
	}

	private static int findset(int start, List<Set<Integer>> sets) {
		for (int i = 0; i < sets.size(); i++) {
			if (sets.get(i).contains(start)) {
				return i;
			}
		}
		return -1;
	}

	static class Edge implements Comparable<Edge> {
		private int start;
		private int end;
		private int weight;

		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
}
