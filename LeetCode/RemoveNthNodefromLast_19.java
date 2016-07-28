package com.sumon.leetcode;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * @author Kamrul Hasan
 * @source leetcode #19
 *
 */

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class RemoveNthNodefromLast {

	public ListNode removeNthFromEnd(ListNode head, int n) {

		ListNode start = new ListNode(0);
		ListNode slow = start, runner = start;
		start.next = head;

		// Move fast in front so that the gap between slow and fast becomes n
		for (int i = 1; i <= n + 1; i++) {
			runner = runner.next;
		}
		// Move fast to the end, maintaining the gap
		while (runner != null) {
			slow = slow.next;
			runner = runner.next;
		}
		// Skip the desired node
		slow.next = slow.next.next;
		return start.next;
	}

}
