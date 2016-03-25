package com.sumon.prog.interviews.URLify;



class URLifyImp{
	
	String replaceSpaces(char[] str, int len){
		int spaceCount = 0, newLen, i;
		
		for(i = 0; i < len; i++){
			if( str[i] == ' '){
				spaceCount++;
			}			
		}
		
		newLen = len + spaceCount * 2;
		str[newLen] = '\0';
		for(i = len -1; i >= 0; i-- ){
			
			if(str[i] == ' '){
				str[newLen-1] = '0';
				str[newLen-2] = '2';
				str[newLen-3] = '%';
				newLen = newLen - 3;
			}else{
				str[newLen - 1] = str[i];
				newLen = newLen - 1;
			}
			
		}
		return new String(str);
	}
}


public class URLify {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		URLifyImp url = new URLifyImp();
		
		System.out.println(url.replaceSpaces("Mr Kamrul Hasan\0                  ".toCharArray(), 15));
	}

}
