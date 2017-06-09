package com.pranav.geeksforgeeks;

import java.util.Scanner;

/*http://practice.geeksforgeeks.org/problems/fill-array-by-1s/0
*/
public class FillArrayWith1s {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numberOfTestCases = s.nextInt();
		for (int i = 0; i < numberOfTestCases; i++) {
			int inputSize = s.nextInt();
			int[] input = new int[inputSize];
			for (int j = 0; j < inputSize; j++) {
				input[j] = s.nextInt();
			}
			System.out.println(findNumberOfIterations(input));
		}
	}

	private static int findNumberOfIterations(int[] input) {
		int startZeros = findNumberOfStartZeros(input);
		int endZeros = findNumberOfEndZeros(input);
		int maxZeros = findMaxZeros(input);
		if (maxZeros == input.length) {
			return -1;
		} else {
			return Math.max(Math.max(startZeros, endZeros), (int) Math.ceil((double) maxZeros / 2));
		}

	}

	private static int findMaxZeros(int[] input) {
		int result = 0;
		int cureentMax = 0;
		for (int i = 0; i < input.length; i++) {
			if (input[i] == 1) {
				cureentMax = 0;
			} else {
				cureentMax++;
				if (result < cureentMax) {
					result = cureentMax;
				}
			}
		}
		return result;
	}

	private static int findNumberOfEndZeros(int[] input) {
		int i = input.length - 1;
		while ((i >= 0) && (input[i] != 1)) {
			i--;
		}
		return input.length - i - 1;
	}

	private static int findNumberOfStartZeros(int[] input) {
		int i = 0;
		while ((i < input.length) && (input[i] != 1)) {
			i++;
		}
		return i;
	}
}
