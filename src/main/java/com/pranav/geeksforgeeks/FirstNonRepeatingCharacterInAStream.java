package com.pranav.geeksforgeeks;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
/*http://practice.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream/0
*/public class FirstNonRepeatingCharacterInAStream {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numberOfTestCases = s.nextInt();
		for (int i = 0; i < numberOfTestCases; i++) {
			Map<Character, Integer> map = new LinkedHashMap<>();
			int numOfCharacters = s.nextInt();
			for (int k = 0; k < numOfCharacters; k++) {
				char c = s.next().charAt(0);
				Integer currentCount = map.get(c);
				if (currentCount != null) {
					map.put(c, new Integer(currentCount + 1));
				} else {
					map.put(c, new Integer(1));
				}
				Iterator<Character> itr = map.keySet().iterator();
				Character result = null;
				while (itr.hasNext()) {
					Character key = itr.next();
					if (map.get(key).intValue() == 1) {
						result = key;
						break;
					}
				}
				if(result!=null){
					System.out.print(result.charValue()+" ");
				}else {
					System.out.print("-1"+" ");
				}
			}
			System.out.println();
		}
	}
}
