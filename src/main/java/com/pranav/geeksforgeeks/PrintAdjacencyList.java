package com.pranav.geeksforgeeks;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PrintAdjacencyList {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numberOfTestCases = s.nextInt();
		for (int i = 0; i < numberOfTestCases; i++) {
			int numberOfVertex = s.nextInt();
			int numberOfEdeges = s.nextInt();
			Graph g = new Graph(numberOfVertex);
			for(int j=0;j<numberOfEdeges;j++) {
				int start = s.nextInt();
				int end = s.nextInt();
				g.addEdge(start, end);
			}
			g.printAdjList();
		}

	}

	private static class Graph {
		private int v;
		private LinkedList<Integer> adjList[];
		public Graph(int v) {
			this.v = v;
			adjList = new LinkedList[v];
			for(int i=0;i<v;i++) {
				adjList[i]= new LinkedList<>();
			}
		}
		public void addEdge(int x,int y) {
			adjList[x].add(y);
			adjList[y].add(x);
		}
		public void printAdjList() {
			for(int i=0;i<v;i++) {
				System.out.print(i);
				List<Integer> list = adjList[i];
				//Collections.sort(list);
				for(Integer data : list) {
					System.out.print("-> "+data);
				}
				System.out.println();
			}
		}
	}
}
