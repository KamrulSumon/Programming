package com.sumon.leetcode;

public class SuperPower {
	int M = 1337;

	public int normalPow(int a, int b) {
		int result = 1;
		while (b != 0) {
			if (b % 2 != 0)
				result = result * a % M;
			a = a * a % M;
			b /= 2;
		}
		return result;
	}

	public int BigMod(int a, int b) {
		if (b == 0) {
			return 1;
		}

		if (b % 2 == 1) {
			int part1 = a;
			int part2 = BigMod(a, b - 1);
			return (part1 * part2) % M;
		} else {
			int half = BigMod(a, b / 2);
			return (half * half) % M;
		}
	}

	public int superPow(int a, int[] b) {

		int result = 1;
		for (int i = 0; i < b.length; i++)
			result = ((BigMod(result, 10)) * (BigMod(a, b[i]))) % 1337;

		return (int) result;
	}
}
