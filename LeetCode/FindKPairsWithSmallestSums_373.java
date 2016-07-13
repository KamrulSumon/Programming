package com.sumon.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
	/* find the K smallest pairs */
	public List<int[]> kSmallestPairs(int[] num1, int[] num2, int k) {
		List<int[]> result = new ArrayList<>();

		if ((num1 == null || num1.length == 0) || (num2 == null || num2.length == 0) || k <= 0)
			return result;
		Queue<Triple> pq = new PriorityQueue<>();
		// add all smallest value first
		for (int i = 0; i < Math.min(num1.length, k); i++) {
			int row = i;
			int col = 0;
			int val = num1[row] + num2[col];
			pq.offer(new Triple(val, row, col));
		}
		// add subsequent value to priority queue
		for (int i = 0; i < Math.min(num1.length * num2.length, k); i++) {
			Triple triple = pq.poll();
			int row = triple.i;
			int col = triple.j;
			int[] pair = { num1[row], num2[col] };
			if (col < num2.length - 1) {
				int val = num1[row] + num2[col + 1];
				pq.offer(new Triple(val, row, col + 1));
			}
			result.add(pair);
		}
		return result;
	}
}

/* class triple that hold (value, row, col) */
class Triple implements Comparable<Triple> {
	int val;
	int i;
	int j;

	public Triple(int val, int i, int j) {
		this.val = val;
		this.i = i;
		this.j = j;
	}

	public int compareTo(Triple o2) {
		return this.val - o2.val;
	}
}
