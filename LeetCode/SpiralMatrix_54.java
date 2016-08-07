package com.sumon.leetcode;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * @Kamrul Hasan
 * @Leet Code #54
 */

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public List<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> spiral = new ArrayList<>();

		if (matrix == null || matrix.length == 0)
			return spiral;

		int r = 0;
		int c = 0;

		int rEnd = matrix.length - 1;
		int cEnd = matrix[0].length - 1;

		while (r <= rEnd && c <= cEnd) {

			// left -> right
			for (int i = c; i <= cEnd; i++) {
				spiral.add(matrix[r][i]);
			}
			r++;
			if (r > rEnd || c > cEnd)
				break;

			// top -> bottom
			for (int i = r; i <= rEnd; i++) {
				spiral.add(matrix[i][cEnd]);
			}
			cEnd--;
			if (r > rEnd || c > cEnd)
				break;

			// right -> left
			for (int i = cEnd; i >= c; i--) {
				spiral.add(matrix[rEnd][i]);
			}
			rEnd--;
			if (r > rEnd || c > cEnd)
				break;

			// bottom -> up
			for (int i = rEnd; i >= r; i--) {
				spiral.add(matrix[i][c]);
			}
			c++;
			if (r > rEnd || c > cEnd)
				break;
		}
		return spiral;
	}
}

class SpiralMatrixTest {
	public static void main(String[] args) {
		SpiralMatrix sm = new SpiralMatrix();
		int[][] matrix = {
				// { 1, 2, 3, 4 },
				// { 5, 6, 7, 8 },
				// { 9, 10, 11, 12},
				// {13, 14, 15, 16}
				{} };

		sm.spiralOrder(matrix);
	}
}
