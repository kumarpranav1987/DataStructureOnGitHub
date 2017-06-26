package com.pranav.geeksforgeeks;

import java.util.Scanner;

/*http://practice.geeksforgeeks.org/problems/unsorted-array/0
*/	
public class UnsortedArray {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numberOfTestCases = s.nextInt();
		for (int i = 0; i < numberOfTestCases; i++) {
			int size = s.nextInt();
			int[] input = new int[size];
			for (int j = 0; j < size; j++) {
				input[j] = s.nextInt();
			}
			int[] highestFromLeft = new int[size];
			highestFromLeft[0] = input[0];
			for (int j = 1; j < size; j++) {
				if (input[j] > highestFromLeft[j - 1]) {
					highestFromLeft[j] = input[j];
				} else {
					highestFromLeft[j] = highestFromLeft[j - 1];
				}
			}
			int[] smallestFromRight = new int[size];
			smallestFromRight[size - 1] = input[size - 1];
			for (int j = size - 2; j >= 0; j--) {
				if(input[j]<smallestFromRight[j+1]){
					smallestFromRight[j]=input[j];
				}else {
					smallestFromRight[j]=smallestFromRight[j+1];
				}
			}
			int result=-1;
			for(int j=1;j<size-1;j++){
				if((input[j]>=highestFromLeft[j])&&(input[j]<=smallestFromRight[j])){
					result = input[j];
					break;
				}
			}
			System.out.println(result);
		}

	}

}
