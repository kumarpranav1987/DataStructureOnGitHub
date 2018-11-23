package com.pranav.hackerearth;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
//https://www.hackerearth.com/practice/algorithms/graphs/topological-sort/practice-problems/algorithm/lonelyisland-49054110/description/
public class LonelyIsland {
	private static int MAX = 0;
	private static Map<Integer, Integer> stuckCount = new HashMap<>();

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numberOfIslands = s.nextInt();
		int numberOfBridges = s.nextInt();
		int startingIsland = s.nextInt();
		Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
		for (int i = 0; i < numberOfBridges; i++) {
			int start = s.nextInt();
			int end = s.nextInt();
			if (adjacencyList.containsKey(start)) {
				adjacencyList.get(start).add(end);
			} else {
				List<Integer> l = new LinkedList<>();
				l.add(end);
				adjacencyList.put(start, l);
			}
		}
		dfs(startingIsland, adjacencyList);
		List<Integer> result = new LinkedList<>();
		for(Integer key : stuckCount.keySet()) {
			if(stuckCount.get(key) == MAX) {
				result.add(key);
			}
		}
		Collections.sort(result);
		for(int i : result) {
			System.out.print(i +" ");
		}
	}

	private static void dfs(int startingIsland, Map<Integer, List<Integer>> adjacencyList) {
		if (!adjacencyList.containsKey(startingIsland)) {
			int count = 0;
			if (stuckCount.containsKey(startingIsland)) {
				count = stuckCount.get(startingIsland);
				stuckCount.put(startingIsland, count + 1);
				count++;
			} else {
				count = 1;
				stuckCount.put(startingIsland, count);
			}
			if (count > MAX) {
				MAX = count;
			}
			return;
		}
		for(int i : adjacencyList.get(startingIsland)) {
			dfs(i,adjacencyList);
		}

	}
}
