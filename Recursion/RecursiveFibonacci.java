package com.sun.recurive;

class Recurive{
	public long generateFibo(long n){
		
		if( n == 0 || n == 1 ) return n;
		else
			return generateFibo(n-1)+generateFibo(n-2);
	}
}

public class RecursiveFibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Recurive fibo = new Recurive();
		long n = 49;
		System.out.println("Fibonacci upto "+n+ ""+fibo.generateFibo(n));
	}
}
