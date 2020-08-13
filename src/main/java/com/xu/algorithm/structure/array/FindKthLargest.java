package com.xu.algorithm.structure.array;


import java.util.PriorityQueue;

import org.junit.Test;

/**
 * @author CharleyXu Created on 2019/3/25.
 * <p>
 * Kth Largest Element in an Array(找出无序数组第K大的元素)
 * <p>
 * 相似 Find K Pairs with Smallest Sums(题目描述，自行Leetcode)
 */
public class FindKthLargest {

    /**
     * 使用优先队列
     *
     * 小顶堆
     */
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            priorityQueue.offer(nums[i]);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        return priorityQueue.peek();
    }

    @Test
    public void findKthLargestTest() {
        int[] nums = new int[]{13, 5, 32, 5, 7, 1, 7};
        int kthLargest = findKthLargest(nums, 2);
        System.out.println(kthLargest);
    }

}
