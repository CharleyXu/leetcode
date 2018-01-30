package com.xu.leetcode.Easy;

import org.junit.Test;

/**
 * Palindrome Linked List
 *
 * 思路是逆置后一半，中点用快慢指针的方式寻找，然后比较即可
 */
public class No234 {

	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		if (head.next.next == null) {
			return head.val == head.next.val;
		}
		ListNode slow = head, fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		if (fast.next != null) {
			fast = reverse(slow.next);
		} else {
			fast = reverse(slow);
		}
		slow.next = null;
		slow = head;
		while (fast != null && slow != null) {
			if (slow.val != fast.val) {
				return false;
			}
			fast = fast.next;
			slow = slow.next;
		}
		return true;
	}

	//链表反转
	public ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pre = head;
		ListNode cur = head.next;
		pre.next = null;
		while (cur != null) {
			ListNode tmp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = tmp;
		}
		return pre;
	}

	static class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
		}

		@Override
		public String toString() {
			return "ListNode{" +
					"val=" + val +
					", next=" + next +
					'}';
		}
	}

	@Test
	public void reverseTest() {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(2);
		ListNode node5 = new ListNode(1);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		ListNode listNode = node1;
		System.out.println(listNode);
//		System.out.println(reverse(node1));
		System.out.println(isPalindrome(node1));
	}
}
