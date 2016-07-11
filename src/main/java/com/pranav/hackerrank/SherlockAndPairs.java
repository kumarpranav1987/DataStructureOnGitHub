package com.pranav.hackerrank;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SherlockAndPairs {

	private static Map<Integer, BigDecimal> previouslyCalculated = new HashMap<>();
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numOfTestCases = s.nextInt();
		for (int i = 0; i < numOfTestCases; i++) {
			int lengthOfInput = s.nextInt();
			Map<Integer, Integer> map = new HashMap<>();
			for (int j = 0; j < lengthOfInput; j++) {
				int data = s.nextInt();
				Integer previousValue = map.get(data);
				if (previousValue == null) {
					map.put(data, 1);
				} else {
					map.put(data, previousValue + 1);
				}
			}
			Collection<Integer> values = map.values();
			BigDecimal result = new BigDecimal(0);
			for (Integer integer : values) {
				if (integer > 1) {
					BigDecimal temp = getNumOfPairs(integer);
					result = result.add(temp);
				}
			}
			System.out.println(result);

		}
	}

	private static BigDecimal getNumOfPairs(int integer) {
		BigDecimal result = previouslyCalculated.get(integer);
		if (result!=null) {
			return result;
		}else {
			result = new BigDecimal(integer).multiply(new BigDecimal(integer-1));	
			previouslyCalculated.put(integer, result);
			return result;
		}
		
	}
}
