package com.sumon.java;

/**
 * Longest common prefix among an array of string
 * @author Kamrul Hasan
 * @source LeetCode #14
 */

class LongestCommonPrefix {
	/* find longest prefix among all the string in an arry */
	public String longestCommonPrefix(String[] strs) {
		int len = strs.length;
		if (strs == null || len == 0)
			return "";

		String minStr = strs[0];
		// find the shortest length string
		for (int i = 1; i < len; i++) {
			if (strs[i].length() < minStr.length()) {
				minStr = strs[i];
			}
		}

		int minLen = minStr.length();

		for (int i = 0; i < len; i++) {
			int j;
			for (j = 0; j < minLen; j++) {
				if (strs[i].charAt(j) != minStr.charAt(j)) // mismatch
					break;
			}

			minLen = j; // minLen gets shorter when there is mismatch between
						// characters less than minLen
		}

		return minStr.substring(0, minLen);

	}
}


