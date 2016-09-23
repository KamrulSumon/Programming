/**
 * Given a list of integers, can you count and output the number of times each value appears?
 * @author Kamrul Hasan
 * @Ref HackerRank counting sort 1, Category: Algorithm
 */
package com.sumon.sort;

import java.util.HashMap;
import java.util.Scanner;

public class CountingSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N;
		int num;
		HashMap<Integer, Integer> map = new HashMap<>();

		N = sc.nextInt();

		for (int i = 1; i <= N; i++) {
			num = sc.nextInt();
			if (!map.containsKey(num)) {
				map.put(num, 0);
			}
			map.put(num, map.get(num) + 1);
		}

		for (int i = 0; i <= 99; i++) {
			if (!map.containsKey(i)) {
				System.out.print(0);
			} else {
				System.out.print(map.get(i));
			}
			System.out.print(" ");
		}

	}

}
