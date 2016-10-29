package com.sumon.datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Implementation of priority queue(MAX)
 * 
 * @author Kamrul Hasan
 *
 */

/* class Task */
class Task {

	String job;
	int priority;

	public Task(String job, int priority) {
		this.job = job;
		this.priority = priority;
	}

	public String toString() {
		return "Job :" + job + " priority: " + priority;
	}
}

/* Priority queue */
class PriorityQueueImpl {

	private List<Task> tasks; // List of tasks
	int size;

	public PriorityQueueImpl() {
		tasks = new ArrayList<>();
		size = 0;
	}

	/* add task to heap */
	public void insert(String job, int priority) {
		Task newTask = new Task(job, priority);
		tasks.add(size, newTask);
		size++;

		int pos = size - 1; // heapify size -1 element
		heapifyUp(pos);
	}

	/* arrange the task based on priority */
	public void heapifyUp(int n) {
		if (n == 0)
			return;
		Task curr = tasks.get(n);
		Task parent = tasks.get((n - 1) / 2);

		if (curr.priority > parent.priority) {
			tasks.set(n, parent);
			tasks.set((n - 1) / 2, curr);
			heapifyUp((n - 1) / 2);
		}
	}

	/* Remove a task from heap */
	Task remove() {
		if (size == 0)
			throw new NoSuchElementException();
		Task task = tasks.get(0);
		tasks.set(0, tasks.get(size - 1));
		size--;
		heapifyDown(0);
		return task;
	}

	/* arrange the task based on priority */
	public void heapifyDown(int n) {
		if (n >= size)
			return;

		if (2 * n + 2 < size) { // make sure there are 2 * n + 2 tasks exist

			Task curr = tasks.get(n);
			Task left = tasks.get(2 * n + 1);
			Task right = tasks.get(2 * n + 2);

			if (curr.priority < left.priority || curr.priority < right.priority) {
				if (left.priority > right.priority) {
					tasks.set(n, left);
					tasks.set(2 * n + 1, curr);
					heapifyDown(2 * n + 1);
				} else {
					tasks.set(n, right);
					tasks.set(2 * n + 2, curr);
					heapifyDown(2 * n + 2);
				}
			}
		} else if (2 * n + 1 < size) { // make sure there are 2 * n + 1 tasks
										// exist
			Task curr = tasks.get(n);
			Task left = tasks.get(2 * n + 1);
			if (curr.priority < left.priority) {
				tasks.set(n, left);
				tasks.set(2 * n + 1, curr);
			}
		}
	}

	/* print the task in heap */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Task t : tasks) {
			sb.append(t.job + ": " + t.priority + "\n");
		}

		return sb.toString();
	}

	/* print the task based on priority */
	public void printSorted() {
		for (int i = 0; i < tasks.size(); i++) {
			Task task = remove();
			System.out.println(task.job + " : " + task.priority);
		}
	}
}

/* Driver class */
public class PriorityQueue {

	public static void main(String[] args) {
		PriorityQueueImpl pq = new PriorityQueueImpl();
		pq.insert("T1", 3);
		pq.insert("T2", 4);
		pq.insert("T3", 2);
		pq.insert("T4", 1);
		pq.insert("T5", 12);
		pq.insert("T6", 0);

		pq.printSorted();
	}

}
