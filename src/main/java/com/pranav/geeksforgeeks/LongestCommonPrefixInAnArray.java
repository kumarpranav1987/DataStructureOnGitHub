package com.pranav.geeksforgeeks;

import java.util.Scanner;

public class LongestCommonPrefixInAnArray {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numberOfTestCases = s.nextInt();
		for(int i=0;i<numberOfTestCases;i++) {
			int numberOfWords = s.nextInt();
			String words[]=new String[numberOfWords];
			for(int j=0;j<numberOfWords;j++) {
				words[j]=s.next();
			}
			int minLength = Integer.MAX_VALUE;
			String minlenghtword = null;
			for(String word:words) {
				if(word.length()<minLength) {
					minLength = word.length();
					minlenghtword=word;
				}
			}
			boolean found = false;
			for(int substringsize=minLength;substringsize>0;substringsize--) {
				int k=0;
				for(k=0;k<numberOfWords;k++) {
					if(!minlenghtword.substring(0, substringsize).equals(words[k].substring(0, substringsize))) {
						break;
					}
				}
				if(k==numberOfWords) {
					System.out.println(minlenghtword.substring(0, substringsize));
					found = true;
					break;
				}
			}
			if(!found) {
				System.out.println(-1);
			}
		}

	}

}
