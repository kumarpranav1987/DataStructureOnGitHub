package com.pranav.hackerearth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
//https://www.hackerearth.com/practice/algorithms/graphs/articulation-points-and-bridges/tutorial/

public class ArticulationPointsAndBridges {

	private static boolean[] visited;
	private static int[] arrival;
	private static int[] dep;
	private static int[] dbe;
	private static int[] parent;
	private static List<Integer>artPoint=new ArrayList<>();
	private static List<BridgeEdges> bridgeEdges = new ArrayList<>();
	private static int time=0;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		visited = new boolean[n];
		arrival = new int[n];
		dep = new int[n];
		dbe=new int[n];
		parent= new int[n];
		List<List<Integer>> adjList = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			int start = s.nextInt();
			int end = s.nextInt();
			adjList.get(start).add(end);
			adjList.get(end).add(start);
		}
		dfs(adjList, 0);
		Collections.sort(artPoint);
		System.out.println(artPoint.size());
		for(int i:artPoint) {
			System.out.print(i+" ");
		}
		System.out.println();
		Collections.sort(bridgeEdges);
		System.out.println(bridgeEdges.size());
		for(BridgeEdges b:bridgeEdges) {
			System.out.println(b);
		}
		s.close();
	}

	public static void dfs(List<List<Integer>> adjList, int u) {
		visited[u] = true;
		arrival[u]=time++;
		dbe[u]=arrival[u];
		int childCount=0;
		for(int v:adjList.get(u)) {
			if(!visited[v]) {
				parent[v]=u;
				childCount++;
				dfs(adjList, v);		
				dbe[u]=Integer.min(dbe[u], dbe[v]);
				if(dbe[v]>arrival[u]) {
					bridgeEdges.add(new BridgeEdges(u, v));
				}
				
				if(arrival[u] ==0) {
					if(childCount>1) {
						artPoint.add(u);
					}
				}else {
					if(dbe[v]>=arrival[u]) {
						artPoint.add(u);
					}
				}
			}else if(parent[u]!=v){
				dbe[u] = Integer.min(arrival[v], dbe[u]);
			}
		}
	}

	static class BridgeEdges implements Comparable<BridgeEdges>{
		private int start;
		private int end;

		public BridgeEdges(int start, int end) {
			this.start = Integer.min(start, end);
			this.end = Integer.max(start, end);
		}

		@Override
		public int compareTo(BridgeEdges o) {
			if(start !=o.start) {
				return start - o.start;
			}else {
				return end - o.end;
			}
			
		}

		@Override
		public String toString() {
			return start+" "+end;
		}
		
	}
}
