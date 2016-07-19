package com.sumon.leetcode;

/**
 * Find three sum(a+b+c) closest to a target
 * @author Kamrul Hasan
 * @source LeetCode #16
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSumImpl {
	/* find a+b+c closest to target in O(N^2) */
	public int threeSumClosest(int[] array, int target) {
		List<List<Integer>> list = new ArrayList<>();
		int len = array.length;
		int min = Integer.MAX_VALUE;
		int closest = 0;
		if (array == null || len == 0 || len < 3)
			return 0;

		Arrays.sort(array);

		for (int i = 0; i < len - 2; i++) {
			if (i > 0 && array[i] == array[i - 1])
				continue; // skip same a
			int start = i + 1;
			int end = len - 1;

			while (start < end) {
				int sum = array[i] + array[start] + array[end];
				int diff = Math.abs(target - sum);
				if (diff < min) {
					min = diff;
					closest = sum;
				} else if (sum > target) {
					--end; // skip bigger element
				} else {
					++start; // move right for bigger element
				}
			}
		}
		return closest;
	}
}

public class ThreeSumClosest {

	public static void main(String[] args) {
		ThreeSumImpl ts = new ThreeSumImpl();
		int[] array = { 1, 1, -1, -1, 3 };
		System.out.println(ts.threeSumClosest(array, -1));

	}

}
