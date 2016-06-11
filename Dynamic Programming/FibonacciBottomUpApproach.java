package com.sumon.dp;

/**
 * Implementation of fibonacci number using bottom up approach
 * @author Kamrul Hasan
 *
 */
class FibonacciBottomUpApproachImpl{
	
	/* generate nth fibonacci number uisng bottom up approach with array*/
	public int fibonacci(int n){
		if(n == 0 || n == 1) return 1;
	
		int[] memo = new int[n+1];
		memo[0] = 0;
		memo[1] = 1;
		
		for(int i = 2; i <= n; i++){
			memo[i] = memo[i-1] + memo[i-2];
		}
		return memo[n];
	}
	
	/* generate nth fibonacci number uisng bottom up approach with variable*/
	public int fibonacci2(int n){
		if(n == 0 || n == 1) return n;
		
		int a = 0;
		int b = 1;
		
		for(int i = 2; i <= n; i++){
			int sum = a + b;
			a = b;
			b = sum;
		}
		return b;
	}
}

/* Testing */
public class FibonacciBottomUpApproach {

	public static void main(String[] args) {
		FibonacciBottomUpApproachImpl fba = new FibonacciBottomUpApproachImpl();
		System.out.println(fba.fibonacci(40));
		System.out.println(fba.fibonacci2(40));
		}
}
