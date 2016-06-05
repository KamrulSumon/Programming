package com.sumon.sorting;

class QSortImpl {

	public void quickSort(int[] numbers, int left, int right) {
		int index = partition(numbers, left, right);

		if (left < index - 1) { // Sort left half
			quickSort(numbers, left, index - 1);
		}

		if (index < right) {
			quickSort(numbers, index, right);
		}
	}

	public int partition(int[] numbers, int left, int right) {
		int pivot = numbers[(left + right) / 2]; // Pick pivot element
		while (left <= right) {
			// Find element on the left that should be on right
			while (numbers[left] < pivot)
				left++;

			// Find element on right that should be on left
			while (numbers[right] > pivot)
				right--;
			// Swap elements, and move left and right indices
			if (left <= right) {
				swap(numbers, left, right);
				left++;
				right--;
			}
		}		
		return left;
	}

	public void swap(int[] numbers, int left, int right) {
		int temp = numbers[left];
		numbers[left] = numbers[right];
		numbers[right] = temp;
	}
}

public class QSort {

	public static void main(String[] args) {
		QSortImpl qs = new QSortImpl();
		int[] numbers = new int[]{1,9,4,5,2,7,3,6,5};
		qs.quickSort(numbers, 0, numbers.length-1);
		
		for(int i = 0; i < numbers.length; i++ ){
			System.out.print(numbers[i] + "  ");
		}
	}
}
