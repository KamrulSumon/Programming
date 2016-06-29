package com.sumon.misc;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Find the largest absolute difference in an arrays in O(n)
 * 
 * @author Kamrul Hasan
 *
 */

class AbsoluteDifferenceInArrays {

	private int max;
	private int min;

	/* find the absolute difference */
	public int findAbsoluteDifference(ArrayList<Integer> elements) {
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		int size = elements.size();

		for (int element : elements) {

			if (element > max) { // find the max value
				max = element;
			}

			if (element < min) { // find min value
				min = element;
			}
		}

		return Math.abs(max - min);
	}
}

/* driver class */
public class AbsoluteDifferenceArrays {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1,9,-1,-6, 4));
		AbsoluteDifferenceInArrays ad = new AbsoluteDifferenceInArrays();
		System.out.println(ad.findAbsoluteDifference(list));
	}
}
