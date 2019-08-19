package com.pranav.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/bfsshortreach/problem
public class BreadthFirstSearchShortestReach {

	private static List<List<Integer>> adjList;
	private static int[] distances;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numberOFTestCases = s.nextInt();
		for (int i = 0; i < numberOFTestCases; i++) {
			int n = s.nextInt();
			int m = s.nextInt();
			adjList = new ArrayList<List<Integer>>(n);
			for (int p = 0; p < n; p++) {
				adjList.add(new ArrayList<Integer>());
			}
			distances = new int[n];
			Arrays.fill(distances, -1);
			for (int j = 0; j < m; j++) {
				int x = s.nextInt();
				int y = s.nextInt();
				adjList.get(x - 1).add(y);
				adjList.get(y - 1).add(x);
			}
			int startVertex = s.nextInt();
			bfs(startVertex, n);

			for (int index = 0; index < n; index++) {
				if (index != startVertex - 1) {
					System.out.print(distances[index] + " ");
				}
			}
			if (i != numberOFTestCases - 1) {
				System.out.println();
			}
		}
	}

	private static void bfs(int startVertex, int n) {
		distances[startVertex - 1] = 0;
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(startVertex);
		while (!queue.isEmpty()) {
			int current = queue.remove();
			for (Integer neighbour : adjList.get(current - 1)) {
				if (distances[neighbour - 1] == -1) {
					distances[neighbour - 1] = distances[current - 1] + 6;
					queue.add(neighbour);
				}
			}
		}

	}

}
