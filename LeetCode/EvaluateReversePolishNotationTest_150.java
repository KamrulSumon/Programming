package com.sumon.leetcode;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * @author Kamrul Hasan
 * @ref LeetCode #150
 */
class EvaluateReversePolishNotation {
	/* evaluate a postfix notation */
	public int evalRPN(String[] tokens) {
		Stack<Integer> stk = new Stack<>();

		for (int i = 0; i < tokens.length; i++) {
			String word = tokens[i];

			if (word.charAt(word.length() - 1) >= '0' && word.charAt(word.length() - 1) <= '9') {
				int num = Integer.parseInt(word);
				stk.push(num);
			} else {
				int num2 = stk.pop();
				int num1 = stk.pop();
				int res = applyOerator(num1, num2, word.charAt(0));
				stk.push(res);
			}
		}

		return stk.pop();
	}
	
	/* apply the operator in two number */
	public int applyOerator(int num1, int num2, char operator) {
		switch (operator) {
		case '+':
			return num1 + num2;
		case '-':
			return num1 - num2;
		case '*':
			return num1 * num2;
		case '/':
			return num1 / num2;
		}
		return 0;
	}
	
	/* String to number conversion */
	private int charArray2Int(char[] cc){
	    int len = cc.length;
	    int num = 0;
	    int i= 0;
	    int sign = 1;
	    if(cc[0]=='-') {
	        sign = -1;
	        i = 1;
	    }
	    for(; i < len; i++){
	        num = (cc[i]-'0') + num * 10;
	    }
	    return sign * num;
	}
}

public class EvaluateReversePolishNotationTest {

	public static void main(String[] args) {
		EvaluateReversePolishNotation erpn = new EvaluateReversePolishNotation();
		String[] t = { "3", "-4", "+" }; // {"2", "1", "+", "3", "*"};
		String[] r = { "4", "13", "5", "/", "+" };
		System.out.println(erpn.evalRPN(t));
	}

}
