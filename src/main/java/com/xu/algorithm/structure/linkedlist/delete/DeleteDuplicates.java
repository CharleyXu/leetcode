package com.xu.algorithm.structure.linkedlist.delete;

import com.xu.algorithm.structure.linkedlist.ListNode;

/**
 * Created by CharleyXu on 2020-06-02
 * <p>
 * 删除排序链表中的重复元素
 */
public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = head;
        while (pre != null && pre.next != null) {
            if (pre.val == pre.next.val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }
        return head;
    }
}
