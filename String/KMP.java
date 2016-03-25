package com.algo.kmp;

import static java.lang.System.out;

import java.lang.reflect.Array;

import java.util.ArrayList;

public class KMP {

	ArrayList<Integer> matchIndix = new ArrayList<>();

	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public void KMP_Matcher(String text, String pattern) {

		ArrayList<Integer> matchIndix = new ArrayList<>();
		int pi[], lengthOfText = 0, lengthOfPattern = 0, q = 0, i;

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
				matchIndix.add(i - lengthOfPattern);
				out.println("Pattern occurs with shift: "
						+ (i - lengthOfPattern));
				q = pi[q];
			}
		}
		printPattern(text, pattern, matchIndix);
	}

	// display all occurance of the pattern
	public void printPattern(String text, String pattern,
			ArrayList<Integer> matchIndix) {

		int[] colors = new int[text.length()];

		for (Integer index : matchIndix)
			for (int i = index; i < index + pattern.length(); i++) {
				colors[i] = 1;
			}

		for (int i = 0; i < text.length(); i++)
			out.print(colors[i] + "  ");

		for (int i = 0; i < text.length(); i++) {
			if (colors[i] == 1)
				System.out.print(ANSI_BLUE + text.charAt(i) + ANSI_WHITE);
			else

				System.out.print(text.charAt(i));
		}

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