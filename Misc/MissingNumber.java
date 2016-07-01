package com.sumon.misc;
/**
 * Find the missing number from 1 to n.
 * @author Kamrul Hasan
 */
class MissingNumberImpl{
	
	/* find the missing number */
	int findMissingNumber(int[] array, int n){
		int total = n * (n + 1) / 2;
		
		for(int i = 0; i < array.length; i++){
			total -= array[i];
		}
		return total;
	}
	/* find missing number using XOR */
	int findMissingNumberXOR(int[] array, int n){
		
		int x1 = array[0];
		int x2 = 1;
		
		for(int i = 1; i < array.length; i++){
			x1 ^= array[i];
		}
		
		for(int i = 2; i <= n; i++){
			x2 ^= i;
		}
		return x1 ^ x2;
	}
}

/* driver class */
public class MissingNumber {

	public static void main(String[] args) {
		MissingNumberImpl mn = new MissingNumberImpl();
		int[] array = {1,3,4,5};
		System.out.println(mn.findMissingNumber(array, 5));
		System.out.println(mn.findMissingNumberXOR(array, 5));
	}

}
