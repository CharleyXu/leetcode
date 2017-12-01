package com.xu.leetcode;

import com.google.common.base.Stopwatch;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 *	处理大数相加
 * 	Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 	Output: 7 -> 0 -> 8
 	Explanation: 342 + 465 = 807.
 */
public class No2 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		//进位
		int pos = 0;
		ListNode head = new ListNode(0);
		ListNode temp = head;
		while (l1!=null || l2!=null || pos !=0){
			int sum = (l1 ==null?0:l1.val)+(l2==null?0:l2.val)+pos;
			pos = sum/10;
			ListNode preNode = new ListNode(sum%10);
			temp.next = preNode;
			temp = preNode;
			l1 = l1==null?l1:l1.next;
			l2 = l2==null?l2:l2.next;
		}
		return head.next;
	}

	class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }

		@Override
		public String toString() {
			return "ListNode{" +
					"val=" + val +
					", next=" + next +
					'}';
		}
	}

 	@Test
 	public void test(){
		ListNode listNode1 = new ListNode(2);
		ListNode listNode2 = new ListNode(4);
		ListNode listNode3 = new ListNode(3);
		listNode1.next = listNode2;
		listNode2.next = listNode3;

		ListNode listNode4 = new ListNode(5);
		ListNode listNode5 = new ListNode(6);
		ListNode listNode6 = new ListNode(4);
		listNode4.next = listNode5;
		listNode5.next = listNode6;
		System.out.println(listNode1);
		System.out.println(listNode4);

		Stopwatch started = Stopwatch.createStarted();
		ListNode listNode = addTwoNumbers(listNode1, listNode4);
		System.out.println(listNode+"--use--"+started.elapsed(TimeUnit.NANOSECONDS));

	}
}
