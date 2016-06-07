package com.sumon.sorting.problem;

import java.util.ArrayList;

/**
 * Implementation of searching in a sorted array where length is unknown
 * @author Kamrul Hasan
 * @Source  Cracking the coding interview 10.4
 */
class SortedSearchImpl {
	
	/*Find element in a sorted array*/
	public int sortedSearch(ArrayList<Integer> list, int value) {
		int index = 1;

		while (list.get(index) != -1 && list.get(index) < value) {
			index = 2 * index; 
		}

		return binarySearch(list, value, index / 2, index);
	}
	
	/*Binary search to find element*/
	public int binarySearch(ArrayList<Integer> list, int value, int low,
			int high) {
		int mid;

		while (low <= high) {
			mid = (low + high) / 2;
			int middle = list.get(mid);

			if (middle > value || middle == -1) {
				high = mid - 1;
			} else if (middle < value) {
				low = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
}

/**
 * Testing functionalities of sorted array
 * @author Kamrul Hasan
 *
 */
public class SortedSearch {
	public static void main(String[] args) {
		SortedSearchImpl ss = new SortedSearchImpl();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(5);
		list.add(10);
		list.add(15);
		list.add(20);
		list.add(-1);
		list.add(-1);
		list.add(-1);
		System.out.println(ss.sortedSearch(list, 20));
	}
}
