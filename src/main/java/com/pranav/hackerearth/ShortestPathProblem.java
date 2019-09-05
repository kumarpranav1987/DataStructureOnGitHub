package com.pranav.hackerearth;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShortestPathProblem {

	public static void main(String[] args) throws IOException {
		try (Scanner s = new Scanner(System.in)) {
			int n = s.nextInt();
			int m = s.nextInt();
			m=999200;
			ArrayList<ArrayList<Vertex>> adjList = new ArrayList<ArrayList<Vertex>>(n + 1);
			for (int i = 0; i <= n; i++) {
				adjList.add(i, new ArrayList<Vertex>());
			}
			for (int i = 1; i <= m; i++) {
				int u = s.nextInt();
				int v = s.nextInt();
				int cost = s.nextInt();
				adjList.get(u).add(new Vertex(v, cost));
			}
			int max = 1000000000;
			MinHeap queue = new MinHeap(n);
			queue.add(new Vertex(1, 0));
			for (int i = 2; i <= n; i++) {
				queue.add(new Vertex(i, max));
			}
			int distance[] = new int[n + 1];
			Arrays.fill(distance, max);
			while (!queue.isEmpty()) {
				Vertex current = queue.remove();
				if (current.getPriority() == max) {
					break;
				} else {
					distance[current.getId()] = current.getPriority();
					for (Vertex neighbour : adjList.get(current.getId())) {
						if (distance[neighbour.getId()] > distance[current.getId()] + neighbour.getPriority()) {
							queue.update(neighbour, distance[current.getId()] + neighbour.getPriority());
						}
					}
				}
			}
			FileWriter fw=null;
			BufferedWriter bw=null;
			fw = new FileWriter(new File("out.txt"));
			bw = new BufferedWriter(fw);
			for (int i = 2; i <= n; i++) {
				//System.out.print(distance[i] + " ");
				
				
				bw.append(distance[i]+" ");
				bw.flush();
				
			}
			bw.flush();
			bw.close();
			fw.close();
			
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

	private static class MinHeap {
		private Map<Vertex, Integer> indexMap = new HashMap<>();
		private int size;
		private Vertex[] heap;
		private int nextLocation;

		public MinHeap(int size) {
			this.size = size;
			heap = new Vertex[size];
		}

		public void add(Vertex v) {
			heap[nextLocation] = v;
			indexMap.put(v, nextLocation);
			heapifyUp(nextLocation);
			nextLocation++;
		}

		public void update(Vertex v, int newPriority) {
			int index = indexMap.get(v);
			heap[index].setPriority(newPriority);

			heapifyUp(index);
		}

		public Vertex remove() {
			Vertex v = heap[0];
			if (nextLocation >=2) {				 
				Vertex last = heap[nextLocation - 1];
				heap[0] = last;
				hepifyDown(0);
			}
			nextLocation--;
			return v;
		}

		private void heapifyUp(int index) {
			int parent = getParent(index);
			while (parent != -1 && heap[parent].getPriority() > heap[index].getPriority()) {
				Vertex temParent = heap[parent];
				Vertex tempCurrent = heap[index];
				heap[parent] = tempCurrent;
				heap[index] = temParent;
				indexMap.put(temParent, index);
				indexMap.put(tempCurrent, parent);
				index = parent;
				parent = getParent(index);
			}
		}

		private void hepifyDown(int index) {
			int minIdx = getMinIndex(index);
			while (minIdx != index) {
				Vertex tempCurrent = heap[index];
				Vertex tempMin = heap[minIdx];
				heap[index] = tempMin;
				heap[minIdx] = tempCurrent;
				indexMap.put(tempCurrent, minIdx);
				indexMap.put(tempMin, index);
				index = minIdx;
				minIdx = getMinIndex(index);
			}
		}

		private int getMinIndex(int index) {
			int left = getLeft(index);
			int minIndex = index;
			if (left != -1) {
				if (heap[left].getPriority() < heap[minIndex].getPriority()) {
					minIndex = left;
				}
			}
			int right = getRight(index);
			if (right != -1) {
				if (heap[right].getPriority() < heap[minIndex].getPriority()) {
					minIndex = right;
				}
			}
			return minIndex;
		}

		private int getLeft(int index) {
			int left = (2 * index) + 1;
			if (left >= nextLocation) {
				return -1;
			}
			return left;
		}

		private int getRight(int index) {
			int right = (2 * index) + 2;
			if (right >= nextLocation) {
				return -1;
			}
			return right;
		}

		private int getParent(int i) {
			if (i == 0) {
				return -1;
			} else {
				return (i - 1) / 2;
			}
		}

		public boolean isEmpty() {
			if (nextLocation == 0) {
				return true;
			}
			return false;
		}
	}
}
