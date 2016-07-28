package com.sumon.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 * 
 * @author Kamrul Hasan
 * @source LeetCode #17
 */

class LetterCombinationPhoneNumber {
	String two = "abc";
	String three = "def";
	String four = "ghi";
	String five = "jkl";
	String six = "mno";
	String seven = "pqrs";
	String eight = "tuv";
	String nine = "wxyz";

	public List<String> letterCombinations(String digits) {
		HashMap<Integer, String> map = new HashMap<>();
		List<String> result = new ArrayList<>();
		if (digits == null || digits.length() == 0)
			return result;
		map.put(2, two);
		map.put(3, three);
		map.put(4, four);
		map.put(5, five);
		map.put(6, six);
		map.put(7, seven);
		map.put(8, eight);
		map.put(9, nine);

		findLetterCombination(digits, "", result, digits.length(), map);
		return result;
	}

	public void findLetterCombination(String digits, String str, List<String> result, int n,
			HashMap<Integer, String> map) {
		if (str.length() == n) {
			result.add(str);
			return;
		}

		for (int i = 0; i < digits.length(); i++) {
			int d = digits.charAt(i) - '0';
			String next = map.get(d);
			for (int j = 0; j < next.length(); j++) {
				findLetterCombination(digits.substring(i + 1, digits.length()), str + next.charAt(j), result, n, map);
			}
		}
	}
}

public class LetterCombinationPhoneNumberT {

	public static void main(String[] args) {
		LetterCombinationPhoneNumber lp = new LetterCombinationPhoneNumber();
		lp.letterCombinations("23");

	}

}
