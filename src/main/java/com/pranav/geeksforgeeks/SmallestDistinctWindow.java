package com.pranav.geeksforgeeks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SmallestDistinctWindow {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numberOfTestCases = s.nextInt();
		for (int i = 0; i < numberOfTestCases; i++) {
			String input = s.next();
			char[] chars = input.toCharArray();
			Map<Character, Integer> countMap = new HashMap<>();
			for (int j = 0; j < chars.length; j++) {
				char c = chars[j];
				if (countMap.containsKey(c)) {
					int currentCount = countMap.get(c);
					countMap.put(c, currentCount + 1);
				} else {
					countMap.put(c, 1);
				}
			}
			int start = 0;
			for (int j = 0; j < chars.length; j++) {
				start = j;
				char c = chars[j];
				int count = countMap.get(c);
				if (count == 1) {
					break;
				} else {				
					countMap.put(c, count - 1);
				}
			}
			int end = chars.length - 1;
			for (int j = chars.length - 1; j >= start; j--) {
				end = j;
				char c = chars[j];
				int count = countMap.get(c);
				if(count == 1) {
					break;
				}else {
					countMap.put(c, count - 1);
				}
			}
			System.out.println((end-start)+1);
		}
	}
}
