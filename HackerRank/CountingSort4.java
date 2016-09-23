package com.sumon.sort;

import java.util.Scanner;
import java.util.TreeMap;

public class CountingSort4 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		TreeMap<Integer, StringBuilder> map = new TreeMap<>();
		int N;

		N = in.nextInt();

		for (int i = 0; i < N; i++) {
			int num = in.nextInt();
			String str = in.next();

			if (i < N / 2)
				str = "-";

			if (!map.containsKey(num)) {
				map.put(num, new StringBuilder(str));
			} else {
				map.get(num).append(" " + str);
			}
		}

		StringBuilder result = new StringBuilder();
		for (int key : map.keySet()) {
			result.append(map.get(key) + " ");
		}

		System.out.println(result.toString());

		in.close();
	}
}
