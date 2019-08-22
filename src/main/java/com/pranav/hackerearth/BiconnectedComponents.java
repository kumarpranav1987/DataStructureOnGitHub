package com.pranav.hackerearth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

//https://www.hackerearth.com/practice/algorithms/graphs/biconnected-components/tutorial/
public class BiconnectedComponents {
	private static int n;
	private static List<List<Integer>> adjList;
	private static Set<Set<Integer>> result = new HashSet<Set<Integer>>();
	private static int time = 0;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		int m = s.nextInt();
		adjList = new ArrayList<List<Integer>>();
		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < m; i++) {
			int u = s.nextInt();
			int v = s.nextInt();
			adjList.get(u).add(v);
			adjList.get(v).add(u);
		}
		findBiconnectedComponents();
		int odd =0;
		int even =0;
		for(Set<Integer> set : result) {
			if(set.size()%2==0) {
				even++;
			}else {
				odd++;
			}
		}
		System.out.println(odd+" "+even);
		s.close();
	}

	private static void findBiconnectedComponents() {
		boolean visited[] = new boolean[n];
		int[] discoveryTime = new int[n];
		int[] deeppestReachble = new int[n];
		int[] parent = new int[n];
		Arrays.fill(parent, -1);
		Stack<Edge> stack=null;
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				stack = new Stack<Edge>();
				components(i, visited, discoveryTime, deeppestReachble, parent, stack);
			}
			Set<Integer>set = new HashSet<Integer>();
			while (!stack.isEmpty()) {
				Edge top = stack.pop();
				
				set.add(top.getU());
				set.add(top.getV());
				
			}
			if(!set.isEmpty()) {
				result.add(set);
			}
			
		}
		
	}

	private static void components(int u, boolean[] visited, int[] discoveryTime, int[] deeppestReachble, int[] parent,
			Stack<Edge> stack) {
		visited[u]=true;
		discoveryTime[u]=++time;
		deeppestReachble[u]= discoveryTime[u];
		int child=0;
		for(int neighbour : adjList.get(u)) {
			if(!visited[neighbour]) {
				child++;
				parent[neighbour]=u;
				Edge current = new Edge(u, neighbour);
				stack.push(current);
				components(neighbour, visited, discoveryTime, deeppestReachble, parent, stack);
				deeppestReachble[u]=Math.min(deeppestReachble[u], deeppestReachble[neighbour]);
				if((parent[u] == -1 && child>1)||(parent[u]!=-1 && deeppestReachble[neighbour]>=discoveryTime[u])) {
					Set<Integer>set = new HashSet<Integer>();
					Edge top = stack.pop();
					while(!top.equals(current)) {
						set.add(top.getU());
						set.add(top.getV());
						top = stack.pop();
					}
					set.add(top.getU());
					set.add(top.getV());
					result.add(set);
				}
				
			}else if (parent[u]!=neighbour) {
				deeppestReachble[u]=Math.min(deeppestReachble[u], discoveryTime[neighbour]);
				
			}
		}
	}
}

class Edge {
	private int u;
	private int v;

	public Edge(int u, int v) {
		this.u = u > v ? v : u;
		this.v = u > v ? u : v;
	}

	public int getU() {
		return u;
	}

	public int getV() {
		return v;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + u;
		result = prime * result + v;
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
		Edge other = (Edge) obj;
		if (u != other.u)
			return false;
		if (v != other.v)
			return false;
		return true;
	}

}