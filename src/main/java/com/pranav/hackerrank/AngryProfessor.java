package com.pranav.hackerrank;

import java.util.Scanner;

public class AngryProfessor {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numberOfTestCases = s.nextInt();
		for (int i = 0; i < numberOfTestCases; i++) {
			int numOfStudents = s.nextInt();
			int threshold = s.nextInt();
			int onTime =0;
			for(int j=0;j<numOfStudents;j++){
				int time = s.nextInt();
				if(time<=0){
					onTime++;
				}
			}
			if (onTime>=threshold) {
				System.out.println("NO");
			}else {
				System.out.println("YES");
			}
		}
	}
}
