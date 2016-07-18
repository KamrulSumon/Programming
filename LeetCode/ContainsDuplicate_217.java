package com.sumon.leetcode;
/**
 * Find duplicate in an arrays
 * @author Kamrul Hasan
 * @source LeetCode #217
 */

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
	/* find the duplicate in an array */
	public boolean containsDuplicate(int[] nums) {
		Set<Integer> unique = new HashSet<Integer>();
		// HashMap<Integer, Boolean> map = new HashMap<>();
		int len = nums.length;

		for (int val : nums) {
			if (unique.contains(val)) {
				return true;
			}
			unique.add(val);
			// map.put(val, true);
		}
		return false;
	}
}
