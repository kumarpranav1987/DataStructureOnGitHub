package com.pranav.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class BalanceParentheses {

	public static void main(String[] args) {
		Map<Character, Character> reverseMapping = new HashMap<>();
		reverseMapping.put(')', '(');
		reverseMapping.put('}', '{');
		reverseMapping.put(']', '[');
		Scanner s = new Scanner(System.in);
		int numTestCases = Integer.parseInt(s.nextLine());
		String cunrrentString;
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < numTestCases; i++) {
			stack.clear();
			cunrrentString = s.nextLine();
			if (!cunrrentString.isEmpty()) {
				boolean b = false;
				for (int j = 0; j < cunrrentString.length(); j++) {
					char c = cunrrentString.charAt(j);
					if (c == '(' || c == '{' || c == '[') {
						stack.push(c);
					} else {
						if (stack.isEmpty()) {
							b = true;
							break;
						} else if (stack.pop() == reverseMapping.get(c)) {
							continue;
						} else {
							b = true;
							break;
						}
					}
				}
				/*if (stack.isEmpty()) {
					System.out.println("YES");
				}*/

				if (!stack.isEmpty() || b) {
					System.out.println("NO");
				}else {
					System.out.println("YES");
				}
			}
		}

	}

}
