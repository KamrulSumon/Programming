package com.rat.attack;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Point {
	int x;
	int y;
	int size;
}

class RatAttack {

	Scanner sc = new Scanner(System.in);
	List<Point> ratPopulatin; // = new ArrayList<Integer>();
	Point point;
	int d, ratPopSize;

	public void findOptimalSolution() {
		int kill[][] = new int[1025][1025];
		int i, j, row, col, k, xx=0, yy=0,  maxKill=0;
		row = col = 2 * d + 1;

		for (k = 0; k < ratPopSize; k++) {

			for (i = ratPopulatin.get(k).x - d; i < ratPopulatin.get(k).x - d + row; i++) {
				for (j = ratPopulatin.get(k).y - d; j < ratPopulatin.get(k).y - d + col; j++) {
						
					if( ((i >=0 && i <= 1024) && (j >= 0  && j <= 1024)) && (Math.abs(i - ratPopulatin.get(k).x ) <= d) && (Math.abs(i - ratPopulatin.get(k).x ) <= d)){
						kill[i][j] +=  ratPopulatin.get(k).size;
						
						if( kill[i][j] > maxKill ){
							xx = i;
							yy = j;
							maxKill = kill[i][j];
						}
					}
				}
			}
		}
		
		out.println(xx+ " "+yy+" "+maxKill);

	}

	public void readInput() {
		// findOptimalSolution();
		int testCase, i, j, x, y, ratPop;

		//out.print("Enter Test Case:");
		testCase = sc.nextInt();

		while (testCase-- > 0) {

			//out.print("Enter  d:");
			d = sc.nextInt();

			//out.print("Enter Rat Population Size:");
			ratPopSize = sc.nextInt();

			ratPopulatin = new ArrayList<Point>(ratPopSize);

			for (i = 1; i <= ratPopSize; i++) {
				point = new Point();

				point.x = sc.nextInt();
				point.y = sc.nextInt();
				point.size = sc.nextInt();

				ratPopulatin.add(point);

			}

			findOptimalSolution();
		}

	} // readInput()

}

public class Solution {

	public static void main(String[] args) {
		RatAttack rat = new RatAttack();
		rat.readInput();
	}

}
