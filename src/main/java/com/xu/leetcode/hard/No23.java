package com.xu.leetcode.hard;

import com.xu.leetcode.other.ListNode;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import org.junit.Test;

/**
 * @author charlie Created on 2018/2/9.
 *
 * Merge k Sorted Lists	合并k排序列表,并将其作为一个排序列表返回
 */
public class No23 {

	/**
	 *
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}
		Comparator<ListNode> com = new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val - o2.val;
			}
		};
		int length = lists.length;
		Queue<ListNode> heap = new PriorityQueue<ListNode>(length, com);
		//把lists数组中的头节点依次放入queue中
		for (int i = 0; i < length; i++) {
			if (lists[i] != null) {
				heap.offer(lists[i]);
			}
		}

		ListNode head = new ListNode(0);
		ListNode p = head;
		while (!heap.isEmpty()) {
			ListNode node = heap.poll(); //每次把最小的弹出
			p.next = node;
			p = node;
			if (node.next != null) {
				heap.offer(node.next);
			}
		}
		return head.next;
	}

	@Test
	public void mergeKListsTest() {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(1);
		ListNode node5 = new ListNode(1);
		ListNode node6 = new ListNode(2);
		node1.next = node2;
		node2.next = node3;
		node3.next = null;

		node4.next = node5;
		node5.next = node6;
		node6.next = null;

		ListNode[] listNodes = {node1, node4};
//		ListNode [] listNodes = {null,null};
		ListNode node = mergeKLists(listNodes);
		System.out.println(node);

	}
}
