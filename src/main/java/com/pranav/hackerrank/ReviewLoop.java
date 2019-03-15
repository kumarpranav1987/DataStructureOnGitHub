package com.pranav.hackerrank;

import java.util.Scanner;

public class ReviewLoop {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numberOfTestCases = s.nextInt();
		for (int i = 0; i < numberOfTestCases; i++) {
			String data = s.next();
			char[] c = data.toCharArray();
			StringBuffer even = new StringBuffer();
			StringBuffer odd = new StringBuffer();
			for (int j = 0; j < c.length; j++) {
				if (j % 2 == 0) {
					even.append(c[j]);
				} else {
					odd.append(c[j]);
				}
			}
			System.out.println(even.toString()+" "+odd.toString());
		}
	}
}
