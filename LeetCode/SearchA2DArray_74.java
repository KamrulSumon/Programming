package com.sumon.leetcode;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. T
 * his matrix has the following properties: Integers in each row are sorted from
 * left to right. The first integer of each row is greater than the last integer
 * of the previous row.
 * 
 * @author Kamrul Hasan
 * 
 */
public class SearchA2DArray {
	/* search a target value */
	public boolean searchMatrix(int[][] matrix, int target) {
		int len = matrix.length;
		if (len == 0)
			return false;

		int row = len - 1;
		int col = matrix[0].length - 1;

		int rStart = 0;
		int cStart = col;

		while (true) {
			if (matrix[rStart][cStart] == target) // found
				return true;
			if (target < matrix[rStart][cStart]) // search left else go right
				cStart--;
			else
				rStart++;

			if (rStart > row || cStart < 0) // boundary condition
				break;
		}
		return false;
	}
}
