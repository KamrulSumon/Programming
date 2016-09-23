/**
 * 
 * 
 */

package com.sumon.sort;

import java.io.*;
import java.util.*;

public class CountingSort2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N;
		int num;
		ArrayList<Integer> list = new ArrayList<>();

		N = sc.nextInt();

		for (int i = 1; i <= N; i++) {
			num = sc.nextInt();
			list.add(num);
		}

		Collections.sort(list);

		for (int i : list) {
			System.out.print(i + " ");
		}
		
		// Another solution
		/* 
		int n = in.nextInt();
		int[] ar = new int[100];
		for (int i = 0; i < n; i++) {
			ar[in.nextInt()]++;
		}
		for(int i = 0; i <ar.length ;i++){
			while(ar[i] > 0){
				System.out.print(i + " ");
				ar[i]--;
			}
		}
		 */
	}
}