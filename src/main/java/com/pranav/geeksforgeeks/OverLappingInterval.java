package com.pranav.geeksforgeeks;
//https://practice.geeksforgeeks.org/problems/overlapping-intervals/0
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class OverLappingInterval {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numberOfTestCases = s.nextInt();
		for (int i = 0; i < numberOfTestCases; i++) {
			int numberOfIntervals=s.nextInt();
			List<Interval> intervalList = new ArrayList<>(numberOfIntervals);
			for(int j=0;j<numberOfIntervals;j++) {
				intervalList.add(new Interval(s.nextInt(), s.nextInt()));
			}
			Collections.sort(intervalList);
			int currentLeftIndex=0;
			int currentRightIndex=1;
			while(currentRightIndex<intervalList.size()) {
				
			}
			
		}
	}

	static class Interval implements Comparable<Interval>{
		private int start;
		private int end;

		public Interval(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		public int getStart() {
			return start;
		}

		public int getEnd() {
			return end;
		}

		@Override
		public int compareTo(Interval o) {
			return this.start - o.start;
		}

	}

}
