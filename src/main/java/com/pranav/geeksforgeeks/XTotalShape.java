package com.pranav.geeksforgeeks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

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
			Map<ID, Vertex> map = new HashMap<>();
			Graph<Shape> graph = new Graph<>();
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (data[j][k] == 1) {
						ID id = new ID(j, k);
						Shape shape = new Shape(id);
						Vertex<Shape> v = new Vertex<>(shape);
						graph.addVertex(v);
						map.put(id, v);
					}
				}
			}
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (data[j][k] == 1) {
						Vertex<Shape> start = map.get(new ID(j,k));
						// left
						if (check(j, k - 1, map)) {
							Vertex<Shape>end =map.get(new ID(j,k-1));
							graph.addEdge(start, end);
						}
						// right
						if (check(j, k + 1, map)) {
							Vertex<Shape>end =map.get(new ID(j,k+1));
							graph.addEdge(start, end);
						}
						// up
						if (check(j - 1, k, map)) {
							Vertex<Shape>end =map.get(new ID(j-1,k));
							graph.addEdge(start, end);
						}
						// down
						if (check(j + 1, k, map)) {
							Vertex<Shape>end =map.get(new ID(j+1,k));
							graph.addEdge(start, end);
						}

					}
				}
			}
			System.out.println(graph.getConnectedCompponents());
		}

	}

	private static boolean check(int row, int col, Map<ID, Vertex> map) {
		return map.containsKey(new ID(row, col));
	}

	static class Graph<T> {
		private List<Vertex<T>> vertices;

		public Graph() {
			vertices = new ArrayList<>();
		}

		public void addVertex(Vertex<T> v) {
			vertices.add(v);
		}

		public void addEdge(Vertex<T> v1, Vertex<T> v2) {
			v1.adjacentVertices.add(v2);
			//v2.adjacentVertices.add(v1);
		}
		
		public int getConnectedCompponents() {
			Set<Vertex<T>> visited = new HashSet<>();
			int numberOfConnectedComponents = 0;
			Queue<Vertex<T>> queue = new LinkedList<>();
			/*Vertex<T> start = vertices.get(0);
			queue.add(start);
			visited.add(start);*/
			for(Vertex<T> v: vertices) {
				if(!visited.contains(v)) {
					queue.add(v);
					visited.add(v);
					numberOfConnectedComponents++;
				}
				while (!queue.isEmpty()) {
					Vertex<T> currentVertex = queue.remove();
					for(Vertex<T> adjv : currentVertex.getAdjacentVertices()) {
						if(!visited.contains(adjv)) {
							queue.add(adjv);
							visited.add(adjv);
						}
					}
					
				}
			}
			return numberOfConnectedComponents;
			
		}
	}

	static class Vertex<T> {
		private T data;
		private List<Vertex<T>> adjacentVertices;

		public Vertex(T data) {
			this.data = data;
			adjacentVertices = new ArrayList<>();
		}

		public T getData() {
			return data;
		}

		public List<Vertex<T>> getAdjacentVertices() {
			return adjacentVertices;
		}
		
	}

	static class Shape {
		private ID id;

		public Shape(ID id) {
			super();
			this.id = id;
		}

	}

	static class ID {
		private int row;
		private int col;

		public ID(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + col;
			result = prime * result + row;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ID other = (ID) obj;
			if (col != other.col)
				return false;
			if (row != other.row)
				return false;
			return true;
		}
		

	}
}
