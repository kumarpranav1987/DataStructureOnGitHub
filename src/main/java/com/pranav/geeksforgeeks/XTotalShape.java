package com.pranav.geeksforgeeks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class XTotalShape {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numberOfTestCases = s.nextInt();
		int data[][] = null;
		for (int i = 0; i < numberOfTestCases; i++) {
			int n = s.nextInt();
			int m = s.nextInt();
			data = new int[n][m];
			for (int j = 0; j < n; j++) {
				char[] chars = s.next().toCharArray();
				for (int k = 0; k < m; k++) {
					int c = chars[k] == 'O' ? 0 : 1;
					data[j][k] = c;
				}
			}
		}
	}

	class Graph<T> {
		private List<Vertex<T>> vertices;

		public Graph() {
			vertices = new ArrayList<>();
		}

		public void addVertex(Vertex<T> v) {
			vertices.add(v);
		}
		
		public void addEdge(Vertex<T> v1, Vertex<T> v2) {
			v1.adjacentVertices.add(v2);
			v2.adjacentVertices.add(v1);
		}
	}

	class Vertex<T> {
		private T data;
		private List<Vertex<T>> adjacentVertices;

		public Vertex(T data) {
			this.data = data;
			adjacentVertices = new ArrayList<>();
		}

	}
}
