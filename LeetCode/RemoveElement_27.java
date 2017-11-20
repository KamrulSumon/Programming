package com.sumon.leetcode;


/**
 * Given an array and a value, remove all instances of that value in-place and return the new
 * length. Do not allocate extra space for another array, you must do this by modifying the input
 * array in-place with O(1) extra memory. The order of elements can be changed. It doesn't matter
 * what you leave beyond the new length.
 */

public class RemoveElement {

  public int removeElement(int[] nums, int val) {
    int idx = 0;

    if (nums.length == 0) {
      return 0;
    }

    for (int num : nums) {
      if (num != val) {
        nums[idx++] = num;
      }
    }
    return idx;
  }


  public static void main(String[] args) {
    RemoveElement re = new RemoveElement();
    int[] nums = new int[]{3, 2, 2, 3};
    System.out.println(re.removeElement(nums, 3));
  }

}
