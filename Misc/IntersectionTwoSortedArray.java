/**
 * Find the intersection between two sorted arrays
 */

package com.sumon.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionTwoSortedArray {

	public static List<Integer> intersectionTwoSortedArrays(List<Integer> A, List<Integer> B) {
		List<Integer> intersection = new ArrayList<>();

		// Check boundary condition
		if (A == null || B == null || A.size() == 0 || B.size() == 0)
			return intersection;

		int i = 0, j = 0;
		int sizeA = A.size();
		int sizeB = B.size();

		while (i < sizeA && j < sizeB) {

			if ((A.get(i) == B.get(j)) && (i == 0 || A.get(i) != A.get(i - 1))) {
				intersection.add(A.get(i));
				i++;
				j++;
			} else if (A.get(i) < B.get(i)) {
				i++;
			} else {
				j++;
			}
		}
		return intersection;
	}
}

class IntersectionTwoSortedArrayTest {

	public static void main(String[] args) {

		ArrayList<Integer> listA = new ArrayList<Integer>(Arrays.asList(1, 2, 8, 6, 8));
		ArrayList<Integer> listB = new ArrayList<Integer>(Arrays.asList(1, 12, 80, 68, 8));
		IntersectionTwoSortedArray is = new IntersectionTwoSortedArray();
		System.out.println(is.intersectionTwoSortedArrays(listA, listB));
	}

}
