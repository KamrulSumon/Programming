package com.sumon.leetcode;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * @author Kamrul Hasan
 * @Ref LeetCode #205
 */

import java.util.HashMap;
import java.util.HashSet;

public class IsomorphicString {
	/* Check whether two string is isomorphic */
	public boolean isIsomorphic(String s, String t) {
		HashMap<Character, Character> map = new HashMap<>();
		HashSet<Character> set = new HashSet<>();

		for (int i = 0; i < s.length(); i++) {
			if (!map.containsKey(s.charAt(i))) {
				if (!set.contains(t.charAt(i))) {
					map.put(s.charAt(i), t.charAt(i));
					set.add(t.charAt(i));
				} else { // char already in use
					return false;
				}
			} else if (map.get(s.charAt(i)) != t.charAt(i)) {
				return false;
			}
		}

		return true;
	}
}

class IsomorphicStringTest {
	public static void main(String[] args) {
		IsomorphicString is = new IsomorphicString();
		System.out.println(is.isIsomorphic("foo", "bar"));
		System.out.println(is.isIsomorphic("egg", "add"));
		System.out.println(is.isIsomorphic("paper", "title"));
	}
}
