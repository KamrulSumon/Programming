package com.sumon.java;

/**
 * String to number conversion
 * @author Kamrul Hasan
 * @leetCode _08
 */

public class StringToNumber {

	public static int myAtoi(String str) {
		if (str == null || str.length() == 0)
			return 0;
		str = str.trim();
		int index = 0;
		int sign = 1;
		
		if (str.charAt(0) == '-' || str.charAt(0) == '+') {
			sign = str.charAt(0) == '+' ? 1 : -1;
			index = 1;
		}
		
		int res = 0;
		for (int i = index; i < str.length(); i++) {
			int digit = str.charAt(i) - '0';
			if (digit < 0 || digit > 9)
				break;
			// check if res will be overflow after 10 times and add digit
			if (Integer.MAX_VALUE / 10 < res || Integer.MAX_VALUE / 10 == res && Integer.MAX_VALUE % 10 < digit)
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			res = res * 10 + digit;
		}
		return res * sign;
	}
}
