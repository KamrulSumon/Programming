package com.sumon.prog.interviews.ch1;


class FindUniqueCharacter{
	
	boolean isUniqueChars(String str){
		
		int len = str.length();
		if( len > 128 ) return false;
		
		boolean[] char_set = new boolean[128];
		
		for(int i = 0; i < len; i++ ){
			int val = str.charAt(i);
			
			if(char_set[val]){
				return false;
			}
			
			char_set[val] = true;
		}
		
		return true;
	}
}

public class IsUnique {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindUniqueCharacter fu = new FindUniqueCharacter();
		
		System.out.println(fu.isUniqueChars("God t"));

	}

}
