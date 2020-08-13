package com.xu.algorithm.easy;

import lombok.ToString;
import org.junit.Test;

/**
 * @author CharleyXu Created on 2019/2/18.
 * <p>
 * 合并两个链表
 */
public class No21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    @ToString
    private class ListNode {

        private int val;
        private ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    @Test
    public void mergeTest() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;

        node4.next = node5;
        node5.next = node6;

        ListNode listNode = mergeTwoLists(node1, node4);
        System.out.println(listNode);
    }
}
