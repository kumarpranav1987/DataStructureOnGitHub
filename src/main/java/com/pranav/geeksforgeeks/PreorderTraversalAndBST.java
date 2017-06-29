package com.pranav.geeksforgeeks;

import java.util.Scanner;
import java.util.Stack;
/*http://practice.geeksforgeeks.org/problems/preorder-traversal-and-bst/0
*/
public class PreorderTraversalAndBST {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numberOfTestCases = s.nextInt();
		for (int i = 0; i < numberOfTestCases; i++) {
			int size = s.nextInt();
			int[] input = new int[size];
			for (int j = 0; j < size; j++) {
				input[j] = s.nextInt();
			}
			System.out.println(check(size, input));
		}
	}

	private static int check(int size, int[] input) {
		int root=Integer.MIN_VALUE;
		Stack<Integer> stack = new Stack<>();
		for(int j=0;j<size;j++){
			if(input[j]<root){
				return 0;
			}else {
				while (!stack.isEmpty()&&(stack.peek()<input[j])) {
					root=stack.pop().intValue();
				}
				stack.push(input[j]);
			}
		}
		return 1;
	}
}
