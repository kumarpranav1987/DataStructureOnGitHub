package com.pranav.geeksforgeeks;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*http://practice.geeksforgeeks.org/problems/length-of-largest-region-of-1s/0
*/public class LengthOfLargestRegionOf1s {

	public static void main(String[] args) {
		class Index {
			int row;
			int column;

			public Index(int row, int column) {
				this.row = row;
				this.column = column;
			}

		}
		Scanner s = new Scanner(System.in);
		int numberOfTestCases = s.nextInt();
		for (int i = 0; i < numberOfTestCases; i++) {
			int n = s.nextInt();
			int m = s.nextInt();
			int[][] input = new int[n][m];
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					input[j][k] = s.nextInt();
				}
			}
			boolean done = false;
			int result = 0;
			while (!done) {
				Queue<Index> queue = new LinkedList<>();
				done = true;
				for (int j = 0; j < n; j++) {
					for (int k = 0; k < m; k++) {
						if (input[j][k] == 1) {
							done = false;
							queue.add(new Index(j, k));
							j = n;
							break;
						}
					}
				}
				int currentResult =0;
				while (!queue.isEmpty()) {
					Index index = queue.remove();
					currentResult++;
					input[index.row][index.column]=0;
					if((index.row-1 >=0)&&(index.column-1 >=0)&&(input[index.row-1][index.column-1]==1)){
						queue.add(new Index(index.row-1, index.column-1));
						input[index.row-1][index.column-1]=0;
					}	
					if((index.row-1 >=0)&&(input[index.row-1][index.column]==1)){
						queue.add(new Index(index.row-1, index.column));
						input[index.row-1][index.column]=0;
					}
					if((index.row-1 >=0)&&(index.column+1 <m)&&(input[index.row-1][index.column+1]==1)){
						queue.add(new Index(index.row-1, index.column+1));
						input[index.row-1][index.column+1]=0;
					}
					if((index.column+1 <m)&&(input[index.row][index.column+1]==1)){
						queue.add(new Index(index.row, index.column+1));
						input[index.row][index.column+1]=0;
					}
					if((index.row+1 <n)&&(index.column+1 <m)&&(input[index.row+1][index.column+1]==1)){
						queue.add(new Index(index.row+1, index.column+1));
						input[index.row+1][index.column+1]=0;
					}
					if((index.row+1<n)&&(input[index.row+1][index.column]==1)){
						queue.add(new Index(index.row+1, index.column));
						input[index.row+1][index.column]=0;
					}
					if((index.row+1 <n)&&(index.column-1 >=0)&&(input[index.row+1][index.column-1]==1)){
						queue.add(new Index(index.row+1, index.column-1));
						input[index.row+1][index.column-1]=0;
					}
					if((index.column-1 >=0)&&(input[index.row][index.column-1]==1)){
						queue.add(new Index(index.row, index.column-1));
						input[index.row][index.column-1]=0;
					}
				}
				if (currentResult>result) {
					result = currentResult;
				}
			}
			System.out.println(result);
		}
	}
}
