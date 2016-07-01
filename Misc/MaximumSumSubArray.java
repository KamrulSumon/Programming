package com.sumon.misc;

import java.util.ArrayList;

/**
 * find the maximum sum subarray from a given array
 * @author Kamrul Hasan
 *
 */


/* to keep record at each step */
class Record {
	int leftIndex;
	int rightIndex;
	int sum;
}

class MaximumSumSubArrayImpl {

	/* find the maximum sum subarray using Kadane's algorithm */
	public Record findMaximumSumSubArray(int[] array) {
		ArrayList<Record> results = new ArrayList<Record>();
		Record maxCurrent = new Record();
		maxCurrent.sum = -1 * Integer.MAX_VALUE;
		Record maxSoFar = new Record();
		maxSoFar.sum = -1 * Integer.MAX_VALUE;
		int len = array.length;

		for (int i = 0; i < len; i++) {
			if (maxCurrent.sum < 0) {
				maxCurrent.sum = array[i];
				maxCurrent.leftIndex = i;
				maxCurrent.rightIndex = i;
			} else {
				maxCurrent.sum += array[i];
				maxCurrent.rightIndex = i;
			}

			if (maxCurrent.sum > maxSoFar.sum) {
				maxSoFar = maxCurrent;
			}
			results.add(maxSoFar);
		}
		return results.get(len - 1);
	}
}

/* driver class */
public class MaximumSumSubArray {

	public static void main(String[] args) {
		int[] array = { -1, -2, 3, 4, -5, 6 };
		MaximumSumSubArrayImpl mss = new MaximumSumSubArrayImpl();
		Record r = mss.findMaximumSumSubArray(array);
		System.out.println(r.leftIndex + "-" + r.rightIndex + " --> " + r.sum);

	}

}
