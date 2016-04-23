package com.pranav.hackerrank;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MarganString {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new FileInputStream(new File("C:\\Git\\input.txt")));
		List<StringBuilder> resultList = new ArrayList<StringBuilder>();
		int testSize = s.nextInt();
		for (int i = 0; i < testSize; i++) {
			StringBuilder result = new StringBuilder();
			char[] a = s.next().toCharArray();

			char[] b = s.next().toCharArray();

			// List<Character> result = new LinkedList<>();
			int j = 0, k = 0;
			while (j < a.length && k < b.length) {
				if (a[j] <= b[k]) {

					result.append(a[j]);

					j++;
				} else {

					result.append(b[k]);

					k++;
				}
			}
//			while (j < a.length) {
//				result.append(a[j]);
//
//				j++;
//			}
//
//			while (k < b.length) {
//				result.append(b[k]);
//
//				k++;
//			}
			//System.out.println("result"+new String(result));
			resultList.add(result);
		}
		for (int i = 0; i < testSize; i++) {
			System.out.println(resultList.get(i));
		}
	}
}