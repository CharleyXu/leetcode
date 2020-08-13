package com.xu.algorithm.structure.linkedlist.print;

import com.xu.algorithm.structure.linkedlist.BaseLinkedList;
import com.xu.algorithm.structure.linkedlist.ListNode;
import com.xu.algorithm.structure.stack.Stack;
import org.junit.Test;

/**
 * @author CharleyXu Created on 2019/3/22.
 * <p>
 * 反向打印链表
 */
public class PrintReverseLinkedList extends BaseLinkedList {

    public void printReverseLinked(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        if (listNode != null) {
            stack.push(listNode.val);
        }
        while (listNode.next != null) {
            listNode = listNode.next;
            stack.push(listNode.val);
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    @Test
    public void printReverseLinkedTest() {
        printReverseLinked(head);
    }
}
