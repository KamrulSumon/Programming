package com.sumon.leetcode;

public class ReverseString {

	/* reverse word */
	public String reverseString(String s) {
		char[] array = s.toCharArray();
		for (int i = 0; i < array.length / 2; i++) {
			char temp = array[i];
			array[i] = array[array.length - i - 1];
			array[array.length - i - 1] = temp;

		}
		return new String(array);
	}

	/* reverse string */
	public String reverseString2(String s) {
		if (s == null)
			return null;
		if (s.equals(""))
			return s;
		char[] arrChar = s.toCharArray();
		for (int i = 0, j = arrChar.length - 1; i <= j; i++, j--) {
			char temp = arrChar[i];
			arrChar[i] = arrChar[j];
			arrChar[j] = temp;
		}
		return new String(arrChar);
	}

	/* reverse string using StringBuilder */
	public String reverseString3(String str) {
		StringBuilder f = new StringBuilder();
		StringBuilder s = new StringBuilder();

		if (str == null)
			return null;
		if (str.length() == 0)
			return str;

		int len = str.length();

		for (int i = 0; i < len / 2; i++) {
			f.append(str.charAt(i));
			s.append(str.charAt(len - 1 - i));
		}
		if (len % 2 == 1)
			s.append(str.charAt((int) len / 2));
		return s.append(f.reverse()).toString();

	}
}
