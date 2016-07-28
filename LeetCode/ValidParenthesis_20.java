package com.sumon.leetcode;
/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * @author Kamrul Hasan
 * @source leetcode #20
 */

import java.util.Stack;
/* validad a parenthesis */
public class ValidParenthesis {
	public boolean isValid(String s) {
		if (s == null)
			return false;
		Stack<Character> stk = new Stack<>();
		int len = s.length();
		if (len % 2 == 1)
			return false;
		for (int i = 0; i < len; i++) {
			char ch = s.charAt(i);
			if (ch == '(' || ch == '{' || ch == '[') {
				stk.push(ch);
			} else {

				if (ch == ')' && !stk.empty() && stk.peek() == '(') {
					stk.pop();
				} else if (ch == '}' && !stk.empty() && stk.peek() == '{') {
					stk.pop();
				} else if (ch == ']' && !stk.empty() && stk.peek() == '[') {
					stk.pop();
				}
			}
		}
		return stk.empty();
	}

}
