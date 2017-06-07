package com.pranav.geeksforgeeks;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
/*http://practice.geeksforgeeks.org/problems/find-median-in-a-stream/0
*/public class FindMedianInAStream {
	private static Queue<Integer> lowerHalf = new PriorityQueue<>((Integer a, Integer b) -> {
		return b - a;
	});
	private static Queue<Integer> upperHalf = new PriorityQueue<>();
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int sizeOfInput = s.nextInt();
		for (int i = 0; i < sizeOfInput; i++) {
			add(s.nextInt());
			resize();
			printMedian();
		}
	}
	private static void printMedian() {
		Queue<Integer> smaller = lowerHalf.size()<upperHalf.size() ? lowerHalf : upperHalf; 
		Queue<Integer> larger = upperHalf.size()>lowerHalf.size() ? upperHalf : lowerHalf;
		if(smaller.size() == larger.size()){
			System.out.println((smaller.peek()+larger.peek())/2);
		}else {
			System.out.println(larger.peek());
		}
		
	}
	private static void resize() {
		Queue<Integer> smaller = lowerHalf.size()<upperHalf.size() ? lowerHalf : upperHalf; 
		Queue<Integer> larger = upperHalf.size()>lowerHalf.size() ? upperHalf : lowerHalf; 
		if((larger.size()-smaller.size()) >=2){
			smaller.add(larger.poll());			
		}
	}
	private static void add(int nextInt) {
		if((lowerHalf.size() == 0) || (lowerHalf.peek()>nextInt) ){
			lowerHalf.add(nextInt);
		}else {
			upperHalf.add(nextInt);
		}
		
	}
}
