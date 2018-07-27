package com.pranav.geeksforgeeks;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
//https://www.geeksforgeeks.org/merging-intervals/
public class OverLappingInterval {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numberOfTestCases = s.nextInt();
		for (int i = 0; i < numberOfTestCases; i++) {
			int numberOfIntervals = s.nextInt();
			List<Interval> intervalList = new LinkedList<>();
			for (int j = 0; j < numberOfIntervals; j++) {
				intervalList.add(new Interval(s.nextInt(), s.nextInt()));
			}
			Collections.sort(intervalList);
			int currentLeftIndex = 0;
			int currentRightIndex = 1;
			while (currentRightIndex < intervalList.size()) {
				if(intervalList.get(currentRightIndex).start>=intervalList.get(currentLeftIndex).start && intervalList.get(currentRightIndex).start<=intervalList.get(currentLeftIndex).end) {
					Interval mergedInterval = new Interval(intervalList.get(currentLeftIndex).start, Integer.max(intervalList.get(currentLeftIndex).end, intervalList.get(currentRightIndex).end));
					Interval left = intervalList.get(currentLeftIndex);
					Interval right = intervalList.get(currentRightIndex);
					intervalList.remove(left);
					intervalList.remove(right);
					intervalList.add(currentLeftIndex, mergedInterval);
				}else {
					currentLeftIndex++;
					currentRightIndex++;
				}
				
			}
			for(Interval interval : intervalList) {
				System.out.print(interval.getStart()+" "+interval.getEnd()+" ");
			}
		}
	}

	static class Interval implements Comparable<Interval> {
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

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + end;
			result = prime * result + start;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Interval other = (Interval) obj;
			if (end != other.end)
				return false;
			if (start != other.start)
				return false;
			return true;
		}
		

	}

}
