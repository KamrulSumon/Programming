package com.sumon.misc;

import java.util.ArrayList;
import java.util.Arrays;

class PairThatMakeKImpl {

	/* find pair that makes K using brute force method */
	public void findPairThatMakeK(ArrayList<Integer> list, int K) {
		int len = list.size();

		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (list.get(i) + list.get(j) == K) {
					System.out.println(list.get(i) + " + " + list.get(j) + " = " + K);
				}
			}
		}
	}

	/* find pair that makes K using sorting */
	public void findPairThatMakeK2(ArrayList<Integer> list, int K) {
		int left = 0;
		int right = list.size() - 1;
		int[] array = list.stream().mapToInt(i -> i).toArray();
		Arrays.sort(array);
		while (left <= right) {
			if ((array[left] + array[right]) == K) {
				System.out.println(array[left] + " + " + array[right] + " = " + K);
				left++;
				right--;
			} else if ((array[left] + array[right]) < K) {
				left++;
			} else {//
				right--;
			}
		}
	}

	/* find pair that makes K using HashMap */
	public void findPairThatMakeK3(ArrayList<Integer> list, int K) {

		boolean seen[] = new boolean[100000];

		for (int i = 0; i < list.size(); i++) {
			int reminder = K - list.get(i);
			if (reminder >= 0 && seen[reminder] == true) {
				System.out.println(list.get(i) + ", " + reminder);
			}
			seen[list.get(i)] = true;
		}
	}

}

/* driver class */
public class PairThatMakeK {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(4, 1, 8, 9, 10));

		PairThatMakeKImpl pk = new PairThatMakeKImpl();
		pk.findPairThatMakeK(list, 12);
		pk.findPairThatMakeK2(list, 12);
		pk.findPairThatMakeK3(list, 12);

	}

}
