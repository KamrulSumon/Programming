package com.sumon.search.binarysearch;

/**
 * Implementation of Binary Search using Recursion
 * @author Kamrul Hasan
 *
 */
class BinarySearchRecursiveImpl{
	/**
	 * Find the item in a sorted array
	 * @param numbers array of integers 
	 * @param item  searching item
	 * @param low  min index of the array
	 * @param high max index of the array
	 * @return index if found otherwise -1
	 */
	public int binarySearchRecursive(int[] numbers, int item, int low, int high){
		if( low > high ) return -1; // Not found
		int mid = (low+high) / 2;
		if( numbers[mid] < item ) {
			return binarySearchRecursive(numbers, item, mid+1, high);
		}else if( numbers[mid] > item ){
			return binarySearchRecursive(numbers, item, low, mid-1 );
		}else{
			return mid;
		}
	}
}

/**
 * Testing of binary search using recursion
 * @author sumon
 *
 */
public class BinarySearchRecursive {

	public static void main(String[] args) {
		BinarySearchRecursiveImpl bsr = new BinarySearchRecursiveImpl();
		int[] numbers = new int[]{1,8,9,10,20,30,50,100};
		System.out.println( bsr.binarySearchRecursive(numbers, 100, 0, numbers.length-1 ) );
	}

}
