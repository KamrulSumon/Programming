package com.sumon.sort;

import java.util.ArrayList;
import java.util.Scanner;

public class CountingSort3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int[] ar = new int[100];
		for (int i = 0; i < n; i++) {
			ar[in.nextInt()]++;
			in.next();
		}
		for (int i = 1; i < 100; i++) {
			ar[i] = ar[i - 1] + ar[i];
		}
		for (int i = 0; i < 100; i++) {
			System.out.print(ar[i] + " ");
		}
		
		//Another Solution
		/*
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ar = new int[100];
		for (int i = 0; i < n; i++) {
			ar[in.nextInt()]++;
			in.next();
		}
		int count = 0;
		for (int i = 0; i < ar.length; i++) {
			count += ar[i];
			System.out.print(count + " ");
		}
		in.close();
		 */
	}
}
