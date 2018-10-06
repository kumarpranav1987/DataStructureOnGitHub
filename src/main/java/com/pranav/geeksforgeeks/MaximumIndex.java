package com.pranav.geeksforgeeks;

import java.util.Scanner;

public class MaximumIndex {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numberOfTestCases = s.nextInt();
		for(int i=0;i<numberOfTestCases;i++) {
			int size = s.nextInt();
			int input[] = new int[size];
			for(int j=0;j<size;j++) {
				input[j]=s.nextInt();
			}
			int min[] = new int[size];
			min[0]=input[0];
			for(int j=1;j<size;j++) {
				if(min[j-1]<=input[j]) {
					min[j]=min[j-1];
				}else {
					min[j]=input[j];
				}
			}
			int max[] = new int[size];
			max[size-1]=input[size-1];
			for(int j=size-2;j>=0;j--) {
				if(max[j+1]>=input[j]) {
					max[j]=max[j+1];
				}else {
					max[j]=input[j];
				}
			}
			int j=0,k=0;
			int maxOutput=0;
			while (j<size && k<size) {
				if(min[j]>max[k]) {
					j++;
				}else {
					maxOutput = ((k-j)>maxOutput) ? (k-j) : maxOutput;
					k++;
				}
			}
			System.out.println(maxOutput);
		}
	}
}
