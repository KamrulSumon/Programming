/**
 * Given an array of n integers nums and a target, 
 * find the number of index triplets i, j, k with 0 <= i < j < k < n that 
 * satisfy the condition nums[i] + nums[j] + nums[k] < target.
*  For example, given nums = [-2, 0, 1, 3], and target = 2.
*  Return 2. Because there are two triplets which sums are less than 2:
*  
*  @source:  LeetCode #259
*/

package com.sumon.prog.leetcode;

import java.util.Arrays;

public class ThreeSumSmaller {

	public int threeSumSmaller(int[] nums, int target) {

		int result = 0;
		int len = nums.length;

		if (nums == null || len == 0 || len < 3)
			return result;

		Arrays.sort(nums);

		for (int i = 0; i < len - 2; i++) {

			int start = i + 1;
			int end = len - 1;

			while (start < end) {
				int sum = nums[i] + nums[start] + nums[end];
				if ((sum < target)) {
					result += (end - start);
					start++;

				} else {
					--end; // skip bigger element
				}
			}

		}

		return result;
	}
}

class ThreeSumSmallerTest {
	public static void main(String[] args) {

		ThreeSumSmaller ts = new ThreeSumSmaller();
		int[] nums = { 3, 1, 0, -2 };

		System.out.println(ts.threeSumSmaller(nums, 4));

	}
}
