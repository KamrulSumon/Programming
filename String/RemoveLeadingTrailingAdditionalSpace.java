package com.sumon.string;

public class RemoveLeadingTrailingAdditionalSpace {
	
	public String removeSpace(String str){
		if(str == null || str.length() == 0) return "";
		
		char[] charArray = str.toCharArray();
		int len = charArray.length;
		int j = 0;
		int i = 0;
		
		while(i < len){
			while(i < len && charArray[i] == ' ') i++;    //skip space
			while(i < len && charArray[i] != ' ') charArray[j++] = charArray[i++]; //keep non space
			//while(i < len && charArray[i] == ' ') i++;    //skip space
			if(j < len) charArray[j++] = ' ';
		}
		charArray[j-1] = '\0';   //new String(charArray).substring(0, j)
		return new String(charArray);
	}
}


class RemoveLeadingTrailingAdditionalSpaceTest{
	public static void main(String[] args){
		RemoveLeadingTrailingAdditionalSpace rs = new RemoveLeadingTrailingAdditionalSpace();
		System.out.println( rs.removeSpace("  fsdf    sfsdsf    ."));
	}
}
