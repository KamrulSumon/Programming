package com.sumon.datastructure.stack;

import java.util.NoSuchElementException;

interface Stack<T> {
	
	void push(T item);	//add item to the stack
	T pop();			// Returns the top element from stack and remove it 
	T peek();			// Returns the top element from the stack without removing
	int size();			// Return the number of items in stack 
	boolean isEmpty();		//Check whether stack is empty
}

class StackImp<T> implements Stack<T>{

	private T[] stackArray;			// stack array
	int size;					// counter
	
	// default size of the stack
	public StackImp(){
		stackArray = (T[]) new Object[100];
		size = 0;
	}
	
	//define the stack with specified size
	public StackImp(int N){
		stackArray = (T[]) new Object[N];
		size = 0;
	}
	
	@Override
	public void push(T item) {
		if(size == stackArray.length){
			throw new IllegalStateException("Cannot add to full stack");
		}
		
		stackArray[size++] = item;
	}

	@Override
	public T pop() {
		if(isEmpty()){
			throw new NoSuchElementException("Cannot pop from empty stack");
		}
		
		T result = stackArray[size - 1];
		stackArray[--size] = null;
		return result;
	}

	@Override
	public T peek() {
		if(isEmpty()){
			throw new NoSuchElementException("Cannot pop from empty stack");
		}
		return stackArray[size - 1];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
}


public class StackTest {

	public static void main(String[] args) {
		
		Stack<Integer> stack = new StackImp<>(100);
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		System.out.println("Pop: "+ stack.pop());
		System.out.println("Pop: "+ stack.pop());
		System.out.println("Pop: "+ stack.peek());
		System.out.println("Pop: "+ stack.pop());
		System.out.println("Pop: "+ stack.pop());
		//System.out.println("Pop: "+ stack.pop());
	}

}
