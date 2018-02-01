package com.xu.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

/**
 * @author charlie Created on 2018/2/1.
 *
 * 3Sum
 *
 * 给定一个n个整数的数组S，是否存在S中的元素a，b，c，使得a + b + c = 0？查找数组中所有唯一的三元组，其总和为零
 *
 * 时间复杂度 O(n2) 空间复杂度 O(1)
 */
public class No15 {

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		if (nums == null || nums.length < 3) {
			return lists;
		}

		Arrays.sort(nums);

		for (int i = 0, size = nums.length; i < size - 2; i++) {
			//remove dupicate
			if (i == 0 || nums[i] != nums[i - 1]) {
				int low = i + 1;
				int high = size - 1;
				while (low < high) {
					int sum = nums[i] + nums[low] + nums[high];
					if (sum == 0) {
						List<Integer> list = new ArrayList<>();
						list.add(nums[i]);
						list.add(nums[low]);
						list.add(nums[high]);
						lists.add(list);
						low++;
						high--;
						//remove dupicate
						while (low < high && nums[low] == nums[low - 1]) {
							low++;
						}
						while (low < high && nums[high] == nums[high + 1]) {
							high--;
						}
					} else if (sum > 0) {
						high--;
					} else {
						low++;
					}
				}
			}
		}
		return lists;
	}

	@Test
	public void test() {
		int[] num = {-5, -5, -3, -2, -1, -1, -1, 0, 0, 0, 1, 2, 4, 6, 9, 19, 19, 19};
		List<List<Integer>> lists = threeSum(num);
		System.out.println(lists);
	}
}
