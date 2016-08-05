package com.sumon.leetcode;
/**
* Checking whether two string is valid anagram 
* @ Kamrul Hasan
* @ LeetCode #242
*/
public class Solution {
	/* checking valid anagram */
    public boolean isAnagram(String A, String B) {
          int i, lenA, lenB;
       
       A = A.toLowerCase();
       B = B.toLowerCase();
       
       lenA = A.length();
       lenB = B.length();
       
       if(lenA != lenB) return false;
       
       int a [] = new int[26];
       
       for(i = 0; i < lenA; i++ ){
           a[ A.charAt(i) -'a']++;
       }
        
       for(i = 0; i < lenB; i++ ){
           a[ B.charAt(i) - 'a']--;
           
           if(a[ B.charAt(i) - 'a'] < 0) return false;
       }

     return true;
    }
}
