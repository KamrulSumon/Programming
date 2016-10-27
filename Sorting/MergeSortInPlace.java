package com.sumon.prog.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSortInPlace {

	public static List<Integer> mergeTwoSortedArrasys(ArrayList<Integer> A, int lenA, ArrayList<Integer> B, int lenB) {
		int idxA = lenA - 1;
		int idxB = lenB - 1;
		int writeIdx = idxA + idxB;

		while (idxA >= 0 && idxB >= 0) {
			A.set(writeIdx--, A.get(idxA) > B.get(idxB) ? A.get(idxA--) : B.get(idxB--));
		}

		while (idxB >= 0) {
			A.set(writeIdx--, B.get(idxB--));
		}

		return A;
	}
}

class MergeSortInPlaceTest {

	public static void main(String[] args) {

		ArrayList<Integer> listA = new ArrayList<Integer>(11);
		listA.addAll(Arrays.asList(1, 2, 6, 8, 10, null, null, null, null, null, null));
		ArrayList<Integer> listB = new ArrayList<Integer>(Arrays.asList(1, 12, 18, 28, 38));
		MergeSortInPlace is = new MergeSortInPlace();
		System.out.println(is.mergeTwoSortedArrasys(listA, 5, listB, 5));
	}
}
