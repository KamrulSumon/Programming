package com.sumon.misc.mergesortedarray;

/**
 * Implementation of merging of two sorted array
 * @author Kamrul Hasan
 *
 */
class MergeTwoSortedArrayImpl{
	/**
	 * Merging of two sorted array
	 * @param num1 array of integers
	 * @param num2 array of integers
	 * @param lastNum1 int number of elements in first array
	 * @param lastNum2 int number of elements in second array
	 * @return
	 */
	int[] mergeTwoSortedArrayIntoOne(int[] num1, int[] num2, int lastNum1, int lastNum2){
		int lastIndexOfFirst = lastNum1 - 1;   // Index of last element of first array
		int lastIndexOfSecond = lastNum2 - 1;  // Index of last element of second array
		int mergedIndex = lastNum1 + lastNum2 - 1; // Index of last element of merged array
		
		while( mergedIndex > 0 ){
			if( num1[lastIndexOfFirst] >= num2[lastIndexOfSecond]){
				num1[mergedIndex--] = num1[lastIndexOfFirst--];
			}else{
				num1[mergedIndex--] = num2[lastIndexOfSecond--];
			}
		}
		return num1;
	}
}


/**
 * Testing of Sorted Merge
 * @author Kamrul Hasan
 *
 */
public class MergeTwoSortedArray {

	public static void main(String[] args) {
		MergeTwoSortedArrayImpl mtsa = new MergeTwoSortedArrayImpl();
		
		int[] num1 = new int[11];
		num1[0] = 2;
		num1[1] = 3;
		num1[2] = 7;
		num1[3] = 8;
		num1[4] = 9;
		int[] num2 = new int[]{2,4,5,6,10, 20};
		
		mtsa.mergeTwoSortedArrayIntoOne(num1, num2, 5, num2.length);
		
		for(int i = 0; i < num1.length; i++)
			System.out.println(num1[i]);
	}

}
