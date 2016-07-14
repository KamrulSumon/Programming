package com.sumon.leetcode;

/**
 * Add two link lists
 * 
 * @author Kamrul Hasan
 *
 */

/* Node class */
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

/* add two lists */
class AddLinkList {
	/* add two link list v1 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(-1), prev = head;
		int carry = 0;

		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		// add all the elements same length
		while (l1 != null && l2 != null) {
			int sum = l1.val + l2.val + carry;
			ListNode node = new ListNode(sum % 10);
			carry = sum / 10;

			prev.next = node;
			prev = prev.next;

			l1 = l1.next;
			l2 = l2.next;
		}
		// add remaining elements from frist list
		while (l1 != null) {
			int sum = l1.val + carry;
			ListNode node = new ListNode(sum % 10);
			carry = sum / 10;

			prev.next = node;
			prev = prev.next;

			l1 = l1.next;
		}
		// add remaining elements from second list
		while (l2 != null) {
			int sum = l2.val + carry;
			ListNode node = new ListNode(sum % 10);
			carry = sum / 10;

			prev.next = node;
			prev = prev.next;

			l2 = l2.next;
		}
		// add carry
		if (carry > 0) {
			ListNode node = new ListNode(carry);
			prev.next = node;
		}
		ListNode head1 = head.next;
		while (head1 != null) {
			System.out.print(head1.val + "  ");
			head1 = head1.next;
		}

		return head.next;
	}

	/* add two link list v2 */
	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(-1), prev = head;
		int carry = 0;

		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		while (l1 != null || l2 != null) {
			int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
			ListNode node = new ListNode(sum % 10);
			carry = sum / 10;

			prev.next = node;
			prev = prev.next;

			l1 = (l1 == null ? null : l1.next);
			l2 = (l2 == null ? null : l2.next);
		}

		if (carry > 0) {
			ListNode node = new ListNode(carry);
			prev.next = node;
		}
		ListNode head1 = head.next;
		while (head1 != null) {
			System.out.print(head1.val + "  ");
			head1 = head1.next;
		}

		return head.next;
	}

}

/* driver class */
public class AddTwoLinkList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode head2 = new ListNode(8);
		ListNode head3 = new ListNode(3);
		head.next = head2;
		// head2.next = head3;

		ListNode head4 = new ListNode(0);
		ListNode head5 = new ListNode(6);
		ListNode head6 = new ListNode(4);
		// head4.next = head5;
		// head5.next = head6;

		AddLinkList s = new AddLinkList();
		s.addTwoNumbers2(head, head4);

	}

}
