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
			Graph<Integer> g = new Graph<>(numberOfVertices);
			for (int j = 1; j <= numberOfVertices; j++) {
				g.addVertex(j);
			}
			for (int j = 1; j < numberOfVertices; j++) {
				int start = s.nextInt();
				int end = s.nextInt();
				g.addEdge(start, end);
			}
			System.out.println(g.countNumberOfEvenDistancePairs());
		}
	}
}

class Graph<T extends Comparable<T>> {
	private int numberOfVertices;
	private Set<Vertex<T>> vertices;
	private Map<T, Vertex<T>> map;
	private Set<Pair<T>> evenPairs;;

	public Graph(int numberOfVertices) {
		this.numberOfVertices = numberOfVertices;
		vertices = new HashSet<>(numberOfVertices);
		map = new HashMap<>();
		evenPairs = new HashSet<>();
	}

	public int countNumberOfEvenDistancePairs() {
		for (Vertex<T> v : vertices) {
			dfs(v, 0, v);
			reset();
		}
		return evenPairs.size();
	}

	public Vertex<T> addVertex(T data) {
		Vertex<T> v = new Vertex<>(data);
		vertices.add(v);
		map.put(data, v);
		return v;
	}

	public void addEdge(T start, T end) {
		addEdge(map.get(start), map.get(end));
	}

	private void addEdge(Vertex<T> start, Vertex<T> end) {
		start.getAdjacentVertices().add(end);
		end.getAdjacentVertices().add(start);
	}

	public void dfs(Vertex<T> root, int distance, Vertex<T> startVertex) {
		root.setVisited(true);
		if (distance > 0 && (distance % 2 == 0)) {
			evenPairs.add(new Pair<T>(startVertex.getData(), root.getData()));
		}
		for (Vertex<T> v : root.getAdjacentVertices()) {
			if (!v.isVisited()) {
				dfs(v, distance+1, startVertex);
			}
		}
	}

	public int getNumberOfVertices() {
		return numberOfVertices;
	}

	public void setNumberOfVertices(int numberOfVertices) {
		this.numberOfVertices = numberOfVertices;
	}

	public Set<Vertex<T>> getVertices() {
		return vertices;
	}

	public void setVertices(Set<Vertex<T>> vertices) {
		this.vertices = vertices;
	}

	public Map<T, Vertex<T>> getMap() {
		return map;
	}

	public void setMap(Map<T, Vertex<T>> map) {
		this.map = map;
	}

	public Set<Pair<T>> getEvenPairs() {
		return evenPairs;
	}

	public void setEvenPairs(Set<Pair<T>> evenPairs) {
		this.evenPairs = evenPairs;
	}

	public void reset() {
		for(Vertex<T> v:vertices) {
			v.setVisited(false);
		}
		
	}
}

class Vertex<T> {
	private T data;
	private List<Vertex<T>> adjacentVertices;
	private boolean isVisited;

	public Vertex(T data) {
		this.data = data;
		adjacentVertices = new ArrayList<>();
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

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<Vertex<T>> getAdjacentVertices() {
		return adjacentVertices;
	}

	public void setAdjacentVertices(List<Vertex<T>> adjacentVertices) {
		this.adjacentVertices = adjacentVertices;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}
}

class Pair<T extends Comparable<T>> {
	private T min;
	private T max;

	public Pair(T a, T b) {
		this.min = a.compareTo(b) < 0 ? a : b;
		this.max = b.compareTo(a) > 0 ? b : a;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((max == null) ? 0 : max.hashCode());
		result = prime * result + ((min == null) ? 0 : min.hashCode());
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
		Pair other = (Pair) obj;
		if (max == null) {
			if (other.max != null)
				return false;
		} else if (!max.equals(other.max))
			return false;
		if (min == null) {
			if (other.min != null)
				return false;
		} else if (!min.equals(other.min))
			return false;
		return true;
	}
	
}
