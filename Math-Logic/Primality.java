package com.sumon.mathlogic;

/**
 * Implementation of primality testing
 * @author Kamrul Hasan
 *
 */
class PrimalityTesting{
	
	/*Naive approach to test whether a given number is prime or not*/
	public boolean primeNaive(int n){
		if((n < 2) || (n % 2 == 0)) {
			return false;
		}
		for(int i = 3; i < n; i++){
			if(n % i == 0){
				return false;
			}
		}
		return true;
	}
	
	/*Efficient way to find prime*/
	public boolean primeEfficientWay(int n){
		if((n < 2) || (n % 2 == 0)) {
			return false;
		}
		int sqrt = (int) Math.sqrt(n);
		for(int i = 3; i <= sqrt; i++){
			if(n%i == 0){
				return false;
			}
		}
		return true;
	}
}

/**
 * Testing of primality
 * @author Kamrul Hasan
 *
 */
public class Primality {

	public static void main(String[] args) {
		PrimalityTesting pt = new PrimalityTesting();
		System.out.println(pt.primeNaive(97));
		System.out.println(pt.primeNaive(100));
		System.out.println(pt.primeEfficientWay(97));
		System.out.println(pt.primeEfficientWay(100));
	}

}
