import java.util.Arrays;

public class Solution {
	/* find pair in O(nlgn) */
	public static int[] twoSum(int[] nums, int target) {
		int[] oldNums = Arrays.copyOf(nums, nums.length);
		Arrays.sort(nums);
		int frontIndex = 0;
		int backIndex = nums.length - 1;
		int[] pair = new int[2];

		while (frontIndex < backIndex) {
			if ((nums[frontIndex] + nums[backIndex]) == target) {
				pair[0] = nums[frontIndex];
				pair[1] = nums[backIndex];
				break;
			} else if (nums[frontIndex] + nums[backIndex] > target) {
				backIndex--;
			} else {
				frontIndex++;
			}
		}

		int a = -1, b = -1;
		for (int i = 0; i < nums.length; i++) {

			if (oldNums[i] == pair[0] && a == -1) {
				a = i;
			} else if (oldNums[i] == pair[1] && b == -1) {
				b = i;
			}
		}
		pair[0] = a;
		pair[1] = b;
		return pair;
	}

	/* O(n^2) solution */
	public int[] twoSum2(int[] nums, int target) {
		int[] pair = new int[2];

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					pair[0] = i;
					pair[1] = j;
				}
			}
		}
		return pair;
	}

	public static void main(String[] args) {
		int[] values = { 2, 1, 9, 4, 4, 56, 90, 3 };
		int target = 8;
		int[] pair = twoSum(values, 8);

		System.out.println(pair[0] + "  " + pair[1]);
	}

}