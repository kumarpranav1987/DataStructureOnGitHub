package com.pranav.datastructure.algo;

/**
 * Find max sum sub Array
 */
public class KadaneAlgo {
	private static int maxSumSubArrary(int[] arr) {
		int max_till_now = arr[0], maxending_here = arr[0];
		for (int i = 1; i < arr.length; i++) {
			maxending_here = Integer.max(maxending_here + arr[i], arr[i]);
			max_till_now = Integer.max(max_till_now, maxending_here);
		}
		return max_till_now;
	}

	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,-5,100};
		System.out.println(maxSumSubArrary(arr));
	}
}
