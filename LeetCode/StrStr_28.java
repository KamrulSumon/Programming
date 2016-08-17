package com.sumon.leetcode;

/**
 * Implement strStr().
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * @author Kamrul Hasan
 * @Ref LeetCode #28 
 */

import java.util.ArrayList;

public class StrStr {
	public int strStr(String text, String pattern) {

		int pi[], lengthOfText = 0, lengthOfPattern = 0, q = 0, i;

		if (text.length() == 0 && pattern.length() == 0)
			return 0;
		if (text.length() == 0)
			return -1;
		if (pattern.length() == 0)
			return 0;

		lengthOfText = text.length(); // length of text
		lengthOfPattern = pattern.length(); // length of pattern
		pi = computPrefixFromPattern(pattern); // Compute the prefix function of
												// pattern

		char T[] = new char[lengthOfText + 1];
		char TT[] = text.toCharArray();

		for (i = 0; i < lengthOfText; i++)
			T[i + 1] = TT[i];

		char P[] = new char[lengthOfPattern + 1];
		char PP[] = pattern.toCharArray();

		for (i = 0; i < lengthOfPattern; i++)
			P[i + 1] = PP[i];

		q = 0;

		for (i = 1; i <= lengthOfText; i++) {

			while (q > 0 && P[q + 1] != T[i]) {
				q = pi[q];
			}

			if (P[q + 1] == T[i])
				q = q + 1;

			if (q == lengthOfPattern) {
				return i - lengthOfPattern;

			}
		}
		return -1;
	}

	// Generate prefix from the pattern
	public int[] computPrefixFromPattern(String pattern) {

		int len; // length of prefix
		int pi[]; // prefix index of pattern
		int q, k;
		len = pattern.length();

		char pat[] = new char[len + 1];
		char p[] = pattern.toCharArray();

		pi = new int[len + 1];

		for (int i = 0; i < len; i++)
			pat[i + 1] = p[i];

		pi[1] = 0;
		k = 0;

		for (q = 2; q < len; q++) {
			while (k > 0 && (pat[k + 1] != pat[q])) {
				k = pi[k];
			}

			if (pat[k + 1] == pat[q])
				k = k + 1;
			pi[q] = k;
		}
		return pi;
	}
}
