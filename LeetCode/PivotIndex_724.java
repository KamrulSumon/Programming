/**
 * Given an array of integers nums, write a method that returns the "pivot" index of this array. We
 * define the pivot index as the index where the sum of the numbers to the left of the index is
 * equal to the sum of the numbers to the right of the index. If no such index exists, we should
 * return -1. If there are multiple pivot indexes, you should return the left-most pivot index.
 */

public class PivotIndex {

  public int pivotIndex(int[] nums) {
    if (nums.length == 0) {
      return -1;
    }
    int[] sums = new int[nums.length];
    sums[0] = nums[0];

    for (int i = 1; i < nums.length; i++) {
      sums[i] = sums[i - 1] + nums[i];
    }
    int s = sums[sums.length - 1];

    int leftSum = 0;
    for (int i = 0; i < nums.length; i++) {
      if (i != 0) {
        leftSum = sums[i - 1];
      }
      int rightSum = s - leftSum - nums[i];

      if (leftSum == rightSum) {
        return i;
      }
    }
    return -1;
  }


  public static void main(String[] args) {
    int[] arr = {1, 2, 3};
    PivotIndex pi = new PivotIndex();
    System.out.println(pi.pivotIndex(arr));
  }


}
