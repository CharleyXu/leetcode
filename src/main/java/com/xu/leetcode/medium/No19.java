package com.xu.leetcode.medium;

import org.junit.Test;

/**
 * @author charlie Created on 2018/2/6.
 *
 * Remove Nth Node From End of List		.从列表末尾开始中删除第N个节点
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 *
 * fast和slow双指针
 */
public class No19 {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || head.next == null) {
			return null;
		}
		ListNode fast = head;
		ListNode slow = head;
		for (int i = 0; i < n; i++) {
			fast = fast.next;
		}
		if (fast == null){
			head = head.next;
			return head;
		}
		while (fast.next != null){
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;

		return head;
	}

	@Test
	public void test() {
		ListNode node7 = new ListNode(7, null);
		ListNode node6 = new ListNode(6, node7);
		ListNode node5 = new ListNode(5, node6);
		ListNode node4 = new ListNode(4, node5);
		ListNode node3 = new ListNode(3, node4);
		ListNode node2 = new ListNode(2, node3);
		ListNode head = new ListNode(1, node2);
		System.out.println(head);
		ListNode listNode = removeNthFromEnd(head, 2);
		System.out.println(listNode);
	}
}


class ListNode {

	public int val;
	public ListNode next;

	public ListNode(int value) {
		this.val = value;
	}

	public ListNode(int value, ListNode next) {
		this.val = value;
		this.next = next;
	}

	public int getValue() {
		return val;
	}

	public ListNode setValue(int value) {
		this.val = value;
		return this;
	}

	public ListNode getNext() {
		return next;
	}

	public ListNode setNext(ListNode next) {
		this.next = next;
		return this;
	}

	@Override
	public String toString() {
		return "ListNode{" +
				"value=" + val +
				", next=" + next +
				'}';
	}
}
