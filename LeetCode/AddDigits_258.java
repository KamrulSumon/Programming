package com.sumon.leetcode;
/**
* Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
* @Kamrul Hasan
* @LeetCode #258
*/

public class Solution {
    public int addDigits(int num) {
        if(num < 10) return num;
        if(num % 9 == 0) return 9;
        else
        return num % 9;
    }
}


/**
Idea taken from LeetCode
 Let's take a couple of more example and see if we can deduce some pattern for the result:
Example 3:
Input: 10
Step 1: 1+0 = 1 (Expected output)

Example 4:
Input: 11
Step 1: 1+1 = 2 (Expected output)

Example 5:
Input: 12
Step 1: 1+2 = 3 (Expected output)

Example 6:
Input: 18
Step 1: 1+8 = 9 (Expected output)

Arguments: In mathematics we have learnt that any number that is divisible by 9, the sum of the digits in the number is also divisible by 9. Also, here we know that the result of the problem is an integer lying in the range [0,9] .

From the above arguments and samples, we can see that the result depends on the divisibility of a number by 9.

*/

