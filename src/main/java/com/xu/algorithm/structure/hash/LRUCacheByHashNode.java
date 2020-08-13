package com.xu.algorithm.structure.hash;

import java.util.HashMap;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author CharleyXu Created on 2019/3/18.
 *
 * 每次写入数据时将数据放入链表头结点
 *
 * 使用数据时候将数据移动到头结点
 *
 * 缓存数量超过阈值时移除链表尾部数据
 */
public class LRUCacheByHashNode<K, V> {

  private HashMap<K, V> hashMap;
  private int size;
  private Node head;
  private Node tail;

  public LRUCacheByHashNode(int maxSize) {
    this.hashMap = new HashMap<>();
    this.size = maxSize;
    this.head = new Node();
    this.head.pre = null;
    this.tail = new Node();
  }

  @AllArgsConstructor
  @NoArgsConstructor
  private class Node {

    int value;
    Node next;
    Node pre;
  }
}
