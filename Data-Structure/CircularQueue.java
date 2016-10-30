/**
 * Circular Queue implementation in Java
 */

package com.sumon.prog.ds;

interface Queue<T> {
	void enqueue(T item) throws QueueFullException; // Add item to the rear of the queue
	T dequeue() throws QueueEmptyException; // Returns the front element from queue and remove it
	T peek(); // Returns the front element from the queue without removing
	int size(); // Return the number of items in Queue
	boolean isEmpty(); // Check whether queue is empty or not
	boolean isFull(); // Check queue is full
}

/* Circular queue */
public class CircularQueue<T> implements Queue<T> {

	private static final int DEFAULT_SIZE = 5;
	T[] array = null;
	private int size; // size of the circular queue
	private int front; // front to remoe element
	private int rear; // rear to insert element
	private int count; // number of elements in the queue

	public CircularQueue() {
		this(DEFAULT_SIZE);
	}

	public CircularQueue(int sz) {
		array = (T[]) new Object[sz];
		size = sz;
		front = 0;
		rear = 0;
		count = 0;
	}

	@Override
	public void enqueue(T item) throws QueueFullException {
		if (isFull()) {
			throw new QueueFullException("Queue full Exception");
		} else {
			array[rear] = item;
			rear = (rear + 1) % size;
			count++;
		}
	}

	@Override
	public T dequeue() throws QueueEmptyException {
		T item;
		if (isEmpty()) {
			throw new QueueEmptyException("Queue is Empty");
		} else {
			item = array[front];
			array[front] = null;
			front = (front + 1) % size;
			count--;
		}
		return item;
	}

	@Override
	public T peek() {
		return array[front];
	}

	@Override
	public int size() {
		// if(rear > front) return rear-front;
		// return size - front + rear;
		return count;
	}

	@Override
	public boolean isEmpty() {
		// return front == rear ? true : false;
		return count == 0 ? true : false;
	}

	@Override
	public boolean isFull() {
		// int diff = rear - front;
		// return (diff == -1 || diff == size) ? true : false;
		return count == size ? true : false;
	}
}

/* Queue Full Exception */
class QueueFullException extends RuntimeException {

	public QueueFullException() {
		super();
	}

	public QueueFullException(String message) {
		super(message);
	}

	public QueueFullException(String message, Throwable cause) {
		super(message, cause);
	}
}

/* Queue Empty Exception */
class QueueEmptyException extends RuntimeException {

	public QueueEmptyException() {
		super();
	}

	public QueueEmptyException(String message) {
		super(message);
	}

	public QueueEmptyException(String message, Throwable cause) {
		super(message, cause);
	}
}

/* driver class */
class CircularQueueTest {

	public static void main(String[] args) {
		CircularQueue<Integer> cqueue = new CircularQueue<>();
		cqueue.enqueue(5);
		cqueue.enqueue(56);
		cqueue.enqueue(25);
		cqueue.enqueue(65);
		cqueue.enqueue(75);
		System.out.println(cqueue.dequeue());
		System.out.println(cqueue.size());
		cqueue.enqueue(75);
		System.out.println(cqueue.size());
	}
}
