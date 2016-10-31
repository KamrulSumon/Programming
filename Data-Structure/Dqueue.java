/**
 * Double Ended Queue implementation in Java
 */

package com.sumon.prog.ds;

import java.util.ArrayList;
import java.util.List;

interface Queue<T> {
	void insertFront(T item);  //insert front of queue
	void insertRear(T item);   //insert back of queue
	T removeFront();    //remove front element and return the element
	T removeRear();     //remove rear element and return the element
	T peekFront(); // returns the front element from the queue without removing
	T peekRear(); // returns the rear element from the queue without removing
	int size(); // return the number of items in Queue
	boolean isEmpty(); // check whether queue is empty or not
	boolean isFull(); // check queue is full
}

/* Circular queue */
public class Dqueue<T> implements Queue<T> {

	private static final int DEFAULT_SIZE = 5;
	private List<T> deque = null;
	private int size; // size of the circular queue
	private int front; // front to remoe element
	private int rear; // rear to insert element
	private int count; // number of elements in the queue

	public Dqueue() {
		deque = new ArrayList<T>();
		front = 0;
		rear = 0;
		count = 0;
	}

	@Override
	public void insertFront(T item) {
		deque.add(0, item);
		count++;
	}

	@Override
	public void insertRear(T item) {
		deque.add(item);
		count++;
	}

	@Override
	public T removeFront() {
		if (deque.isEmpty()) {
			System.out.println("Deque underflow!! unable to remove.");
			return null;
		}
		T item = deque.remove(0);
		return item;
	}

	@Override
	public T removeRear() {
		if (deque.isEmpty()) {
			System.out.println("Deque underflow!! unable to remove.");
			return null;
		}
		T item = deque.remove(deque.size()-1);
		return item;
	}

	@Override
	public T peekFront() {
		return deque.get(0);
	}

	@Override
	public T peekRear() {
		return deque.remove(deque.size()-1);
	}
	
	@Override
	public int size() {
		return count;
	}

	@Override
	public boolean isEmpty() {
		return count == 0 ? true : false;
	}

	@Override
	public boolean isFull() {
		return count == size ? true : false;
	}
}


/* driver class */
class DqueueTest {

	public static void main(String[] args) {
		Dqueue<Integer> dqueue = new Dqueue<Integer>();
		dqueue.insertFront(34);
		dqueue.insertRear(45);
		System.out.println(dqueue.removeFront());
		System.out.println(dqueue.removeFront());
		System.out.println(dqueue.size());
		dqueue.insertFront(21);
		System.out.println(dqueue.removeRear());
		dqueue.insertFront(98);
		dqueue.insertRear(5);
		dqueue.insertFront(43);
		System.out.println(dqueue.removeRear());
		System.out.println(dqueue.removeFront());
		System.out.println(dqueue.peekFront());
		System.out.println(dqueue.peekRear());
	}
}

