package com.pranav.geeksforgeeks;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*http://practice.geeksforgeeks.org/problems/stepping-numberswrong-output/0
 */
public class SteppingNumbers {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numberOfTestCases = s.nextInt();
		for (int i = 0; i < numberOfTestCases; i++) {
			int n = s.nextInt();
			int m = s.nextInt();
			printCount(n, m);
		}
	}

	private static void printCount(int n, int m) {
		int count = 0;
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i <=9; i++) {
			queue.add(i);
		}
		while (!queue.isEmpty()) {
			Integer current = queue.poll();
			if (n <= current && current <= m) {
				count++;
			}
			if (current == 0 || current > m) {
				continue;
			}
			int lastDigit =  current>9 ?current % 10:current;
			if(lastDigit==0){
				queue.add(new Integer((current*10)+(lastDigit+1)));
			}else if (lastDigit==9) {
				queue.add(new Integer((current*10)+(lastDigit-1)));
			}else {
				queue.add(new Integer((current*10)+(lastDigit+1)));
				queue.add(new Integer((current*10)+(lastDigit-1)));
			}
		}
		System.out.println(count);
	}
}
