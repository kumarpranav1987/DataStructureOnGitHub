package com.pranav.leetcode;

//https://leetcode.com/problems/maximum-subarray/
public class MaximumSubarray {

	public int maxSubArray(int[] nums) {
		int globalMax = nums[0];
		int maxEndingHere = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > (maxEndingHere + nums[i])) {
				maxEndingHere = nums[i];
			} else {
				maxEndingHere = maxEndingHere + nums[i];
			}
			globalMax = Integer.max(globalMax, maxEndingHere);
		}
		return globalMax;
	}

}
