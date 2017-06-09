package com.pranav.geeksforgeeks;

import java.util.Scanner;

/*http://practice.geeksforgeeks.org/problems/maximum-money/0
*/public class MaximumMoney {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numberOfTestcases = s.nextInt();
		for(int i=0;i<numberOfTestcases;i++){
			int numberOfHouses = s.nextInt();
			int amount = s.nextInt();
			if((numberOfHouses%2)==0){
				System.out.println((numberOfHouses/2)*amount);
			}else {
				System.out.println(((numberOfHouses/2)+1)*amount);
			}
		}

	}

}
