package com.sumon.leetcode;

/**
* Given an input string, reverse the string word by word
* @author Kamrul Hasan
* @source LeetCode #151
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ReverseWordsInaString {
	
	/* reverse words */
	public void reverseWords(char[] a, int n) {
	    int i = 0, j = 0;
	      
	    while (i < n) {
	      while (i < j || i < n && a[i] == ' ') i++; // skip spaces
	      while (j < i || j < n && a[j] != ' ') j++; // skip non spaces
	      reverseString(a, i, j - 1);                      // reverse the word
	    }
	  }
	
	/* reverse words */
	public String reverseWords(String s) {
		if (s == null)
			return null;
		if (s == "")
			return s;

		char[] str = s.toCharArray();
		int len = str.length;

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
		return new String(str);
	}
	
	/* reverse words character in a word*/
	public void reverseString(char[] str, int start, int end) {

		while (start <= end) {
			char ch = str[start];
			str[start] = str[end];
			str[end] = ch;
			start++;
			end--;
		}
	}

	public String reverseWords2(String s) {
		 s = s.trim();

		String[] words = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = words.length - 1; i >= 0; i--) {
			if (words[i].length() == 0)
				continue;
			sb.append(words[i].trim());
			if (i != 0)
				sb.append(" ");
		}
		return sb.toString();
	}

	/* reverse words idea from leetcode */
	public String reverseWords3(String s) {
		String[] words = s.trim().split(" +");
		Collections.reverse(Arrays.asList(words));
		return String.join(" ", words);
	}
	
	/* reverse words idea from leetcode */
	void reverseWords4(String s) {
		String rs = "";
		for (int i = s.length() - 1; i >= 0;) {
			while (i >= 0 && s.charAt(i) == ' ')
				i--;
			if (i < 0)
				break;
			if (!rs.isEmpty())
				rs += ' ';
			String t = "";
			while (i >= 0 && s.charAt(i) != ' ')
				t += s.charAt(i--);
			// reverse(t.begin(), t.end());
			rs += t;
		}
		s = rs;
	}
	
	/* reverse words idea from leetcode */
	public String reverseWords5(String s) {
		ArrayList<String> buf = new ArrayList<String>();
		s += ' ';
		int n = s.length(), h = -1;
		for (int i = 0; i < n; i++) {
			if (h == -1 && s.charAt(i) != ' ')
				h = i;
			else if (h != -1 && s.charAt(i) == ' ') {
				buf.add(0, s.substring(h, i));
				h = -1;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (String iter : buf)
			sb.append(iter + " ");
		return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1).toString();
	}

}

class Main {
	public static void main(String[] args) {
		ReverseWordsInaString rs = new ReverseWordsInaString();
		System.out.println(rs.reverseWords3("the    sky is blue"));
	}
}
