package com.pranav.hackerearth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//https://www.hackerearth.com/practice/algorithms/graphs/topological-sort/practice-problems/algorithm/oliver-and-the-game-3/

public class TestClass {
	public static void main(String[] args) throws Exception {
		Graph<Integer, Integer>[] g = new Graph[2];
		Scanner s = new Scanner(System.in);
		int numberOfVertices = s.nextInt();
		g[0] = new Graph<Integer, Integer>(numberOfVertices);
		g[1] = new Graph<Integer, Integer>(numberOfVertices);

		int a;
		int b;
		for (int i = 1; i < numberOfVertices; i++) {
			a = s.nextInt();
			b = s.nextInt();
			int start = (Integer.min(a, b));
			int end = Integer.max(start, b);
			g[0].addEdge(end, start);
			g[1].addEdge(start, end);
		}
		int numberOfQuries = s.nextInt();
		for (int i = 0; i < numberOfQuries; i++) {
			Graph<Integer, Integer> currentGraph = g[s.nextInt()];
			int serachElement = s.nextInt();
			int startPosition = s.nextInt();
			if (currentGraph.dfs(startPosition, serachElement)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}

		}
	}
	static class Graph<I, D> {
		private final Map<I, Vertex<I, D>> vertexMap;
		private final List<Vertex<I, D>> allVertices;
		private Map<I, Boolean>visited;

		public Graph(int numberOfVertices) {
			vertexMap = new HashMap<>();
			allVertices = new ArrayList<>();
			visited = new HashMap<>();
		}

		public Map<I, Vertex<I, D>> getVertexMap() {
			return vertexMap;
		}

		public List<Vertex<I, D>> getAllVertices() {
			return allVertices;
		}

		public void addEdge(I start, I end) {
			Vertex<I, D> u = vertexMap.get(start);
			if (u == null) {
				u = new Vertex(start, start);
				vertexMap.put(start, u);
				allVertices.add(u);
			}
			Vertex<I, D> v = vertexMap.get(end);
			if (v == null) {
				v = new Vertex(end, end);
				vertexMap.put(end, v);
				allVertices.add(v);
			}
			vertexMap.get(start).getAdjacentVertices().add(v);
		}

		public boolean dfs(I start, I searchElement) {
			visited.put(start, true);
			boolean result = false;
			if (start.equals(searchElement)) {
				return true;
			}
			for (Vertex<I, D> v : vertexMap.get(start).getAdjacentVertices()) {
				if(!visited.containsKey(v.getId())) {
					visited.put(v.getId(), true);
					result = result || dfs(v.getId(), searchElement);
				}
				return result;

			}
			return result;
		}
		
	}

	static class Vertex<I, D> {
		private final I id;
		private final D data;
		private final List<Vertex<I, D>> adjacentVertices;

		public Vertex(I id, D data) {
			this.id = id;
			this.data = data;
			adjacentVertices = new ArrayList<>();
		}

		public I getId() {
			return id;
		}

		public D getData() {
			return data;
		}

		public List<Vertex<I, D>> getAdjacentVertices() {
			return adjacentVertices;
		}

	}
}

