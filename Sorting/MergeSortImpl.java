package com.sumon.sorting.mergesort;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class MergeSort{
	private static final int INF = Integer.MAX_VALUE;
	
	public void mergeSort(List<Integer> numbers, int left, int right){
		if( left < right ){
			int middle = (left+right)/2;
			mergeSort(numbers, left, middle);
			mergeSort(numbers, middle+1, right);
			merge(numbers, left, middle, right);
		}
	}
	
	public void merge(List<Integer> numbers, int left,int middle, int right){
		
		int leftEnd = middle - left + 1;
		int rightEnd = right - middle;
		int i, j, k;
		
		Integer L[] = new Integer[leftEnd+2];
		Integer R[] = new Integer[rightEnd+2];
		
		for(i = 1; i <= leftEnd; i++){
			L[i] = numbers.get(left+i-1);
		}
		
		for(j = 1; j <= rightEnd; j++){
			R[j] = numbers.get(middle+j);
		}
		
		L[leftEnd+1] = INF;
		R[rightEnd+1] = INF;
		
		i = 1; 
		j = 1;
		
		for( k = left ; k <= right ; k++ ){
			
			if( L[i] <= R[j] ){
				numbers.set(k, L[i]);
				i = i + 1;
			}else{
				numbers.set(k, R[j]);
				j = j + 1;
			}
		}
		
	}
}




public class MergeSortImpl {

	public static void main(String[] args) {
	
		MergeSort mSort = new MergeSort();
		out.println("==================== Merge Sort ==========================");
		List<Integer> numbers = new ArrayList<Integer>();
		
		numbers.add(10);
		numbers.add(100);
		numbers.add(150);
		numbers.add(90);
		numbers.add(110);
		numbers.add(210);
		numbers.add(50);
		numbers.add(20);
		numbers.add(5);

		out.println("==================== Before Sorting ==========================");
		
		for(Integer item : numbers){
			out.print(item+"  ");
		}
		

		mSort.mergeSort(numbers, 0, numbers.size()-1);
		
		out.println("\n==================== After Sorting ==========================");
		
		for(Integer item : numbers){
			out.print(item+"  ");
		}
	}

}
