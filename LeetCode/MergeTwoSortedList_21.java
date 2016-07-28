package com.sumon.leetcode;

/**
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists. 
 * @author Kamrul Hasan
 * @source LeetCode #21
 */

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class MergeTwoSortedList {
	/* merge two sorted list */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		if (l1 == null && l2 == null)
			return null;
		ListNode start = null;

		while (l1 != null || l2 != null) {
			ListNode node = null;
			if (l1 != null && l2 != null) {
				if (l1.val < l2.val) {
					node = new ListNode(l1.val);
					start = appendNode(start, node);
					l1 = l1.next;
				} else {
					node = new ListNode(l2.val);
					start = appendNode(start, node);
					l2 = l2.next;
				}
			} else if (l1 == null && l2 != null) {
				node = new ListNode(l2.val);
				start = appendNode(start, node);
				l2 = l2.next;
			} else if (l1 != null && l2 == null) {
				node = new ListNode(l1.val);
				start = appendNode(start, node);
				l1 = l1.next;
			}
		}
		return start;
	}
	  /* appned a node to current List */	
	public ListNode appendNode(ListNode head, ListNode node) {
		if (head == null) {
			head = node;
			return head;
		}
		ListNode root = head;
		while (head.next != null) {
			head = head.next;
		}

		head.next = node;

		return root;
	}
	
	
	/* from LeetCode */
	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
	    ListNode ans = new ListNode(0);
	    ListNode prev = ans;
	    while(l1 != null && l2 != null){
	        if(l1.val > l2.val){
	            prev.next = l2;
	            l2 = l2.next;
	        } else{
	            prev.next = l1;
	            l1 = l1.next;
	        }
	        prev = prev.next;
	    }
	    if(l2 == null){
	        prev.next = l1;
	    } else {
	        prev.next = l2;
	    }
	    return ans.next;
	}
}