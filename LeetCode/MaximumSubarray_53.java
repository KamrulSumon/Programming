package com.sumon.leetcode;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the
 * largest sum. For example, given the array [-2,1,-3,4,-1,2,1,-5,4], the contiguous subarray
 * [4,-1,2,1] has the largest sum = 6 Ref: LeetCode #53
 */
public class MaximumSubarray {

  public int maxSubArray(int[] nums) {
    int maxSumSoFar = nums[0];
    int maxSum = nums[0];

    for (int i = 1; i < nums.length; i++) {
      if (maxSumSoFar + nums[i] < nums[i]) {
        maxSumSoFar = nums[i];
      } else {
        maxSumSoFar += nums[i];
      }

      if (maxSumSoFar > maxSum) {
        maxSum = maxSumSoFar;
      }
    }
    return maxSum;
  }


  public static void main(String[] args) {
    MaximumSubarray ms = new MaximumSubarray();
    int[] nums = {1, 2};
    System.out.println(ms.maxSubArray(nums));
  }
}
