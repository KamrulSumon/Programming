package com.sumon.dp;

/**
 * Implementation of Fibonacci number using Top Down approach
 * @author Kamrul Hasan
 *
 */
class FibonacciTopDownApproachImpl{
	
	/* generate nth fibonacci using dynamic programming */
	public int fibonacci(int n, int[] memo){
		if(n == 0 || n == 1) return n;
		
		if(memo[n] == 0){
			memo[n] = fibonacci(n-1, memo) + fibonacci(n-2, memo);
		}
		
		return memo[n];   // return the stored result
	}
}

/* Testing */
public class FibonacciTopDownApproach {

	public static void main(String[] args) {
		FibonacciTopDownApproachImpl ftd = new FibonacciTopDownApproachImpl();
		System.out.println(ftd.fibonacci(20, new int[20+1]));

	}

}
