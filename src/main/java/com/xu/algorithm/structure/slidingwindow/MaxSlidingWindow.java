package com.xu.algorithm.structure.slidingwindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by CharleyXu on 2020-06-05
 * <p>
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 */
public class MaxSlidingWindow {

    /**
     * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
     * 输出: [3,3,5,5,6,7]
     * <p>
     * 用双向队列存储数组的**下标**，队首元素为窗口的最大元素
     * <p>
     * 时间复杂度 O(n)
     * <p>
     * 空间复杂度 O(k)
     * <p>
     * 两阶段判断
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k < 1) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        // 单调队列
        Deque<Integer> deque = new ArrayDeque<>();
        // 未形成窗口
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        result[0] = deque.peekFirst();
        // 形成窗口后
        for (int i = k; i < nums.length; i++) {
            // 最大值是 最左边界元素时，移除队首元素
            if (deque.peekFirst() == nums[i - k]) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            result[i - k + 1] = deque.peekFirst();
        }
        return result;
    }


    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || k < 1) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        // 单调双端队列
        Deque<Integer> deque = new ArrayDeque<>();
        // 形成窗口后
        for (int i = 0, j = 1 - k; i < nums.length; i++, j++) {
            // 形成窗口后, 最大值是 最左边界元素时，移除队首元素
            if (j > 0 && deque.peekFirst() == nums[i - k]) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            // 记录窗口最大值
            if (j >= 0) {
                result[j] = deque.peekFirst();
            }
        }
        return result;
    }

    /**
     * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值
     */
    public List<Integer> maxInWindows(int[] num, int size) {
        List<Integer> ret = new ArrayList<>();
        if (size > num.length || size < 1) {
            return ret;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);  /* 大顶堆 */
        for (int i = 0; i < size; i++) {
            heap.add(num[i]);
        }
        ret.add(heap.peek());
        for (int i = 0, j = i + size; j < num.length; i++, j++) {            /* 维护一个大小为 size 的大顶堆 */
            heap.remove(num[i]);
            heap.add(num[j]);
            ret.add(heap.peek());
        }
        return ret;
    }
}
