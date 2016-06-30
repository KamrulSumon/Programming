package com.sumon.misc;

/**
 * Find the majority element in an array using moore's voting algorithm
 * 
 * @author Kamrul Hasan
 *
 */
class MajorityElementImpl {
	/* find majority element if exist */
	public boolean findMajorityElement(int[] array) {
		int candidate = majorityCandidate(array);

		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == candidate)
				count++;
		}

		return count > array.length / 2;
	}

	/* find major candidate */
	public int majorityCandidate(int[] array) {
		int count = 1;
		int mIndex = 0;

		for (int i = 1; i < array.length; i++) {
			if (array[i] == array[mIndex]) {
				count++;
			} else {
				count--;
			}

			if (count == 0) {
				count = 1;
				mIndex = i;
			}
		}
		return array[mIndex];
	}
}

/* driver class */
public class MajorityElement {

	public static void main(String[] args) {
		int[] array = { 2, 2, 3, 4, 2, 2, 6 };
		MajorityElementImpl me = new MajorityElementImpl();
		System.out.println(me.findMajorityElement(array));
	}
}
