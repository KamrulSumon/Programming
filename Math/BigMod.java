package com.sumon.math;

/**
 * Calculate BigMod( a^b % m)
 * @author Kamrul Hasan
 *
 */

public class BigMod {
	/* calculate big mod */
	public int bigMod(int a, int b, int m) {
		if (b == 0) {
			return 1;
		}

		if (b % 2 == 1) {
			int part1 = a;
			int part2 = bigMod(a, b - 1, m);
			return (part1 * part2) % m;
		} else {
			int half = bigMod(a, b / 2, m);
			return (half * half) % m;
		}
	}
}
