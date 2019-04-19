package com.pranav.hackerearth;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

//https://www.hackerearth.com/practice/algorithms/graphs/depth-first-search/practice-problems/algorithm/bishu-and-his-girlfriend/
public class BishuAndHisGirlfriend {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numberOfCountries = s.nextInt();
		List<List<Integer>> adjCountries = new ArrayList<>(numberOfCountries);
		for(int i=0;i<numberOfCountries;i++) {
			adjCountries.add(new ArrayList<>());
		}

		for(int i=1;i<numberOfCountries;i++) {
			int start = s.nextInt();
			int end = s.nextInt();
			adjCountries.get(start-1).add(end-1);
		}
		
		//calculate distance of each country from 1 
		int[] distances = new int[numberOfCountries];
		calculateDistance(adjCountries,distances);
		int q= s.nextInt();
		int id = Integer.MAX_VALUE;
		int distance = Integer.MAX_VALUE;
		for(int i=0;i<q;i++) {
			int countryId= s.nextInt();
			if(distances[countryId-1] <distance) {
				id=countryId;
				distance = distances[countryId-1];
			}else if (distances[countryId-1] == distance && countryId < id) {
				id=countryId;
			}
		}
		System.out.println(id);
	}

	private static void calculateDistance(List<List<Integer>> adjCountries, int[] distances) {
		boolean[] visited = new boolean[distances.length];
		int[] parent = new int[distances.length];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		visited[0]=true;
		distances[0]=0;
		parent[0]=-1;
		while(!queue.isEmpty()) {
			int country = queue.remove();
			for(int i:adjCountries.get(country)) {
				if(!visited[i]) {
					visited[i]=true;
					queue.add(i);
					parent[i]=country;
					distances[i]=distances[parent[i]]+1;
				}
			}
		}
		
	}

}
