package com.pranav.datastructure.dp;

public class Fibonacci {

	private static final int fib(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		return fib(n - 1) + fib(n - 2);
	}

	private static int fib_dp_bottom_up(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		int[] fibo = new int[n + 1];
		fibo[0] = 0;
		fibo[1] = 1;
		for (int i = 2; i <= n; i++) {
			fibo[i] = fibo[i - 1] + fib(i - 2);
		}
		return fibo[n];
	}

	private static int fib_dp_top_down(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		int[] fibo = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			fibo[i] = -1;
		}
		fibo[0] = 0;
		fibo[1] = 1;
		if (fibo[n] != -1) {
			return fibo[n];
		} else {
			return fibo[n] = fib_dp_top_down(n - 1) + fib_dp_top_down(n - 2);
		}

	}

	public static void main(String[] args) {
		System.out.println(fib(6));
		System.out.println(fib_dp_bottom_up(6));
		System.out.println(fib_dp_top_down(6));
	}

}
