package com.sumon.mathlogic;

/**
 * Implementation of Sieve of Eratosthenes
 * @author Kamrul Hasan
 * @Ref  Cracking the coding interview
 */
class SieveOfEratosthenesImpl{
	
	/*Generate the prime number upto a number in an efficient way*/
	public boolean[] sieveOfEratosthenes(int max){
		boolean[] isPrime = new boolean[max + 1];    
		//Initially assume that all numbers are prime other than 0 and 1 
		isPrime[0] = false;
		isPrime[1] = false;
		for(int i = 2; i <= max; i++){
			isPrime[i] = true;
		}
		int prime = 2;
		int sqrt = (int) Math.sqrt(max);
		
		while(prime <= sqrt){
			crossOffRemainingMultiplesOfPrime(isPrime, prime);
			prime = getNextPrime(isPrime, prime);
		}
		return isPrime;
	}
	
	/* Cross off remaining multiples of prime */
	public void crossOffRemainingMultiplesOfPrime(boolean[] isPrime, int prime){
		for(int i = prime * prime; i < isPrime.length; i+=prime){
			isPrime[i] = false;
		}
	}
	
	/* Get next prime */
	public int getNextPrime(boolean[] isPrime, int prime){
		int next = prime + 1;
		while(next < isPrime.length && !isPrime[next]){
			next++;
		}
		return next;
	}
}

/**
 * Testing the Sieve Eratosthenes
 * @author Kamrul Hasan
 *
 */
public class SieveOfEratosthenes {

	public static void main(String[] args) {
		SieveOfEratosthenesImpl se = new SieveOfEratosthenesImpl();
		boolean[] prime = se.sieveOfEratosthenes(1000000);
		for(int i = 2; i < prime.length; i++){
			if(prime[i])
				System.out.println(i+" ");
		}
	}
}
