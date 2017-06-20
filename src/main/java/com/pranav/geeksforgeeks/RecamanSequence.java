package com.pranav.geeksforgeeks;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*http://practice.geeksforgeeks.org/problems/recamans-sequence/0
*/public class RecamanSequence {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numberOfTestCases = s.nextInt();
		for (int i = 0; i < numberOfTestCases; i++) {
			printRecaman(s.nextInt());
			System.out.println();
		}

	}

	private static void printRecaman(int nextInt) {
		HashMap<Integer, Integer> values = new HashMap<>();
		for (int i = 0; i < nextInt; i++) {
			System.out.print(getRecman(i, values) + " ");
		}
	}

	private static int getRecman(int i, HashMap<Integer, Integer> values) {
		if (i == 0) {
			values.put(0, 0);
			return 0;
		} else {
			Integer val = values.get(i - 1);
			int prev = 0;
			if (val == null) {
				prev = getRecman(i - 1, values);

			} else {
				prev = val.intValue();
			}
			int tempResult = (prev - i);
			int result = ((tempResult > 0) && (!values.values().contains(tempResult))) ? tempResult : (prev + i);
			values.put(i, result);
			return result;
		}
	}

}
