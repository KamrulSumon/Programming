/**
 * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
 * The input string does not contain leading or trailing spaces and the words are always separated by a single space.
 * @Source:  LeetCode #186
 */

package com.sumon.prog.leetcode;

public class ReverseWordsString {

	public class Solution {
		/* reverse words in a sentence */
		public String reverseWords(char[] str) {

			int len = str.length;
			int k = 0;
			for (k = 0; k < len && str[k] == ' '; k++)
				;
			if (k == len)
				return "";

			for (int j = len - 1; j >= 0; j--) {
				int i = j;
				while (i >= 0 && str[i] != ' ')
					i--;
				if (i != j) {
					reverseString(str, i + 1, j);
					j = i;
				}
			}
			reverseString(str, 0, len - 1);
			return new String(str).trim();
		}

		// reverse characters
		public void reverseString(char[] str, int start, int end) {

			while (start <= end) {
				char ch = str[start];
				str[start] = str[end];
				str[end] = ch;
				start++;
				end--;
			}
		}

	}

}
