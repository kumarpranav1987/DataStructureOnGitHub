package com.pranav.geeksforgeeks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class NodesAtEvenDistance {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numberOfTestCases = s.nextInt();
		for (int i = 0; i < numberOfTestCases; i++) {
			int numberOfVertices = s.nextInt();
			Graph<Integer> graph = new Graph<>(numberOfVertices);
			for (int j = 1; j <= numberOfVertices; j++) {
				Vertex<Integer> v = graph.addVertex(j);
				graph.getMap().put(j, v);
			}

			for (int j = 1; j < numberOfVertices - 1; j++) {
				int start = s.nextInt();
				int end = s.nextInt();
				graph.addEdge(graph.getMap().get(start), graph.getMap().get(end));
			}
		}
	}
}

class Graph<T> {
	private Set<Vertex<T>> vertices;
	private Map<T, Vertex<T>> map;

	public Graph(int numberOfVertices) {
		vertices = new HashSet<>(numberOfVertices);
		map = new HashMap<>();
	}

	public void dfs(Vertex<T> root) {
		root.setVisited(true);
		System.out.println(root.getData());
		
	}
	public Vertex<T> addVertex(T data) {
		Vertex<T> newVertex = new Vertex<>(data);
		vertices.add(newVertex);
		return newVertex;
	}

	public void addEdge(Vertex<T> start, Vertex<T> end) {
		start.getAdjacentVertices().add(end);
		end.getAdjacentVertices().add(start);
	}

	protected Set<Vertex<T>> getVertices() {
		return vertices;
	}

	protected void setVertices(Set<Vertex<T>> vertices) {
		this.vertices = vertices;
	}

	protected Map<T, Vertex<T>> getMap() {
		return map;
	}

	protected void setMap(Map<T, Vertex<T>> map) {
		this.map = map;
	}

}

class Vertex<T> {
	private T data;
	private boolean isVisited;
	private List<Vertex<T>> adjacentVertices;

	public Vertex(T data) {
		this.data = data;
		adjacentVertices = new ArrayList<>();
	}

	protected T getData() {
		return data;
	}

	protected void setData(T data) {
		this.data = data;
	}

	protected boolean isVisited() {
		return isVisited;
	}

	protected void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	protected List<Vertex<T>> getAdjacentVertices() {
		return adjacentVertices;
	}

	protected void setAdjacentVertices(List<Vertex<T>> adjacentVertices) {
		this.adjacentVertices = adjacentVertices;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
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
		Vertex other = (Vertex) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}

}

class Edge {

}