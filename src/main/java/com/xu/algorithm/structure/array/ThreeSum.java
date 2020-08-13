package com.xu.algorithm.structure.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * @author CharleyXu Created on 2019/3/18.
 * <p>
 * 三数之和
 * <p>
 * 排序 + 双指针
 */
public class ThreeSum {

    /**
     * 判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) break;
            // 去重 duplicate
            if (k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum < 0) {
                    while (i < j && nums[i] == nums[++i]) ;
                } else if (sum > 0) {
                    while (i < j && nums[j] == nums[--j]) ;
                } else {
                    res.add(new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while (i < j && nums[i] == nums[++i]) ;
                    while (i < j && nums[j] == nums[--j]) ;
                }
            }
        }
        return res;
    }

    /**
     * 给定一个n个整数的数组S，在S中找到三个整数，使得总和最接近给定数量的目标。
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        //排序,为了使用双指针two pointers来遍历找两数之和
        Arrays.sort(nums);
        //
        int max = Integer.MAX_VALUE;
        int result = 0;
        //确定第一个数字后，就在剩下的array里找两数之和
        for (int i = 0, size = nums.length; i < size - 2; i++) {
            int low = i + 1;
            int high = size - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                int abs = Math.abs(sum - target);
                if (abs < max) {
                    max = abs;
                    result = sum;
                }
                if (sum == target) {
                    return abs;
                } else if (sum < target) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return result;
    }

    @Test
    public void threeSumTest() {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> threeSum = threeSum(nums);
        System.out.println(threeSum);
    }

    @Test
    public void threeSumClosetTest() {
        int[] nums = new int[]{-1, 2, 1, -4};
        int target = 1;
        int i = threeSumClosest(nums, target);
        System.out.println(i);
    }
}
