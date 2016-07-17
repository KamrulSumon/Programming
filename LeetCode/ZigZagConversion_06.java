/**
 * ZigZag conversion LeetCode 6
 * @author Kamrul Hasan
 */
package com.sumon.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {

	public String convert(String s, int numRows) {
		ArrayList<ArrayList<Character>> lists = new ArrayList<ArrayList<Character>>();
		StringBuilder sb = new StringBuilder();
		
		if (s.isEmpty())
			return "";
		
		for (int i = 0; i < numRows; i++) {
			lists.add(new ArrayList<Character>());
		}

		for (int i = 0; i < s.length();) {
			// add each list	
			for (int j = 0; j < numRows; j++) {
				if (i < s.length())
					lists.get(j).add(s.charAt(i++));
			}
			// add to the diagonal
			for (int k = numRows - 2; k >= 1; k--) {
				if (i < s.length())
					lists.get(k).add(s.charAt(i++));
			}
		}

		for (int i = 0; i < numRows; i++) {
			for (Character c : lists.get(i))
				sb.append(c);
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		ZigZagConversion ob = new ZigZagConversion();
		// ob.convert("PAYPALISHIRING", 3);
		System.out.println(ob.convert("A", 1));

	}
}
