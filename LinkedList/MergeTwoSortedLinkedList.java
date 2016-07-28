package com.sumon.linkedlist;

/* Node of the linked list */
class ListNode{
	private int data;
	private ListNode next;
	
	public ListNode(int data){
		this.data = data;
	}
	
	public int getData(){
		return data;
	}
	
	public void setNextNode(ListNode node){
		this.next = node;
	}
	
	public ListNode getNextNode(){
		return next;
	}
}
/** implement of merge two list */
class MergeLinkedList{
	/* merge two sorted linked lists */
	public ListNode mergeTwoSortedLinkedList(ListNode first, ListNode second){
		ListNode result = null;
		if(first == null && second == null){
			return null;
		}else if(first == null){
			return second;
		}else if(second == null){
			return first;
		}else{
			if(first.getData() <= second.getData()){
				result = first;
				result.setNextNode(mergeTwoSortedLinkedList(first.getNextNode(), second));
			}else{
				result = second;
				result.setNextNode(mergeTwoSortedLinkedList(first, second.getNextNode()));
			}
		}
		return result;
	}
}

public class MergeTwoSortedLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
