package com.pranav.geeksforgeeks;

import java.util.Scanner;

/*http://practice.geeksforgeeks.org/problems/geek-and-coffee-shop/0
*/
public class GeekAndCoffeeShop {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numberOfTestCases = s.nextInt();
		for(int i=0;i<numberOfTestCases;i++){
			int n = s.nextInt();
			int m =s.nextInt();
			System.out.println(n/(int)Math.pow(2, (m-1)));
		}

	}

}
