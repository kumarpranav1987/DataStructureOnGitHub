package com.pranav.hackerearth;

import java.util.Scanner;

public class HealthOfAPerson {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int i = 0; i < t; i++) {
			int n = s.nextInt();
			int m = s.nextInt();
			int[] personHealthPoints = new int[n + 1];
			for (int j = 1; j < n + 1; j++) {
				personHealthPoints[j] = s.nextInt();
			}
			int[] reductionInHealth = new int[m + 1];
			for (int j = 1; j < m + 1; j++) {
				reductionInHealth[j] = s.nextInt();
			}
			for (int j = 1; j < m + 1; j++) {
				boolean found = false;
				for (int k = j; k < n + 1; k=k+j) {
					if (k % j == 0) {
						if (personHealthPoints[k] <= reductionInHealth[j]) {
							System.out.println(j);
							found = true;
							break;
						}
					}

				}
				if (!found) {
					System.out.println("-1");
				}
			}
		}
		s.close();
	}

}
