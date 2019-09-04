package com.pranav.hackerearth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ShortestPathProblem {

	public static void main(String[] args) {
		try (Scanner s = new Scanner(System.in)) {
			int n = s.nextInt();
			int m = s.nextInt();
			ArrayList<ArrayList<Vertex>> adjList = new ArrayList<ArrayList<Vertex>>(n+1);
			for (int i = 0; i <= n; i++) {
				adjList.add(i, new ArrayList<Vertex>());
			}
			for(int i=1;i<=m;i++) {
				int u = s.nextInt();
				int v = s.nextInt();
				int cost = s.nextInt();
				adjList.get(u).add(new Vertex(v,cost));
			}
			int max = 1000000000;
			PriorityQueue<Vertex>queue = new PriorityQueue<Vertex>();
			queue.add(new Vertex(1, 0));
			for(int i=2;i<=n;i++) {
				queue.add(new Vertex(i, max));
			}
			int distance[] = new int[n+11];
			Arrays.fill(distance, max);
			while(!queue.isEmpty()) {
				Vertex current = queue.remove();
				if(current.getPriority() == max) {
					break;
				}else {
					distance[current.getId()] = current.getPriority();
					for(Vertex neighbour : adjList.get(current.getId())) {
						if(distance[neighbour.getId()] > distance[current.getId()]+neighbour.getPriority()) {
							queue.remove(neighbour);
							queue.add(new Vertex(neighbour.getId(), distance[current.getId()]+neighbour.getPriority()));
						}		
					}
				}
			}
			for(int i=2;i<=n;i++) {
				System.out.print(distance[i]+" ");
			}
		}
	}

	private static class Vertex implements Comparable<Vertex> {
		private int id;
		private int priority;

		public Vertex(int id, int priority) {
			super();
			this.id = id;
			this.priority = priority;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getPriority() {
			return priority;
		}

		public void setPriority(int priority) {
			this.priority = priority;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + id;
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
			if (id != other.id)
				return false;
			return true;
		}

		@Override
		public int compareTo(Vertex o) {
			return priority - o.getPriority();
		}

	}
}

