package com.sumon.datastructure;

import java.util.Comparator;
import java.util.PriorityQueue;

/* Implement min Priority Queue */
class MinPriorityQueue {

	PriorityQueue<Integer> pq; // hold the elements

	public MinPriorityQueue() {
		pq = new PriorityQueue<>();
	}

	/* insert item into priorityqueue */
	public void insert(int item) {
		pq.offer(item);
	}

	/* return top element from priority queue */
	public int peek() {
		return pq.peek();
	}

	/* remove the top element from priority queue and return it */
	public int extractMin() {
		return pq.poll();
	}

	/* return the size of priority queue */
	public int getSize() {
		return pq.size();
	}

	/* display elements in priority queue */
	public void display() {
		System.out.println(pq);
	}
}

/* Implement max Priority Queue */
class MaxPriorityQueue {

	PriorityQueue<Integer> pq; // hold the elements

	public MaxPriorityQueue() {
		pq = new PriorityQueue<>(20, new Comparator<Integer>() {

			@Override
			public int compare(Integer obj1, Integer obj2) {
				return obj2 - obj1;
			}
		});
	}

	/* insert item into priorityqueue */
	public void insert(int item) {
		pq.offer(item);
	}

	/* return top max element from priority queue without removing it */
	public int peek() {
		return pq.peek();
	}

	/* remove the top element from priority queue and return it */
	public int extractMax() {
		return pq.poll();
	}

	/* return the size of priority queue */
	public int getSize() {
		return pq.size();
	}

	/* display elements in priority queue */
	public void display() {
		System.out.println(pq);
	}
}

public class MaxMinPriorityQueueInJava {

	public static void main(String[] args) {
		MaxPriorityQueue maxpq = new MaxPriorityQueue();
		MinPriorityQueue minpq = new MinPriorityQueue();

		int[] items = { 4, 7, 9, 1, 5, 10, 56, 20, 11 };
		for (int i = 0; i < items.length; i++) {
			maxpq.insert(items[i]);
			minpq.insert(items[i]);
		}
		maxpq.display();
		System.out.println("Max element in priority queue: " + maxpq.extractMax());
		System.out.println("Max element in priority queue: " + maxpq.extractMax());
		maxpq.display();
		System.out.println("-------------------------------");
		minpq.display();
		System.out.println("Min element in priority queue: " + minpq.extractMin());
		System.out.println("Min element in priority queue: " + minpq.extractMin());
		minpq.display();
	}

}
