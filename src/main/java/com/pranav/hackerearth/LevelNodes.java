package com.pranav.hackerearth;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class LevelNodes {
	private static int numberOfNodes;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		numberOfNodes = s.nextInt();
		List<List<Integer>> adjList = new LinkedList<>();
		for (int i = 0; i <= numberOfNodes; i++) {
			adjList.add(new LinkedList<Integer>());
		}
		for (int i = 0; i < numberOfNodes - 1; i++) {
			int x = s.nextInt();
			int y = s.nextInt();
			adjList.get(x).add(y);
			adjList.get(y).add(x);
		}
		int level = s.nextInt();
		System.out.println(countNodesAtLevel(adjList,level));
		s.close();
	}

	private static int  countNodesAtLevel(List<List<Integer>> adjList, int level) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int[]parent= new int[numberOfNodes+1];
		int[] levelNumber = new int[numberOfNodes+1];
		boolean[] visited = new boolean[numberOfNodes+1];
		Arrays.fill(parent, -1);		
		queue.add(1);
		visited[1]=true;
		levelNumber[1]=1;
		int result=0;
		while(!queue.isEmpty()) {
			int current = queue.remove();
			for(int neighbour : adjList.get(current)) {
				if(!visited[neighbour]) {
					queue.add(neighbour);
					visited[neighbour]=true;
					int levelOfNeighbour = levelNumber[current]+1;
					levelNumber[neighbour] = levelOfNeighbour;
					if(levelOfNeighbour == level) {
						result++;
					}else if (levelOfNeighbour == level+1) {
						break;
					}
				}
			}
		}
		return result;
	}

	
}
