package com.sumon.leetcode;

/**
 * Count the number of prime numbers less than a non-negative number, n.
 * @LeetCode #204
 */

public class CountPrimes {

  public int countPrimes(int max) {

    if (max <= 2) {
      return 0;
    }
    int numPrime = 0;
    boolean[] isPrime = new boolean[max + 1];
    //Initially assume that all numbers are prime other than 0 and 1
    isPrime[0] = false;
    isPrime[1] = false;
    for (int i = 2; i <= max; i++) {
      isPrime[i] = true;
    }
    int prime = 2;
    int sqrt = (int) Math.sqrt(max);

    while (prime <= sqrt) {
      crossOffRemainingMultiplesOfPrime(isPrime, prime);
      prime = getNextPrime(isPrime, prime);
    }

    for (int i = 0; i < isPrime.length; i++) {
      if (isPrime[i] && i < max) {
        numPrime++;
      }
    }

    return numPrime;
  }

  /* Cross off remaining multiples of prime */
  public void crossOffRemainingMultiplesOfPrime(boolean[] isPrime, int prime) {
    for (int i = prime * prime; i < isPrime.length; i += prime) {
      isPrime[i] = false;
    }
  }

  /* Get next prime */
  public int getNextPrime(boolean[] isPrime, int prime) {
    int next = prime + 1;
    while (next < isPrime.length && !isPrime[next]) {
      next++;
    }
    return next;
  }

  public static void main(String[] args) {
    CountPrimes cp = new CountPrimes();
    cp.countPrimes(499979);
  }

}
