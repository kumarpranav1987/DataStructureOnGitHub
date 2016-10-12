package com.pranav.programcreek;

import java.util.Scanner;

//http://www.programcreek.com/2015/03/rotate-array-in-java/
public class RotateArray {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int order = s.nextInt();
		order = (order % size);
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = s.nextInt();
		}
		reverser(arr, 0, (size - (order + 1)));
		reverser(arr, (size - (order)), size - 1);
		reverser(arr, 0, size - 1);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"  ");
		}
	}

	private static void reverser(int[] arr, int startIndex, int endIndex) {
		for (int i = startIndex, j = endIndex; i <= j; i++, j--) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}
}
