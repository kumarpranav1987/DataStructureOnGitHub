package com.pranav.hackerrank;

import java.math.BigInteger;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution1 {
	static char[] numbers;
	static int alreadyProcesssedQueryIndex = 0;
	static BigInteger previoussize=new BigInteger("0");
	static BigInteger key = new BigInteger("0");
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numLen = s.nextInt();
		int numberofquery = s.nextInt();
		List<String> list = new LinkedList<String>();
		numbers = s.next().toCharArray();
		BigInteger[] queries = new BigInteger[numberofquery];
		for (int i = 0; i < numberofquery; i++) {
			queries[i] = new BigInteger(s.next());
		}
		
		for (int i = 1; i <= numbers.length; i++) {
			HashMap<BigInteger, BigInteger> map = new HashMap<>();
			List<BigInteger> big = getSortedNumbersOfParticularSize(i);
			for(int k=0;k<big.size();k++){
				key=key.add(new BigInteger("1"));
				map.put(key, big.get(k));
			}
			while (alreadyProcesssedQueryIndex<queries.length && queries[alreadyProcesssedQueryIndex].compareTo(key) <=0) {
				System.out.println(map.get(queries[alreadyProcesssedQueryIndex]).mod(new BigInteger("1000000007")));
				alreadyProcesssedQueryIndex++;
			}
		}

		/*
		 * Collections.sort(list, new Comparator<String>() {
		 * 
		 * @Override public int compare(String o1, String o2) { if (o1.length()
		 * != o2.length()) return o1.length() - o2.length(); else { int i = 0;
		 * while ((i < o1.length() && o1.charAt(i) == o2.charAt(i))) { i++; } if
		 * (i == o1.length()) return 0; else { return o1.charAt(i) -
		 * o2.charAt(i); } } } });
		 */
		//
		// List<BigInteger> big = new LinkedList<BigInteger>();
		// for (int i = 0; i < list.size(); i++) {
		// big.add(new BigInteger(list.get(i)));
		// }
		// Collections.sort(big);
		// for (int i = 0; i < numberofquery; i++) {
		// System.out.println(big.get(queries[i].intValue() - 1).mod(new
		// BigInteger("1000000007")));
		// }
	}

	static String getStringRepresentation(List<Character> currentResult) {
		StringBuilder builder = new StringBuilder(currentResult.size());
		for (Character ch : currentResult) {
			builder.append(ch);
		}
		return builder.toString();
	}

	static List<BigInteger> getSortedNumbersOfParticularSize(int size) {
		List<BigInteger> big = new LinkedList<>();
		for (int start = 0, end = size - 1; ((end - start) < size) && end < numbers.length; start++, end++) {
			if (Character.getNumericValue(numbers[start]) != 0) {
				List<Character> charList=new LinkedList<>();
				for (int j = start; j <= end; j++) {
					 
					charList.add(numbers[j]);
					
				}
				big.add(new BigInteger(getStringRepresentation(charList)));
			} else if (size==1){
				big.add(new BigInteger("0"));

			}

		}
		Collections.sort(big);
		return big;
	}
}
