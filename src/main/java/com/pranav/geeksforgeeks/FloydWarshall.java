package com.pranav.geeksforgeeks;

import java.util.Scanner;

public class FloydWarshall {
	public static void main(String[] args) {
		try (Scanner s = new Scanner(System.in)) {
			int numberOfTestCases = s.nextInt();
			for (int p = 0; p < numberOfTestCases; p++) {
				int v = s.nextInt();
				double[][] adjMatrix = new double[v][v];
				for (int i = 0; i < v; i++) {
					for (int j = 0; j < v; j++) {
						String str = s.next();
						if (str.equals("INF")) {
							adjMatrix[i][j] = Double.POSITIVE_INFINITY;
						} else {
							adjMatrix[i][j] = Double.parseDouble(str);
						}
					}
				}
				for (int k = 0; k < v; k++) {
					for (int i = 0; i < v; i++) {
						for (int j = 0; j < v; j++) {
							if(adjMatrix[i][j]>adjMatrix[i][k]+adjMatrix[k][j]) {
								adjMatrix[i][j]=adjMatrix[i][k]+adjMatrix[k][j];
							}
						}
					}
				}
				for(int i=0;i<v;i++) {
					for(int j=0;j<v;j++) {
						if(adjMatrix[i][j] == Double.POSITIVE_INFINITY) {
							System.out.print("INF ");
						}else {
							System.out.print((int)adjMatrix[i][j]+" ");
						}
					
					}
					System.out.println();
				}
			}
		}
	}
}
