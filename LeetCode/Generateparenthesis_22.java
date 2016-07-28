package com.sumon.leetcode;
/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * @author Kamrul Hasan
 * @source Leetcode #22
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
	/* generate parenthesis */
	public List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<>();
		Set<String> set = generateList(n);
		for (String ss : set)
			list.add(ss);
		return list;
	}

	public Set<String> generateList(int n) {
		Set<String> result = new HashSet<String>();
		if (n == 1) {
			result.add("()");
			return result;
		}
		Set<String> prev = generateList(n - 1);
		for (String st : prev) {
			for (int i = 0; i < st.length(); i++) {
				if (st.charAt(i) == '(') {
					String str = insertParen(st, i);
					result.add(str);
				}
			}
			result.add("()" + st);
		}
		return result;
	}
	/* insert paren inside */
	String insertParen(String str, int index) {
		String leftStr = str.substring(0, index + 1);
		String rightStr = str.substring(index + 1, str.length());
		return leftStr + "()" + rightStr;
	}
}

public class Generateparenthesis {

	public static void main(String[] args) {
		Solution s = new Solution();
		Set<String> set = s.generateList(4);
		for (String ss : set)
			System.out.println(ss);
	}

}
