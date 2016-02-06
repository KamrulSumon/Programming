package com.sumon.prog.interviews.checkPermutaiton;

import java.util.Arrays;

class CheckPermutation{
	//sort string
	String sort(String str){
		char[] content = str.toCharArray();
		Arrays.sort(content);
		return new String( content );
	}
	
	//Version 1
	boolean checkPermutation(String ss , String tt){
		int ssLen = ss.length();
		int ttLen = tt.length();
		
		if( ssLen != ttLen ) return false;
		
		return sort(ss).equals(sort(tt));
	}
	
	boolean checkPermutationAnotherWay(String ss, String tt){
		int ssLen = ss.length();
		int ttLen = tt.length();
		
		if( ssLen != ttLen ) return false;
		
		
		int[] char_idx = new int[128]; // assume only ASCII characters
		char[] char_array = ss.toCharArray(); //
		
		for(char c: char_array)
			char_idx[c]++;
		
		for(int i = 0; i < ttLen; i++){
			int val = (int) tt.charAt(i);
			
			char_idx[val]--;
			if( char_idx[val] < 0 ) return false; 
			
		}
		
		return true;
	}
}


public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckPermutation cp = new CheckPermutation();
		
		System.out.println(cp.checkPermutationAnotherWay("gold", "logd"));
	}

}
