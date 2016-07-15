package com.sumon.math;

import java.util.ArrayList;
import java.util.Scanner;

/* each term of equation */
class Term {
	int coef;
	int exp;

	public Term(int c, int e) {
		coef = c;
		exp = e;
	}
}

/* solve polynomial equation */
class Polynomial {
	Scanner sc = new Scanner(System.in);
	ArrayList<Term> poly = new ArrayList<>();
	int[] coef;
	int deg;
	/* read polynomial by term */
	public void readPloynomialByTerm() {
		deg = 4;

		for (int i = 0; i < deg; i++) {
			int coeff = sc.nextInt();
			int e = sc.nextInt();
			poly.add(new Term(coeff, e));
		}
	}
	/* read polynomial by degree */
	public void readPloynomialByDegree() {
		deg = 4;
		coef = new int[deg+1];
		for (int i = 0; i < deg; i++) {
			coef[i] = sc.nextInt();
		}
	}

	/* solve equation by term */
	public double solveByTerm(int x) {
		double sum = 0;
		for (int i = 0; i < deg; i++) {
			Term t = poly.get(i);
			sum = sum + t.coef * Math.pow(x, t.exp);
		}
		return sum;
	}
	
	/* solve by degree */
	public double solveByDegree(int x) {
		double sum = 0;
		for (int i = deg; i >= 0; i--) {
			sum = sum + coef[i] * Math.pow(x, i);
		}
		return sum;
	}
}

