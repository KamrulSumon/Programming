package com.sumon.codeforces;

import java.util.Scanner;

/**
 * Implementation of Bear and Finding Criminals.
 * @author Kamrul Hasan
 * @Source Codeforces Programming contest Round#356 B
 */
class BearAndFindingCriminialsImpl {

	public int getNumberOfCriminal(int Ncity, int Plocation, int[] cities) {
		int catchc = cities[Plocation];
		int left = Plocation - 1;
		int right = Plocation + 1;

		for (int i = 1; i <= cities.length; i++) {
			if ((left >= 1 && right < cities.length) && (Math.abs(Plocation - left) == Math.abs(Plocation - right))
					&& ((cities[left] == 0 && cities[right] == 1) || (cities[left] == 1 && cities[right] == 0))) {
				left--;
				right++;
				continue;
			}

			if (left >= 0) {
				catchc += cities[left];
				left--;
			}

			if ((right < cities.length)) {
				catchc += cities[right];
				right++;
			}
		}
		return catchc;
	}
}

public class BearAndFindingCriminials {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BearAndFindingCriminialsImpl bfc = new BearAndFindingCriminialsImpl();
		int Ncity, Plocation;
		int[] cities;

		Ncity = sc.nextInt();
		Plocation = sc.nextInt();
		cities = new int[Ncity + 1];

		for (int i = 1; i <= Ncity; i++) {
			cities[i] = sc.nextInt();
		}

		System.out.println(bfc.getNumberOfCriminal(Ncity, Plocation, cities));
		System.out.flush();
	}
}
