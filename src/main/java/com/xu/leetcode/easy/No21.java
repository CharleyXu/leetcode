package com.xu.leetcode.easy;

import org.junit.Test;

/**
 * @author charlie Created on 2018/2/9.
 *
 * Merge Two Sorted Lists 合并两个排序列表
 *
 * Input: 1->2->4, 1->3->4
 *
 * Output: 1->1->2->3->4->4
 */
public class No21 {

	/**
	 * 合并两个排序列表
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		}
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		//新链表的头结点
		ListNode head = null;
		//current指向新链表
		ListNode current = null;
		if (l1.val < l2.val) {
			head = l1;
			current = l1;
			l1 = l1.next;
		} else {
			head = l2;
			current = l2;
			l2 = l2.next;
		}
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				current.next = l1;
				current = current.next;
				l1 = l1.next;
			} else {
				current.next = l2;
				current = current.next;
				l2 = l2.next;
			}
		}
		//合并剩余元素
		if (l1 != null) {
			current.next = l1;
		}
		if (l2 != null) {
			current.next = l2;
		}
		return head;
	}

	@Test
	public void mergeTwoListsTest() {
		ListNode node4 = new ListNode(15);
		ListNode node3 = new ListNode(9);
		ListNode node2 = new ListNode(4);
		node4.next = null;
		ListNode l1 = new ListNode(0);
		l1.next = node2;
		node2.next = node3;
		node3.next = node4;

		ListNode node8 = new ListNode(30);
		ListNode node7 = new ListNode(8);
		ListNode node6 = new ListNode(2);
		node8.next = null;
		ListNode l2 = new ListNode(0);
		l2.next = node6;
		node6.next = node7;
		node7.next = node8;
		System.out.println("l1:" + l1);
		System.out.println("l2:" + l2);
		l1 = null;
		l2 = new ListNode(0);
		ListNode node = mergeTwoLists(l1, l2);
		System.out.println(node);
	}
}

class ListNode {

	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	@Override
	public String toString() {
		return "ListNode{" +
				"val=" + val +
				", next=" + next +
				'}';
	}
}
