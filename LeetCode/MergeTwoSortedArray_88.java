package com.sumon.leetcode;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
 */

public class MergeTwoSortedArray {

  public void merge(int[] nums1, int m, int[] nums2, int n) {

    int Idx = m + n - 1;
    int i = m - 1;
    int j = n - 1;

    while (i >= 0 && j >= 0) {
      if (nums1[i] >= nums2[j]) {
        nums1[Idx--] = nums1[i--];
      } else if (nums1[i] < nums2[j]) {
        nums1[Idx--] = nums2[j--];
      }
    }
    while (j >= 0) {
      nums1[Idx--] = nums2[j--];
    }
  }


  public static void main(String[] args) {
    MergeTwoSortedArray msa = new MergeTwoSortedArray();
    int[] nums1 = new int[10];
    nums1[0] = 3;
    nums1[1] = 7;
    nums1[2] = 45;
    nums1[3] = 50;
    nums1[4] = 60;
    int[] nums2 = new int[]{2, 7, 9, 10, 15};
    msa.merge(nums1, 5, nums2, 5);
  }
}
