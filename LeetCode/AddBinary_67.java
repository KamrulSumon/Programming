package com.sumon.leetcode;
/**
* Given two binary strings, return their sum (also a binary string).
* @ Kamrul Hasan
* @ LeetCode #67
*/

class AddBinary{
	 /* add two binary string */
	 public String addBinary(String num1, String num2){
		if(num1 == null && num2 == null) return null;
		if(num1 == null || num1.isEmpty()) return num2;
		if(num2 == null || num2.isEmpty()) return num1;
		
		int len1 = num1.length() - 1;
		int len2 = num2.length() - 1;
		
		StringBuilder sb = new StringBuilder("");
		int carry = 0;
		
		while( len1 >= 0 || len2 >= 0){
			int n1 = len1 < 0 ? 0 : num1.charAt(len1) - '0';
			int n2 = len2 < 0 ? 0 : num2.charAt(len2) - '0';
			
			int sum = n1 + n2 + carry;
			carry = sum >> 1;   // remove the least bit
			sum = sum & 1;     // 
			
			sb.append(sum == 0 ? '0' : '1');
			len1--;
			len2--;
		} 
		
		if(carry == 1){
			sb.append('1');
		}
		
		sb.reverse();
		return sb.toString();
	}
}


