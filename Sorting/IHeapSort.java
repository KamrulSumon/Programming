package com.sumon.heapsort;

public interface IHeapSort {
	void extract_max(int last);
	void max_heapify(int i);
	void build_max_heap();
	void pirnt_array();
}
