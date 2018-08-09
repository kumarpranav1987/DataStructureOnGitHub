package com.pranav.geeksforgeeks;

import java.util.Scanner;

public class SearchInARotatedArray {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numberOfTestCases = s.nextInt();
		for (int i = 0; i < numberOfTestCases; i++) {
			int size = s.nextInt();
			int data[] = new int[size];
			for (int j = 0; j < size; j++) {
				data[j] = s.nextInt();
			}
			int searchElement = s.nextInt();
			int pivotIndex = getPivotIndex(data,0,data.length);
			if (searchElement >= data[0]) {
				System.out.println(binarySearchElement(data, 0, pivotIndex - 1));
			} else {
				System.out.println(binarySearchElement(data, pivotIndex, size - 1));
			}
		}
	}

	private static int binarySearchElement(int[] data, int start, int end) {
		return 0;
	}

	private static int getPivotIndex(int[] data,int start,int end) {
		if(end>start) {
			return -1;
		}
		if(end  == start) {
			return -1;
		}
		
		int mid = (start+end)/2;
		if(data[mid] <data[mid-1] && data[mid] < data[mid+1]) {
			return mid;
		}
		return 0;
	}

}
