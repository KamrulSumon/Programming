package com.sumon.leetcode;

/**
 * Roman to int conversion
 * @author Kamrul Hasan
 * @source leetcode 13
 */

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
	/* roman to int conversion */
	public int romanToInt(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		int number = 0;

		for (int i = 0; i < s.length() - 1; i++) {
			char ch = s.charAt(i);
			int value = map.get(ch);

			if (value < map.get(s.charAt(i + 1))) {
				number -= value;
			} else {
				number += value;
			}
		}

		number += map.get(s.charAt(s.length() - 1));
		return number;
	}
}
