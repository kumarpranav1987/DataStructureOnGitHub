package com.pranav.hackerrank;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/sherlock-and-array
public class SherlockAndArray {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numOfTestCases = s.nextInt();
		for (int i = 0; i < numOfTestCases; i++) {
			int size = s.nextInt();
			int[] array = new int[size];
			int totalSum = 0;
			for (int j = 0; j < size; j++) {
				int currentNum = s.nextInt();
				array[j] = currentNum;
				totalSum += currentNum;
			}
			int leftSum = 0;
			int rightSum = 0;
			boolean done = false;
			for (int j = 0; j < size; j++) {
				if (j > 0) {
					leftSum += array[j - 1];
				} else {
					leftSum = 0;
				}
				if (j == (size - 1)) {
					rightSum=0;
				}else {
					rightSum = totalSum - (leftSum+array[j]);
				}
				
				if (leftSum == rightSum) {
					System.out.println("YES");
					done = true;
					break;
				}
				
			}
			if (!done) {
				System.out.println("NO");
			}
		}
	}
}
