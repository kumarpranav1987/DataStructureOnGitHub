package com.pranav.hackerrank;

import java.util.Scanner;

public class EqualizeTheArray {
	public static void main(String[] args) {
		int[] data = new int[100];
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for(int i=0;i<n;i++){
			int value = s.nextInt();
			data[value-1] = data[value-1]+1;
		}
		
		int maxCount=0;
		int requiredDeletion=0;
		for(int i=0;i<100;i++){
			if (data[i]>maxCount) {
				requiredDeletion = requiredDeletion+maxCount;
				maxCount = data[i];				
			}else {
				requiredDeletion = requiredDeletion + data[i];
			}
		}
		System.out.println(requiredDeletion);
	}
	
}
