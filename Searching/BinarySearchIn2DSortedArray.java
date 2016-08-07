package com.sumon.leetcode;

/**
 * Binary Search in 2D maatrix :
 * n * m matrix convert to an array : matrix[x][y] => a[x * m + y]
 * an array convert to n * m matrix : a[x] =>matrix[x / m][x % m];
 * @author Kamrul Hasan
 *
 */
public class BinarySearchIn2DArray {

	public boolean binarySearch(int[][] matrix, int target){
		    int n = matrix.length;
	        int m = matrix[0].length;
	        
	        int left = 0;
	        int right = m * n - 1;
	        
	        while (left != right){
	            int mid = (left + right - 1) >> 1;
	            if (matrix[mid / m][mid % m] < target)
	                left = mid + 1;
	            else 
	                right = mid;
	        }
	        return matrix[right / m][right % m] == target;
	    }
}
