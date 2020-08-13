package com.xu.algorithm.other;

import com.google.common.base.Stopwatch;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

/**
 * @author CharleyXu Created on 2018/9/12.
 */
public class LinkedListTest {

  ListNode node6 = new ListNode(15, null);
  ListNode node5 = new ListNode(12, node6);
  ListNode node4 = new ListNode(9, node5);
  ListNode node3 = new ListNode(10, node4);
  ListNode node2 = new ListNode(3, node3);
  ListNode node1 = new ListNode(1, node2);
  //head结点
  ListNode head = new ListNode(0, node1);

  @Test
  public void test() {
    System.out.println("当前列表:" + head);
  }

  /**
   * 查找链表的中间结点
   */
  @Test
  public void findMidNodeTest() {
    ListNode midNode = findMidNode(head);
    System.out.println(midNode);
  }

  /**
   * 查找链表的倒数第k个结点
   */
  @Test
  public void findLastNodeByIndexTest() {
    System.out.println("Before:" + head);
    ListNode lastNodeByIndex = findLastNodeByIndex(head, 3);
    System.out.println("After:" + lastNodeByIndex);
  }

  /**
   * 从尾结点插入数据
   */
  @Test
  public void addNodeTest() {
    System.out.println("Before:" + head);
    addNode(head, 100);
    System.out.println("插入后的数据当前列表:" + head);
  }

