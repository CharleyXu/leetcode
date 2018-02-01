package com.xu.leetcode.medium;

import java.util.Arrays;
import org.junit.Test;

/**
 * @author charlie Created on 2018/2/1.
 *
 * 3Sum Closest
 *
 * 给定一个n个整数的数组S，在S中找到三个整数，使得总和最接近给定数量的目标。
 *
 * 返回三个整数的和。你可以假设每个输入都只有一个解决方案。
 *
 * array S = {-1 2 1 -4}, and target = 1.	The sum that is closest to the target is 2 (-1 + 2 + 1 =
 * 2)
 */
public class No16 {

	public int threeSumClosest(int[] nums, int target) {
		if (nums == null || nums.length < 3) {
			return 0;
		}
		Arrays.sort(nums);
		int max = Integer.MAX_VALUE;
		int val = 0;
		for (int i = 0, size = nums.length; i < size - 2; i++) {
			int low = i + 1;
			int high = size - 1;
			while (low < high) {
				int sum = nums[i] + nums[low] + nums[high];
				int temp = Math.abs(sum - target);
				if (temp < max) {
					max = temp;
					val = sum;
				}
				if (target == sum) {
					return val;
				} else if (target > sum) {
					low++;
				} else {
					high--;
				}
			}
		}
		return val;
	}

	@Test
	public void test() {
		int[] num = {-5, -5, -3, -2, -1, -1, -1, 21, 78, 31, 314};
		int i = threeSumClosest(num, 58);
		System.out.println(i);
	}
}
