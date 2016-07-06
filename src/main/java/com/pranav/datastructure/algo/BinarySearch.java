package com.pranav.datastructure.algo;

public class BinarySearch {

	public static void main(String[] args) {
		int[] data = new int[] { 1, 2, 4, 4, 4, 4, 4, 4, 5, 5 };
		System.out.println(binarySearch(data, 4));
		System.out.println(binarySearchLeftMost(data, 4));
		System.out.println(binarySearchRightMost(data, 4));
	}

	private static int binarySearch(int[] data, int element) {
		int start = 0;
		int end = data.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (data[mid] == element) {
				return mid;
			} else if (element > data[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}

	private static int binarySearchLeftMost(int[] data, int element) {
		int result = -1;
		int start = 0;
		int end = data.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (data[mid] == element) {
				result = mid;
				end = mid - 1;
			} else if (element > data[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return result;
	}

	private static int binarySearchRightMost(int[] data, int element) {
		int result = -1;
		int start = 0;
		int end = data.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (data[mid] == element) {
				result = mid;
				start = mid + 1;
			} else if (element > data[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return result;
	}
}
