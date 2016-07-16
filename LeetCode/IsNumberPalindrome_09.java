package com.sumon.leetcode;
/**
* Checking the digit of a number is palindrome
* @Kamrul Hasan
* 
*/

public class Palindrome {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        
        long rev = 0;
        int org = x;
        while(x > 0){
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        
        while(org > 0){
            int tail1 = org % 10;
            int tail2 = (int) (rev % 10);
            if(tail1 != tail2) return false;
            org /= 10;
            rev /= 10;
        }
        
        return true;
    }
}
