package com.sumon.binarysearch;

/**
 * Implementation of binary search 
 * 
 * @author Kamrul Hasan
 *
 */
class BinarySearchImpl{
	/**
	 * Find the element in a sorted array
	 * @return int value if element is found otherwise -1
	 */
	public int binarySearch(int[] numbers, int x){
		
		int low = 0;
		int high = numbers.length - 1;
		int mid;
		
		while( low <= high ){
			mid = (low + high) / 2;
			if( x == numbers[mid] ) return mid;   //Found
			else if( numbers[mid] > x ) high = mid -1;
			else if( numbers[mid] < x ) low = mid + 1;
		}
		return -1;  // Element not found
	}
}





/**
 * Testing of Binary search
 * 
 * @author Kamrul Hasan
 *
 */

public class BinarySearch {

	public static void main(String[] args) {
		BinarySearchImpl bs = new BinarySearchImpl();
		int[] numbers = new int[]{1,8,9,10,20,30,50,100};
		System.out.println( bs.binarySearch(numbers, 100) );
	}

}
