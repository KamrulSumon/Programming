package com.sumon.misc;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Display unique characters in reverse order from a string 
 * @author Kamrul Hasan
 *
 */

class StringReverseWithUniqueCharacterImpl{
	/* display unique character in reverse order */
	public String reverseStringWithUniqueCharacter(String str){
		if(str == null) return null;
		
		Set<Character> reverseUniqueStr = new LinkedHashSet<>();
		
		for(int index = str.length() - 1; index >= 0; index--){
			if(!reverseUniqueStr.contains(str.charAt(index))){
				Character ch = str.charAt(index);
				reverseUniqueStr.add(ch);
			}
		}
		
		return reverseUniqueStr.toString();
	}
}

public class StringReverseWithUniqueCharacters {

	public static void main(String[] args) {
		StringReverseWithUniqueCharacterImpl sr = new StringReverseWithUniqueCharacterImpl();
		String str = "aabdceaaabbbcd";
		System.out.println(sr.reverseStringWithUniqueCharacter(str));
	}

}
