package com.pranav.geeksforgeeks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class LargestNumberFormedFromAnArray {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numberOfTestCases = s.nextInt();
		for (int i = 0; i < numberOfTestCases; i++) {
			int size = s.nextInt();
			List<Integer> input = new ArrayList<>(size);
			for (int j = 0; j < size; j++) {
				input.add(s.nextInt());
			}
			Collections.sort(input, new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					String s1 = o1.toString();
					String s2 = o2.toString();

					Integer s1First = Integer.parseInt(new StringBuilder().append(s1).append(s2).toString());
					Integer s2First = Integer.parseInt(new StringBuilder().append(s2).append(s1).toString());
					if (s1First > s2First) {
						return -1;
					} else {
						return 1;
					}
				}
			});
			StringBuilder sb = new StringBuilder();
			for (Integer string : input) {
				sb.append(string.toString());
			}
			System.out.println(sb.toString());
		}
	}
}
