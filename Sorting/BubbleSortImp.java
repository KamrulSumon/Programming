package com.sumon.sorting.bubblesort;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;


class BubbleSort{
	
	public void bubbleSort(List<Integer> items){
		
		int len = items.size();
		out.println("==================== Before Sorting ==========================");
		
		for(Integer item : items){
			out.print(item+"  ");
		}
		
		
		
		for(int i = 0; i < len; i++ ){
			for(int j = 1; j < len - i; j++)
			{
				if(items.get(j-1) > items.get(j)){
					int temp = items.get(j-1);
					items.set(j-1, items.get(j));
					items.set(j, temp);
				}
			}
		}
		
		out.println("\n==================== After Sorting ==========================");
		
		for(Integer item : items){
			out.print(item+"  ");
		}
	}
}





public class BubbleSortImp {

	public static void main(String[] args) {
	
		BubbleSort bSort = new BubbleSort();
		out.println("==================== Bubble Sort ==========================");
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

		bSort.bubbleSort(numbers);
		
	}

}
