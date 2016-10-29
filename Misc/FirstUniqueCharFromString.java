package com.sumon.leetcode.contest;

/**
 * Given a string, find the first non-repeating character in it and return it's index. 
 * If it doesn't exist, return -1.
 * @author Kamrul Hasan
 * @ref LeetCode #387 Warm Up contest
 */
public class FirstUniqueCharFromString {

	public int firstUniqChar(String s) {
        int[] table = new int[256]; // map key -> value
        
        for(int i = 0; i < s.length(); i++){
            table[s.charAt(i)]++;
        }
        
        for(int i = 0; i < s.length(); i++){
            if(table[s.charAt(i)] == 1) return i;
        }
        
        return -1;
    }
}
