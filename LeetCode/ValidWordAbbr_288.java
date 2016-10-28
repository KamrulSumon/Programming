/**
 * An abbreviation of a word follows the form <first letter><number><last letter>.
 * Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. 
 * A word's abbreviation is unique if no other word from the dictionary has the same abbreviation
 * @source:  LeetCode #288
 */

package com.sumon.prog.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ValidWordAbbr {

	private HashMap<String, Set<String>> map = null;
	private HashSet<String> set = null;

	public ValidWordAbbr(String[] dictionary) {
		map = new HashMap<>();
		set = new HashSet<>(Arrays.asList(dictionary));
		int len = dictionary.length;
		
		for (int i = 0; i < len; i++) {
			String abbr = getAbbr(dictionary[i]);
			if (!map.containsKey(abbr)) {
				map.put(abbr, new HashSet<String>());
			}
			map.get(abbr).add(dictionary[i]);
		}
	}
	//find unique
	public boolean isUnique(String word) {
		String abbr = getAbbr(word);
		if (map.containsKey(abbr)) {
			Set<String> ss = map.get(abbr);
			if (ss.size() == 1 && set.contains(word))
				return true;
			else
				return false;
		} else {
			return true;
		}
	}
    //find abbreviation
	public String getAbbr(String word) {
		int wordLen = word.length();
		if (wordLen <= 2)
			return word;
		return "" + word.charAt(0) + "" + (wordLen - 2) + "" + word.charAt(wordLen - 1);

	}
}

class ValidWordAbbrTest {
	public static void main(String[] args) {
		String[] dic = { "deer", "door", "cake", "card" };
		ValidWordAbbr wbr = new ValidWordAbbr(dic);
		System.out.println(wbr.isUnique(""));
	}
}
