package com.pranav.hackerearth;

import java.util.Scanner;

public class GraphRepresentation {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int  n = s.nextInt();
		int m = s.nextInt();
		int[][] adjMatrix = new int[n][n];
		for(int i=0;i<m;i++) {
			int u = s.nextInt();
			int v = s.nextInt();
			adjMatrix[u-1][v-1]=1;
		}
		int q = s.nextInt();
		for(int i=0;i<q;i++) {
			int u = s.nextInt();
			int v = s.nextInt();
			if(adjMatrix[u-1][v-1]==1) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
		s.close();
	}

}
