package com.pranav.hackerearth;

import java.util.Scanner;

public class MonkAtTheGraphFactory {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numberOfVertices = s.nextInt();
		int sumOfDegrees =0 ;
		for(int i=0;i<numberOfVertices;i++) {
			sumOfDegrees+=s.nextInt();
		}
		if(sumOfDegrees == (numberOfVertices-1)*1) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
	}
}
