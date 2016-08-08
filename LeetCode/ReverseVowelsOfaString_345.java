package com.sumon.leetcode;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * @author sumon
 * @source LeetCode #345
 */

public class ReverseVowelsOfaString {
	
	/* reverse vowels in a string */ 
	public String reverseVowels(String str){
		if(str == null || str == "") return "";
		
		char[] charArray = str.toCharArray();
		int start = 0;
		int end = charArray.length - 1;
		
		while(start < end){		
			while(start < end && !isVowel(charArray, start)) start++;
			while(end > start && !isVowel(charArray, end)) end--;
			if(isVowel(charArray, start) && isVowel(charArray, end)){
				char ch = charArray[start];
				charArray[start] = charArray[end];
				charArray[end] = ch;
				start++;
				end--;
			}
		}
		return new String(charArray);
	}
	
	/* checking character is vowel in a specified index */
	private boolean isVowel(char[] str, int index){
		return str[index] == 'a' || str[index] == 'e' || str[index] == 'i' || str[index] == 'o' || str[index] == 'u';
	}
	
}

class ReverseVowelsOfaStringTest{
  public static void main(String[] args){
	  ReverseVowelsOfaString sr = new ReverseVowelsOfaString();
	  System.out.println(sr.reverseVowels("hello"));
	  System.out.println(sr.reverseVowels("leetcode"));
  }
}