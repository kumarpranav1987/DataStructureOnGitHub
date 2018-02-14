//https://practice.geeksforgeeks.org/problems/count-total-set-bits/0
package com.pranav.geeksforgeeks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountTotalSetBits {
	static Map<Integer, Integer> cache = new HashMap<>();

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numberOfTestCases = s.nextInt();

		for (int i = 0; i < numberOfTestCases; i++) {
			int n = s.nextInt();
			int sum = 0;
			for (int j = 1; j <= n; j++) {
				sum += getNumberOfSetBits(j);
			}
			System.out.println(sum);
		}
	}

	private static int getNumberOfSetBits(int j) {
		if (j == 0)
			return 0;
		if (cache.get(j) != null) {
			return cache.get(j);
		} else {
			if (j % 2 == 1) {
				return 1 + getNumberOfSetBits(j >> 1);
			} else {
				return getNumberOfSetBits(j >> 1);
			}
		}
	}
}
