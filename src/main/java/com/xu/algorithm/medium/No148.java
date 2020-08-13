package com.xu.leetcode.medium;

import com.xu.leetcode.other.ListNode;
import org.junit.Test;

/**
 * @author charlie Created on 2018/2/9. Sort List	排序列表
 */
public class No148 {

	public ListNode bubbleSort(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode pre = head;
		int temp = 0;
		ListNode cur;
		while (pre.next != null) {
			cur = pre.next;
			while (cur != null) {
				if (cur.val < pre.val) {
					temp = cur.val;
					cur.val = pre.val;
					pre.val = temp;
				}
				cur = cur.next;
			}
			pre = pre.next;
		}
		return head;
	}

	/**
	 * 归并排序
	 */
	public ListNode mergeSort(ListNode head) {
		//空链表
		if (head == null) {
			return head;
		}
		ListNode slow = head;
		ListNode fast = head.next;

		//使用快慢指针寻找中间 结点
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next;
			if (fast.next != null) {
				fast = fast.next;
			}
		}

		ListNode ptr1 = slow.next;
		slow.next = null;

		ListNode tmp1 = mergeSort(head);
		ListNode tmp2 = mergeSort(ptr1);
		return merge(tmp1, tmp2);
	}


	public ListNode merge(ListNode start1, ListNode start2) {
		ListNode header = new ListNode(-1);
		ListNode pre = header;

		ListNode ptr1 = start1, ptr2 = start2;
		while (ptr1 != null && ptr2 != null) {
			if (ptr1.val <= ptr2.val) {
				pre.next = ptr1;
				pre = ptr1;
				ptr1 = ptr1.next;
			} else {
				pre.next = ptr2;
				pre = ptr2;
				ptr2 = ptr2.next;
			}
		}
		while (ptr1 != null) {
			pre.next = ptr1;
			pre = ptr1;
			ptr1 = ptr1.next;
		}

		while (ptr2 != null) {
			pre.next = ptr2;
			pre = ptr2;
			ptr2 = ptr2.next;
		}
		return header.next;
	}

	@Test
	public void sortListTest() {
		ListNode node5 = new ListNode(15, null);
		ListNode node4 = new ListNode(4, node5);
		ListNode node3 = new ListNode(7, node4);
		ListNode node2 = new ListNode(9, node3);
		ListNode head = new ListNode(1, node2);
		ListNode listNode = bubbleSort(head);
		ListNode listNode1 = mergeSort(head);
		System.out.println(listNode);
		System.out.println(listNode1);
	}
}

