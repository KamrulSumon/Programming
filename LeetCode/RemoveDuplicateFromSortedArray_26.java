package com.sumon.leetcode;

/**
 * Remove duplicates from a sorted array
 * 
 * @author Kamrul Hasan
 * @source LeetCode #26
 */
class RemoveDuplicate {
	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int len = nums.length;
		int count = 0;

		for (int i = 0; i < len; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) //skip duplicate element
				continue;
			nums[count++] = nums[i];
		}
		return count;
	}
}

public class RemoveDuplicateFromSortedArray {

	public static void main(String[] args) {
		RemoveDuplicate rd = new RemoveDuplicate();
		int[] nums = { 1, 1, 2 };
		System.out.println(rd.removeDuplicates(nums));

	}

}
