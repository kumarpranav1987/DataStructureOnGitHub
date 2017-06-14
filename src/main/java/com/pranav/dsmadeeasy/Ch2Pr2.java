package com.pranav.dsmadeeasy;

import java.util.Scanner;

/*Given an array check whether the array is in sorted order with recursion
 * 
 * http://practice.geeksforgeeks.org/problems/check-if-an-array-is-sorted/0
 * */
public class Ch2Pr2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numberOfTestCases = s.nextInt();
		for (int i = 1; i <= numberOfTestCases; i++) {
			int sizeOfInput = s.nextInt();
			int[] input = new int[sizeOfInput];
			for (int j = 0; j < sizeOfInput; j++) {
				input[j] = s.nextInt();
			}
			System.out.println(checkIfSorted(input, 0, input.length - 1) ? 1 : 0);
		}

	}

	private static boolean checkIfSorted(int[] input, int start, int end) {
		if (start == end) {
			return true;
		} else {
			return (input[start + 1] >= input[start]) && (checkIfSorted(input, start + 1, end));
		}
	}
}
