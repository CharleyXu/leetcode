package com.xu.algorithm.structure.linkedlist;

import org.junit.Test;

/**
 * @author charlie Created on 2018/2/8.
 */
public class MyLinkTest {

    ListNode head = null; // 头节点

    /**
     * 向链表中插入数据
     */
    public void addNode(int d) {
        ListNode newNode = new ListNode(d);// 实例化一个节点
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = newNode;
    }

    /**
     *
     */
    public boolean deleteNode(int index) {
        if (index < 1 || index > length()) {
            return false;
        }
        if (index == 1) {
            head = head.next;
            return true;
        }
        int i = 1;
        ListNode preNode = head;
        ListNode curNode = preNode.next;
        while (curNode != null) {
            if (i == index) {
                preNode.next = curNode.next;
                return true;
            }
            preNode = curNode;
            curNode = curNode.next;
            i++;
        }
        return false;
    }

    /**
     * @return 返回节点长度
     */
    public int length() {
        int length = 0;
        ListNode tmp = head;
        while (tmp != null) {
            length++;
            tmp = tmp.next;
        }
        return length;
    }

    /**
     * 在不知道头指针的情况下删除指定节点
     */
    public boolean deleteNode11(ListNode n) {
        if (n == null || n.next == null) {
            return false;
        }
        int tmp = n.val;
        n.val = n.next.val;
        n.next.val = tmp;
        n.next = n.next.next;
        System.out.println("删除成功！");
        return true;
    }

    public void printList() {
        ListNode tmp = head;
        while (tmp != null) {
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
    }

    @Test
    public void myLinkTest() {
        MyLinkTest list = new MyLinkTest();
        list.addNode(5);
        list.addNode(3);
        list.addNode(1);
        list.addNode(2);
        list.addNode(55);
        list.addNode(36);
        System.out.println("linkLength:" + list.length());
        System.out.println("head.data:" + list.head.val);
        list.printList();
        list.deleteNode(4);
        System.out.println("After deleteNode(4):");
        list.printList();

    }

}
