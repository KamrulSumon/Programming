package com.sumon.codeforces;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Implementation of Bear and Five Cards
 * @author Kamrul Hasan
 * @Source Codeforces Programming contest Round#356 A
 */
public class BearAndFiveCards {

	public int bearandFiveCards(int[] numbers) {
		int min = 99999999;

		for (int i = 0; i < numbers.length; i++) {
			boolean[] flag = new boolean[numbers.length];
			Arrays.fill(flag, true);

			int counter = 2;
			for (int j = i + 1; j < numbers.length; j++) {
				if ((numbers[i] == numbers[j]) && (counter >= 1 && counter <= 2)) {
					flag[j] = false;
					flag[i] = false;
					counter--;
				}
			}

			int sum = 0;
			for (int k = 0; k < numbers.length; k++) {
				if (flag[k]) {
					sum += numbers[k];
				}
			}

			if (sum < min)
				min = sum;
		}
		return min;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// BearAndFiveCardsImpl bf = new BearAndFiveCardsImpl();
		BearAndFiveCards bf = new BearAndFiveCards();
		int[] num = new int[5];

		for (int i = 0; i < num.length; i++)
			num[i] = sc.nextInt();
		System.out.println(bf.bearandFiveCards(num));
		System.out.flush();

	}

}