  /**
   * 从指定位置插入数据
   */
  @Test
  public void insertNodeByIndexTest() {
    System.out.println("Before:" + head);
    try {
      insertNodeByIndex(head, 3, 55);
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("After:" + head);
  }

  /**
   * 从首结点插入数据
   */
  @Test
  public void insertNodeAtFirstTest() {
    System.out.println("Before:" + head);
    try {
      insertNodeAtFirst(head, 55);
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("After:" + head);
  }

  /**
   * 删除第index个节点
   */
  @Test
  public void deleteIndexTest() {
    try {
      System.out.println("Before:" + head);
      deleteIndex(head, 4);
      System.out.println("After:" + head);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 删除倒数第index个节点
   */
  @Test
  public void removeNthFromEndTest() {
    try {
      System.out.println("Before:" + head);
      removeNthFromEnd(head, 3);
      System.out.println("After:" + head);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * O(1) 时间删除链表节点
   */
  @Test
  public void deleteNodeTest() {
    System.out.println("Before:" + head);
    deleteNode(head, node2);
    System.out.println("删除某个节点后:" + head);
  }

  /**
   * 删除单链表中的重复节点，重复节点只保留一个
   */
  @Test
  public void deleteDuplicationTest() {
    System.out.println("Before:" + head);
    Stopwatch started = Stopwatch.createStarted();
    deleteDuplication(head);
    System.out.println("use " + started.elapsed(TimeUnit.MILLISECONDS) + " ms");
    System.out.println("After:" + head);
  }

  /**
   * 反转链表	非递归
   */
  @Test
  public void reverseTest() {
    System.out.println("Before:" + head);
    ListNode node = reverse(head);
    System.out.println("After:" + node);
  }

  /**
   * 递归反转
   */
  @Test
  public void reverseRecursionTest() {
    System.out.println("Before:" + head);
    ListNode node = reverseRecursion(head);
    System.out.println("After:" + node);
  }

  /**
   * 合并两个有序的单链表，合并之后的链表依然有序
   *
   * 类似于归并排序	O (max(len1,len2))
   */
  @Test
  public void mergeListNodeTest() {
    ListNode n5 = new ListNode(10, null);
    ListNode n4 = new ListNode(7, n5);
    ListNode n3 = new ListNode(5, n4);
    ListNode n2 = new ListNode(4, n3);
    ListNode n1 = new ListNode(3, n2);

    ListNode n15 = new ListNode(15, null);
    ListNode n13 = new ListNode(12, n15);
    ListNode n11 = new ListNode(2, n13);

    ListNode head1 = new ListNode(0, n1);
    ListNode head2 = new ListNode(0, n11);
    ListNode node = mergeListNode(head1, head2);
    System.out.println(node);
  }

  /**
   * 打印链表
   */
  @Test
  public void printTest() {
    print(head);
    System.out.println();
    printReverse(head);
  }

  /**
   * 链表长度
   */
  @Test
  public void sizeTest() {
    ListNode node1 = new ListNode(1, null);
    ListNode head = new ListNode(0, node1);
    int size = size(head);
    System.out.println("链表长度:" + size);
  }

  @Test
  public void quickSortTest(){
    ListNode node = quickSortList(head);
    System.out.println(node);
  }

  /**
   * 查找链表的中间结点 快慢指针
   */
  public ListNode findMidNode(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode slow = head;
    ListNode fast = head;

    while (slow != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  /**
   * 查找链表的倒数第k个结点
   */
  public ListNode findLastNodeByIndex(ListNode head, int index) {
    if (head == null || head.next == null) {
      return null;
    }
    if (index < 0 || index > size(head)) {
      return null;
    }

    ListNode fast = head;
    ListNode slow = head;
    for (int i = 0; i < index; i++) {
      fast = fast.next;
    }
    while (fast != null) {
      slow = slow.next;
      fast = fast.next;
    }
    return slow;
  }

  /**
   * 从尾部插入一条数据
   */
  public void addNode(ListNode head, int val) {
    if (head == null) {
      return;
    }
    ListNode listNode = new ListNode(val, null);
    while (head.next != null) {
      head = head.next;
    }
    head.next = listNode;
  }

  /**
   * 向链表的指定位置插入数据
   */
  public void insertNodeByIndex(ListNode head, int index, int val) throws Exception {
    if (head == null) {
      throw new Exception("head == null错误");
    }
    if (index < 0 || index > size(head)) {
      throw new Exception("index错误");
    }
    //空链表
    if (index == 0 && head.next == null) {
      head.next = new ListNode(val, head.next);
    }
    ListNode pre = head;
    ListNode current = head.next;
    int num = 1;
    while (current != null) {
      if (index == num) {
        pre.next = new ListNode(val, current);
      }
      pre = current;
      current = current.next;
      num++;
    }
  }

  /**
   * 向链表的指定位置插入数据
   */
  public void insertNodeAtFirst(ListNode head, int val) throws Exception {
    if (head == null) {
      throw new Exception("头结点为Null错误");
    }
    head.next = new ListNode(val, head.next);
  }

  /**
   * 删除第index个节点 	使用快慢双指针
   *
   * 一般链表删除节点时候，需要维护一个prev指针，指向需要删除节点的上一个节点
   */
  public void deleteIndex(ListNode head, int index) throws Exception {
    //Null 或 空链表
    if (head == null || head.next == null) {
      throw new Exception("头结点为空 或者是空链表");
    }
    if (index < 1 || index > size(head)) {
      throw new Exception("输入的index错误");
    }
    int i = 1;
    ListNode pre = head;
    ListNode current = head.next;
    while (current != null) {
      if (i == index) {
        pre.next = current.next;
      }
      pre = current;
      current = current.next;
      i++;
    }
  }

  /**
   * 删除倒数第index个节点
   *
   * 使用快慢双指针
   */
  public void removeNthFromEnd(ListNode head, int index) throws Exception {
    //Null 或 空链表
    if (head == null || head.next == null) {
      throw new Exception("头结点为空 或者是空链表");
    }
    if (index < 1 || index > size(head)) {
      throw new Exception("输入的index错误");
    }
    ListNode fast = head;
    ListNode slow = head;

    for (int i = 0; i < index; i++) {
      fast = fast.next;
    }
    while (fast.next != null) {
      slow = slow.next;
      fast = fast.next;
    }
    slow.next = slow.next.next;
  }

  /**
   * 删除某节点
   *
   * @param head 头指针
   * @param node 节点指针
   */
  public void deleteNode(ListNode head, ListNode node) {
    //Null 或 空链表
    if (head == null || head.next == null || node == null) {
      return;
    }
    //尾节点
    if (node.next == null) {
      while (head.next != node) {
        head = head.next;
      }
      head.next = null;
    } else {
      //中间节点
      node.data = node.next.data;
      node.next = node.next.next;
    }
  }

  /**
   * 删除单链表中的重复节点		保留一个
   */
  public void deleteDuplication(ListNode head) {
    if (head == null || head.next == null) {
      return;
    }
    ListNode pre = head;
    while (pre != null) {
      ListNode current = pre.next;
      while (current != null) {
        if (pre.data == current.data) {
          pre.next = current.next;
        }
        current = current.next;
      }
      pre = pre.next;
    }
  }

  /**
   * 反转链表	非递归
   *
   * 时间复杂度	O(n)
   *
   * 需要三个指针配合工作，使得两个节点间的指向反向，next指针记录剩下的链表
   */
  public ListNode reverse(ListNode head) {
    // 若为空链或者当前结点在尾结点，则直接返回
    if (head == null || head.next == null) {
      return head;
    }
    ListNode pre = head;
    ListNode cur = null;
    ListNode next;
    //为空时,到了尾节点
    while (pre != null) {
      //临时结点next记录下一个节点
      next = pre.next;
      //指针域反转
      pre.next = cur;
      //将当前节点给cur
      cur = pre;
      //移动到下一个节点
      pre = next;
    }
    return cur;
  }

  /**
   * 递归反转链表
   */
  public ListNode reverseRecursion(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    //反转后续节点head.next
    ListNode node = reverseRecursion(head.next);
    //将当前节点的指针域向前移
    head.next.next = head;
    //前一节点的指针域置空
    head.next = null;
    return node;
  }

  /**
   * 合并两个有序的单链表，合并之后的链表依然有序
   */
  public ListNode mergeListNode(ListNode head1, ListNode head2) {
    if (head1 == null && head2 == null) {
      return null;
    }
    if (head1 == null) {
      return head2;
    }
    if (head2 == null) {
      return head1;
    }
    //新链表的头结点
    ListNode head = null;
    //current结点指向新链表
    ListNode current = null;
    if (head1.data < head2.data) {
      head = head1;
      current = head1;
      head1 = head1.next;
    } else {
      head = head2;
      current = head2;
      head2 = head2.next;
    }
    while (head1 != null && head2 != null) {
      if (head1.data < head2.data) {
        //current指针的下一个结点对应较小的数据
        current.next = head1;
        //current和head1指针下移
        current = current.next;
        head1 = head1.next;
      } else {
        current.next = head2;
        current = current.next;
        head2 = head2.next;
      }
    }
    if (head1 != null) {
      current.next = head1;
    }
    if (head2 != null) {
      current.next = head2;
    }
    return head;
  }

  /**
   * 判断单链表是否有环
   *
   * @return 返回的结点是相遇的那个结点
   */
  public ListNode hasRing(ListNode head) {
    if (head == null || head.next == null) {
      return null;
    }
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      //快慢指针相遇,说明有环
      if (slow == fast) {
        return slow;
      }
    }
    return null;
  }

  /**
   * 有环链表中，获取环的长度
   *
   * @param node 参数node代表的是相遇的那个结点
   */
  public int getRingLength(ListNode node) {
    if (node == null) {
      return 0;
    }
    ListNode current = node;
    int length = 0;
    while (node != null) {
      current = current.next;
      length++;
      if (current == node) {
        return length;
      }
    }
    return 0;
  }

  /**
   * 单链表，有环的话找出环的入口
   */
  public ListNode findLoopNode(ListNode head) {
    if (head == null || head.next == null) {
      return null;
    }
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        break;
      }
    }
    slow = head;
    while (fast != slow) {
      slow = slow.next;
      fast = fast.next;
    }
    return slow;
  }

  /**
   * 判断两个链表是否相交
   *
   * 如果他们相交，那么最后的一个节点一定相同
   */
  public boolean isIntersect(ListNode head1, ListNode head2) {
    if (head1 == null || head2 == null) {
      return false;
    }
    while (head1 != null) {
      head1 = head1.next;
    }
    while (head2 != null) {
      head2 = head2.next;
    }
    return head1 == head2;
  }

  /**
   * 链表排序
   *
   * 冒泡排序
   */
  public ListNode bubbleOrder(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode pre = head;
    ListNode cur = null;
    int temp = 0;
    while (pre.next != null) {
      cur = pre.next;
      while (cur != null) {
        if (cur.data < pre.data) {
          temp = cur.data;
          cur.data = pre.data;
          pre.data = temp;
        }
        cur = cur.next;
      }
      pre = pre.next;
    }
    return head;
  }

  /**
   * 在O(nlogn)时间内对链表进行排序
   * 快速排序
   * @param head
   *
   */
  public ListNode quickSortList(ListNode head) {
    quickSort(head, null);
    return head;
  }

  public void quickSort(ListNode head, ListNode end) {
    if (head != end) {
      ListNode node = partion(head, end);
      quickSort(head, node);
      quickSort(node.next, end);
    }
  }

  public ListNode partion(ListNode head, ListNode end) {
    ListNode p1 = head, p2 = head.next;

    //走到末尾才停
    while (p2 != end) {

      //大于key值时，p1向前走一步，交换p1与p2的值
      if (p2.data < head.data) {
        p1 = p1.next;

        int temp = p1.data;
        p1.data = p2.data;
        p2.data = temp;
      }
      p2 = p2.next;
    }

    //当有序时，不交换p1和key值
    if (p1 != head) {
      int temp = p1.data;
      p1.data = head.data;
      head.data = temp;
    }
    return p1;
  }

  /**
   * 归并排序
   * @param head
   * @return
   */
  public ListNode mergeSortList(ListNode head) {
    //采用归并排序
    if (head == null || head.next == null) {
      return head;
    }
    //获取中间结点
    ListNode mid = getMid(head);
    ListNode right = mid.next;
    mid.next = null;
    //合并
    return mergeSort(mergeSortList(head), mergeSortList(right));
  }

  /**
   * 获取链表的中间结点,偶数时取中间第一个
   *
   * @param head
   * @return
   */
  private ListNode getMid(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    //快慢指针
    ListNode slow = head, quick = head;
    //快2步，慢一步
    while (quick.next != null && quick.next.next != null) {
      slow = slow.next;
      quick = quick.next.next;
    }
    return slow;
  }

  /**
   *
   * 归并两个有序的链表
   *
   * @param head1
   * @param head2
   * @return
   */
  private ListNode mergeSort(ListNode head1, ListNode head2) {
    ListNode p1 = head1, p2 = head2, head;
    //得到头节点的指向
    if (head1.data < head2.data) {
      head = head1;
      p1 = p1.next;
    } else {
      head = head2;
      p2 = p2.next;
    }

    ListNode p = head;
    //比较链表中的值
    while (p1 != null && p2 != null) {

      if (p1.data <= p2.data) {
        p.next = p1;
        p1 = p1.next;
        p = p.next;
      } else {
        p.next = p2;
        p2 = p2.next;
        p = p.next;
      }
    }
    //第二条链表空了
    if (p1 != null) {
      p.next = p1;
    }
    //第一条链表空了
    if (p2 != null) {
      p.next = p2;
    }
    return head;
  }


  /**
   * 获取链表长度
   */
  public int size(ListNode node) {
    int size = 0;
    if (node == null) {
      return size;
    }
    while (node.next != null) {
      node = node.next;
      size++;
    }
    return size;
  }

  /**
   * 倒序遍历打印 	使用栈结构
   */
  public void printReverse(ListNode head) {
    if (head == null || head.next == null) {
      return;
    }
    Stack<ListNode> stack = new Stack<>();
    while (head != null) {
      stack.push(head);
      head = head.next;
    }
    while (!stack.isEmpty()) {
      System.out.print(stack.pop().data + ",");
    }
  }

  /**
   * 遍历打印链表
   */
  public void print(ListNode node) {
    if (node == null) {
      return;
    }
    while (node != null) {
      System.out.print(node.data + ",");
      node = node.next;
    }
  }

  /**
   * 定义链表节点
   */
  private class ListNode {

    public int data;
    public ListNode next;

    public ListNode(final int data, final ListNode next) {
      this.data = data;
      this.next = next;
    }

    @Override
    public String toString() {
      return "ListNode{" +
          "data=" + data +
          ", next=" + next +
          '}';
    }
  }
}
