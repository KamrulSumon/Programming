package com.sumon.datastructure;

import java.util.Arrays;

/**
 * Implementation of custom array list
 * 
 * @param <T> data type of array list
 *            
 * @author Kamrul Hasan
 */
class CustomArrayList<T> {

	private static final int DEFAULT_INITIAL_CAPACITY = 100; // default capacity
	private static final Object[] DATA_ELEMENT = {};
	private int size; // size of the arrayList

	// array to store data
	private Object[] listData;

	public CustomArrayList(int capacity) {
		if (capacity < 0)
			throw new IllegalArgumentException("Illegal Capacity: " + capacity);
		listData = new Object[capacity];
	}

	public CustomArrayList() {
		listData = new Object[DEFAULT_INITIAL_CAPACITY];
	}

	// add element to the list
	public boolean add(T e) {
		if (size == listData.length) {
			ensureCapacity(); // increase the current size of the array, make it
								// double
		}
		listData[size++] = e;
		return true;
	}

	// get an element from the arrayList
	public T get(int index) {
		if (index < 0 || index >= size)
			throw new ArrayIndexOutOfBoundsException("array index out of bound exception at " + index);
		return (T) listData[index];
	}

	// check arrayList is empty or not
	public boolean isEmpty() {
		return size == 0;
	}

	// number of the elements in arrayList
	public int size() {
		return size;
	}

	/* Double the size of the array */
	private void ensureCapacity() {
		int newCapacity = listData.length * 2;
		listData = Arrays.copyOf(listData, newCapacity);
	}

	/* Display all element in list */
	public void display() {
		for (int i = 0; i < size; i++) {
			System.out.print(listData[i] + " ");
		}
	}

	/* remove element from specified inded and return the element */
	public T remove(int index) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException("array index out of bound exception at " + index);
		}

		T rmElement = (T) listData[index];
		for (int i = index; i < size; i++) {
			listData[i] = listData[i + 1];
		}
		return rmElement;
	}

	/* Clear all the elements from list */
	public void clear() {
		for (int i = 0; i < size; i++) {
			listData[i] = null;
		}
		size = 0;
	}
}

/**
 * Testing of custom array list functionalities
 * 
 * @author Kamrul Hasan
 *
 */
public class CustomArrayListTest {
	public static void main(String[] arg) {
		CustomArrayList<String> list = new CustomArrayList<String>();
		list.add("BD");
		list.add("US");
		list.add("CA");
		list.add("NY");
		list.add("MA");
		list.add("TN");

		list.display();
		System.out.println();
		System.out.println(list.get(3));
		System.out.println(list.remove(1));
		list.display();
	}
}
