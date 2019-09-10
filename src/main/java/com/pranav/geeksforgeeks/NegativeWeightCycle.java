package com.pranav.geeksforgeeks;

import java.util.Arrays;
import java.util.Scanner;

//https://practice.geeksforgeeks.org/problems/negative-weight-cycle/0
public class NegativeWeightCycle {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numberOfTestCase = s.nextInt();
		for (int i = 0; i < numberOfTestCase; i++) {
			int v = s.nextInt();
			int e = s.nextInt();
			Edge[] edges = new Edge[e];
			for (int j = 0; j < e; j++) {
				int start = s.nextInt();
				int end = s.nextInt();
				int weight = s.nextInt();
				Edge newEdge = new Edge(start, end, weight);
				edges[j] = newEdge;
			}

			double[] pathLengths = new double[v];
			Arrays.fill(pathLengths, Double.POSITIVE_INFINITY);
			pathLengths[0] = 0;
			for (int j = 1; j < v - 1; j++) {
				for (int k = 0; k < edges.length; k++) {
					Edge currentedge = edges[k];
					relax(currentedge.start, currentedge.end,currentedge.weight, pathLengths);
				}
			}
			boolean negativeCycleFound = false;
			for (int k = 0; k < edges.length; k++) {
				Edge currentedge = edges[k];
				if(relax(currentedge.start, currentedge.end,currentedge.weight, pathLengths)) {
					negativeCycleFound = true;
					break;
				}
			}
			if(negativeCycleFound) {
				System.out.println("1");
			}else {
				System.out.println("0");
			}
		}
		s.close();
	}

	private static boolean relax(int start, int end, double weight,double[] pathLengths) {
		boolean weightChanged = false;
		if(pathLengths[start] + weight < pathLengths[end] ) {
			weightChanged = true;
			pathLengths[end] = pathLengths[start] + weight;
		}
		return weightChanged;
	}

	static class Edge {
		private int start;
		private int end;
		private double weight;

		public Edge(int start, int end, double weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		public int getStart() {
			return start;
		}

		public void setStart(int start) {
			this.start = start;
		}

		public int getEnd() {
			return end;
		}

		public void setEnd(int end) {
			this.end = end;
		}

		public double getWeight() {
			return weight;
		}

		public void setWeight(double weight) {
			this.weight = weight;
		}

	}
}
