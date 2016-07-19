package com.sumon.leetcode;

/**
 * Find the  a + b + c + d = target from an given array
 * @author Kamrul Hasan
 * @source LeetCode #18
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FourSumImpl {
	/* find a + b + c + d == target without duplicate O(N^2) */
	public List<List<Integer>> fourSum(int[] array, int target) {
		List<List<Integer>> list = new ArrayList<>();

		int len = array.length;

		if (array == null || len == 0 || len < 4)
			return list;

		Arrays.sort(array);

		for (int i = 0; i < len - 3;) {
			if (i > 0 && array[i] == array[i - 1])
				continue;
			if (array[i] + array[i + 1] + array[i + 2] + array[i + 3] > target)
				break;
			for (int j = i + 1; j < len - 2;) {
				if (array[j] == array[j + 1])
					continue;
				int forwardPtr = j + 1;
				int backwardPtr = len - 1;

				while (forwardPtr < backwardPtr) {
					int sum = array[i] + array[j] + array[forwardPtr] + array[backwardPtr];
					if (sum == target) {
						list.add(Arrays.asList(array[i], array[j], array[forwardPtr], array[backwardPtr]));
						while (++forwardPtr < backwardPtr && array[forwardPtr] == array[forwardPtr - 1])
							; // skip same c
						while (--backwardPtr > forwardPtr && array[backwardPtr] == array[backwardPtr + 1])
							; // skip same d
					} else if (sum > target) {
						while (--backwardPtr > forwardPtr && array[backwardPtr] == array[backwardPtr + 1])
							; // skip bigger element
					} else {
						while (++forwardPtr < backwardPtr && array[forwardPtr] == array[forwardPtr - 1])
							; // move right or bigger element
					}
				}
				// skip the same b
				while (++j < len - 2 && array[j] == array[j - 1])
					;
			}
			// skip the same a
			while (++i < len - 3 && array[i] == array[i - 1])
				;
		}
		return list;
	}

}

public class FourSum {

	public static void main(String[] args) {
		FourSumImpl ts = new FourSumImpl();
		int[] array = { -1, 0, 1, 2, -1, 4 }; 
		List<List<Integer>> lists = ts.fourSum(array, 0);
		for (List<Integer> list : lists) {
			for (int val : list) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}

}
