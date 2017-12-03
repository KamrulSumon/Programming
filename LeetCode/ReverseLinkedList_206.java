package com.sumon.leetcode;

/**
 * Reverse a singly linked list.
 * Ref: LeetCode #206
 */

public class ReverseLinkedList {

  public class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }

  }

  public ListNode reverseList(ListNode head) {

    ListNode newHead = null;

    while (head != null) {
      ListNode nxt = head.next;
      ListNode temp = head;
      temp.next = newHead;
      newHead = temp;
      head = nxt;
    }
    return newHead;
  }

}
