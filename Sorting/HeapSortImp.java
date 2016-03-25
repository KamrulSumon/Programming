package com.sumon.heapsort;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class HeapSortImp implements HeapSort {

	PrintWriter out = new PrintWriter(System.out);
	Scanner in = new Scanner(System.in);
	
    String[] al;   // Collection of string
    private int size;  // size of the heap
	private int heapSize;  // heap size
	
	// Initialize the heap 
	public HeapSortImp(){
		
	}

	// extract the max element and exchange with the last element
	//@Override
	public void extract_max(int last) {
		String temp = al[last];
		al[last] = al[1];
		al[1] = temp;
		heapSize = heapSize - 1;
	}

	// heapify or rearrange  the elements in array so that it holds the max  heap property
	//@Override
	public void max_heapify(int i) {
		// TODO Auto-generated method stub
	    int left = getLeftIndex(i);
	    int right = getRightIndex(i);
	    int largest;
	    //int result = al[left].compareTo(al[i]) ;
	    if( left <= heapSize &&  (al[left].compareTo(al[i]) ) > 0 ){
	    	largest = left;
	    }else
	    	largest = i;
	    
	    //result = al[right].compareTo(al[largest]);
	    
	    if( right <= heapSize &&  ( al[right].compareTo(al[largest]) ) > 0){
	    	largest = right;
	    }
	    
	    if(largest != i){
	    	String temp = al[i];
	    	al[i] = al[ largest ];
	    	al[ largest ] = temp;
	    	
	    	max_heapify(largest);
	    }
	
	}
	
	// return the left child index of node i
	public int getLeftIndex(int i){
		return 2*i;
	}
	
	// return the right child index of node i
	public int getRightIndex(int i){
		return 2*i+1;
	}
	
	/// At first build the max heap then sort the heap
	public void heapSort(){
		
		int i;
		// build the max heap
		build_max_heap();
		
		for(i = heapSize; i >= 2; i--){
			extract_max(i);
			max_heapify(1);
		}
	}
	
	
    // build the max heap
	//@Override
	public void build_max_heap() {
		// TODO Auto-generated method stub
		
		int i;
		
		for(i = heapSize/2 ; i >= 1; i-- ){
			max_heapify(i);
		}
	}
	
	// user give the heap inputs
	public void takeUserInput(){
		
		int i;  // counter
		String element;  // hold each element
		
		ArrayList<String> all = new ArrayList<String>();   // Collection of string
				 
		/*// taking user input
		for(i = 1; i <= size; i++){
			element = in.nextLine();
			al[i] = element;			
		}*/
		
		try{
			
			File file = new File("r44_11.txt");
			//File file = new File("text.txt");
			
			
			PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
			System.setOut(out);
			
			Scanner filescanner =  new Scanner(file);
			heapSize = 0;
			all.add("/"); // put / at the 0 index
			while( filescanner.hasNextLine() ){
				all.add(filescanner.nextLine());
				heapSize++;
			}
			
			filescanner.close();
			
			size = heapSize;
			al = new String[heapSize+1];
			
			for(i = 1; i <= heapSize; i++)
				al[i] = all.get(i);
			
			}catch(Exception e){
				System.out.println("File not found"+e);
		}
		
		// calling heapsort
		heapSort();
	}

	// display the sorted heap elements
	//@Override
	public void pirnt_array() {
		int i;
		
		//System.out.println("Sorted array..");
		
		for(i = 1; i <= size; i++)
			System.out.println(al[i]);
	}

}
