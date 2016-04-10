package com.sumon.datastructure.queue;

import java.util.NoSuchElementException;

interface Queue<T> {
	void enqueue(T item);	//Add item to the rear of the queue
	T dequeue();			// Returns the front element from queue and remove it 
	T peek();				// Returns the front element from the queue without removing
	int size();				// Return the number of items in Queue 
	boolean isEmpty();		//Check whether queue is empty or not
}


class QueueImp<T> implements Queue<T>{

	private T[] array;
	private int size;
	private int front;
	private int rear;
	
	// default size of queue
	public QueueImp() {
		array = (T[]) new Object[50];
		size = 0;
		front = 0;
		rear = 0;
	}
	
	// 
	public QueueImp(int capacity) {
		array = (T[]) new Object[capacity];
		size = 0;
		front = 0;
		rear = 0;
	}
	
	@Override
	public void enqueue(T item) {
		if(size == array.length){
			throw new IllegalStateException("Cannot add to full queue");
		}
		
		array[ rear ] = item;
		rear = (rear + 1) % array.length;
		size++;
	}

	@Override
	public T dequeue() {
		if(isEmpty()){
			throw new NoSuchElementException("Cannot remove from empty queue");
		}
		
		T element = array[front];
		array[front] = null;
		front = (front + 1) % array.length;
		size--;
		return element;
	}

	@Override
	public T peek() {
		if(isEmpty()){
			throw new NoSuchElementException("Cannot remove from empty queue");
		}
		
		return array[size -1];
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

public class QueueImpTest {

	public static void main(String[] args) {
		Queue<String> queue = new QueueImp<>(5);
		queue.enqueue("A");
		queue.enqueue("B");
		queue.enqueue("C");
		queue.enqueue("D");
		queue.enqueue("E");
		System.out.println("Dequeue: "+queue.dequeue());
		System.out.println("Dequeue: "+queue.dequeue());
		System.out.println("Dequeue: "+queue.dequeue());
		System.out.println("Dequeue: "+queue.dequeue());
		System.out.println("Dequeue: "+queue.dequeue());
		//System.out.println("Dequeue: "+queue.dequeue());
	}

}
