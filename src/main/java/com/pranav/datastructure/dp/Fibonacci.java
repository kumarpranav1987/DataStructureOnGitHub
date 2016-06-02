package com.pranav.datastructure.dp;
/**
 * To learn basics of dynamic programming.
 * @author pranav.kumar
 *
 */
public class Fibonacci {

	/**
	 * Basic recursive function
	 * Disadvantage  : We are calculation same sub problem many times.
	 *
	 * @param n the n
	 * @return the int
	 */
	private static final int fib(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		return fib(n - 1) + fib(n - 2);
	}

	/**
	 * Using Bottom Up approach of dynamic programming
	 *
	 * @param n the n
	 * @return the int
	 */
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

	/**
	 * Optimized Bottom Up approach here we are not storing all the previously calculated terms, Only last two terms are stored which will be used to calculate next term
	 *
	 * @param n the n
	 * @return the int
	 */
	private static int fib_bottom_up_optmized(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		int nmiunus1 = 1;
		int nmiuns2 = 0;
		int result = 0;
		for (int i = 2; i <= n; i++) {
			result = nmiunus1 + nmiuns2;
			int temp = nmiunus1;
			nmiunus1 = result;
			nmiuns2 = temp;
		}
		return result;
	}

	/**
	 * Using Top down approach of Dynamic Programming
	 *
	 * @param n the n
	 * @return the int
	 */
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

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		System.out.println(fib(6));
		System.out.println(fib_dp_bottom_up(6));
		System.out.println(fib_dp_top_down(6));
		System.out.println(fib_bottom_up_optmized(6));
	}

}
