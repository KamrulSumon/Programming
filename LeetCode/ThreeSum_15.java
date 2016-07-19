package com.sumon.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* Triple not needed */
class Triple {
	int a;
	int b;
	int c;

	public Triple(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public int hashCode() {
		return a * 100 + b * 89 + c * 37;
	}

	public boolean equals(Object obj) {
		Triple t = (Triple) obj;
		return this.hashCode() == t.hashCode();
	}
}

class ThreeSumImpl {
	/* with duplicate, O(N^2 logN) */
	public List<ArrayList<Integer>> threeSum(int[] array) {
		List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		int len = array.length;
		int forwardPtr, backwardPtr;
		if (array == null || len == 0 || len < 3)
			return list;

		Arrays.sort(array);

		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				forwardPtr = 0;
				backwardPtr = len - 1;
				while (backwardPtr > forwardPtr) {
					int mid = (backwardPtr + forwardPtr) / 2;
					if (mid != i && mid != j && array[i] + array[j] + array[mid] == 0) {
						ArrayList<Integer> newList = new ArrayList<>(Arrays.asList(array[i], array[j], array[mid]));
						list.add(newList);
						break;
					} else if (mid != i && mid != j && array[i] + array[j] + array[mid] > 0) {
						backwardPtr--;
					} else {
						forwardPtr++;
					}
				}

			}
		}
		return list;
	}
	/* without duplicate O(N^2)*/
	public List<List<Integer>> threeSum2(int[] array) {
		List<List<Integer>> list = new ArrayList<>();
		int len = array.length;

		if (array == null || len == 0 || len < 3)
			return list;
		
		Arrays.sort(array);

		for (int i = 0; i < len - 2; i++) {
			if (i > 0 && array[i] == array[i - 1])
				continue; // skip same a
			int forwardPtr = i + 1;
			int backwardPtr = len - 1;

			while (forwardPtr < backwardPtr) {
				if (array[i] + array[forwardPtr] + array[backwardPtr] == 0) {
					list.add(Arrays.asList(array[i], array[forwardPtr], array[backwardPtr]));
					while (++forwardPtr < backwardPtr && array[forwardPtr] == array[forwardPtr - 1])
						; // skip same b
					while (--backwardPtr > forwardPtr && array[backwardPtr] == array[backwardPtr + 1])
						; // skip same c
				} else if (array[i] + array[forwardPtr] + array[backwardPtr] > 0) {
					while (--backwardPtr > forwardPtr && array[backwardPtr] == array[backwardPtr + 1])
						; // skip bigger element
				} else {
					while (++forwardPtr < backwardPtr && array[forwardPtr] == array[forwardPtr - 1])
						; // move right for bigger element
				}
			}
		}
		return list;
	}

}

public class ThreeSum {

	public static void main(String[] args) {
		ThreeSumImpl ts = new ThreeSumImpl();
		int[] array = { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> lists = ts.threeSum2(array);
		for (List<Integer> list : lists) {
			for (int val : list) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}

}
