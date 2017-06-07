package com.pranav.geeksforgeeks;

import java.util.Scanner;

/*http://practice.geeksforgeeks.org/problems/kadanes-algorithm/0
*/
public class KadanesAlgorithm {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numberOfTestCases = s.nextInt();
		
		for (int i = 0; i < numberOfTestCases; i++) {
			int max = Integer.MIN_VALUE;
			int inputSize = s.nextInt();
			int maxSoFar = 0, maxEndingHere = 0;
			for (int j = 0; j < inputSize; j++) {
				int current = s.nextInt();
				if (current > max) {
					max = current;
				}
				maxEndingHere += current;
				if (maxEndingHere < 0) {
					maxEndingHere = 0;
				}
				if (maxEndingHere > maxSoFar) {
					maxSoFar = maxEndingHere;
				}
			}
			if (max < 0) {
				System.out.println(max);
			} else {
				System.out.println(maxSoFar);
			}

		}
	}

}
