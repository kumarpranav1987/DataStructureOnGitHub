package com.pranav.geeksforgeeks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*http://www.geeksforgeeks.org/count-pairs-with-given-sum/
*/
public class CountPairsWithGivenSum {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numberOfTestCases = s.nextInt();
		for (int i = 0; i < numberOfTestCases; i++) {
			int same = 0;
			int different = 0;
			int sizeIfArray = s.nextInt();
			int sum = s.nextInt();
			Map<Integer, Integer> data = new HashMap<>();
			for (int j = 0; j < sizeIfArray; j++) {
				int currentData = s.nextInt();
				Integer currentCount = data.get(currentData);
				if (currentCount != null) {
					data.put(currentData, new Integer(currentCount.intValue() + 1));

				} else {

					data.put(currentData, Integer.valueOf(1));
				}
			}
			Set<Integer> keys = data.keySet();
			for (Integer k : keys) {
				Integer fre = data.get(k);
				if (k == (sum - k)) {
					if (fre > 1) {
						same += ((fre * (fre - 1)) / 2);
					}
				} else {
					Integer other = data.get(sum - k);
					if (other != null) {
						different += ((fre * other));
					}
				}
			}
			System.out.println(same + (different / 2));
		}

	}

}
