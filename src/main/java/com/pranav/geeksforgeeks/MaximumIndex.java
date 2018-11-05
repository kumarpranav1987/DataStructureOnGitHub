package com.pranav.geeksforgeeks;

import java.util.Scanner;

public class MaximumIndex {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numberOfTestCases = s.nextInt();
		for (int i = 0; i < numberOfTestCases; i++) {
			int size = s.nextInt();
			int[] input = new int[size];
			for (int j = 0; j < size; j++) {
				input[j] = s.nextInt();
			}
			int min[] = new int[size];
			int max[] = new int[size];
			int minTillNowIndex = 0;
			for(int j=0;j<size;j++) {
				if(input[minTillNowIndex]<=input[j]) {
					min[j]=minTillNowIndex;
				}else {
					min[j]=j;
					minTillNowIndex = j;
				}
			}
		}

	}

}
