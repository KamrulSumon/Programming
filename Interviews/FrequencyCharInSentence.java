/**
 * Count the frequency of Char in a Sentence
 */

import java.util.Arrays;

public class FrequencyCharInSentence {

	public void countOccurance(String str){
		char[] charArr = str.toCharArray();
		Arrays.sort(charArr);
		
		int currentCharCount = 1;
		int len = charArr.length;
		
		for(int i = 1; i < len; i++){
			if(charArr[i] == charArr[i-1]){
				currentCharCount++;
			}else{
				System.out.println(charArr[i-1] + " occur :"+currentCharCount);
				currentCharCount = 1;
			}
		}
		
		System.out.println(charArr[len-1] + " occur :"+currentCharCount);
	}
}


class FrequencyCharInSentenceTest {

	public static void main(String[] args){
		FrequencyCharInSentence fo = new FrequencyCharInSentence();
		fo.countOccurance("Dhaka Bangladesh");
	}
}
