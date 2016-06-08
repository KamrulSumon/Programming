package com.sumon.search;

/**
 * Implementation of spare search
 * 
 * @author Kamrul Hasan
 * @source Cracking the coding interview 10.5
 */
class SparseSearchImpl {

	/* Find a given string from an sparse array of string */
	public int sparseSearch(String[] strings, String searchItem) {
		int mid;
		int low = 0;
		int high = strings.length - 1;

		// modified binary search
		while (low <= high) {
			mid = (low + high) / 2;
			String middle = strings[mid];

			if (middle.isEmpty()) {
				String leftString = getLeftString(strings, mid);
				if (searchItem.compareTo(leftString) > 0) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}

			} else if (searchItem.compareTo(middle) > 0) {
				high = mid - 1;
			} else if (searchItem.compareTo(middle) < 0) {
				low = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	/* Get the left string from the middle */
	public String getLeftString(String[] strings, int mid) {
		for (; mid >= 0; mid--) {
			if (strings[mid].isEmpty()) {
				continue;
			} else {
				return strings[mid];
			}
		}
		return null;
	}
}

/**
 * Testing of the sparse array
 * 
 * @author Kamrul Hasan
 *
 */
public class SparseSearch {

	public static void main(String[] args) {
		SparseSearchImpl ss = new SparseSearchImpl();
		String[] strings = { "at", "", "", "", "ball", "", "", "cat", "", "", "dad", "", "" };
		System.out.println(ss.sparseSearch(strings, "ball"));
		System.out.println(ss.sparseSearch(strings, "at"));
		System.out.println(ss.sparseSearch(strings, "dad"));
	}
}
