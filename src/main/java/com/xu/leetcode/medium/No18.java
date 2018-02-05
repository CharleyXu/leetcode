package com.xu.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

/**
 * @author charlie Created on 2018/2/5.
 *
 * 4Sum
 *
 * 给定一个n个整数的数组S，是否存在S中的元素a，b，c和d，使得a + b + c + d = target？在数组中找出所有唯一的四元组，给出目标的总和。
 */
public class No18 {

	public List<List<Integer>> fourSum(int[] num, int target) {
		List<List<Integer>> list = new ArrayList<>();
		if (num == null || num.length < 4) {
			return list;
		}
		Arrays.sort(num);
		int length = num.length;
		for (int i = 0; i < length - 3; i++) {
			if (num[i] > 0) {
				break;
			}
			int low = i;
			int high = length - 1;
			for (int j = i + 1; j < length - 2; j++) {
				while (low < high) {
					int sum = num[i] + num[j] + num[low] + num[high];
					if (sum == 0) {
						List<Integer> integers = new ArrayList<>(
								Arrays.asList(num[i], num[j], num[low], num[high]));
						list.add(integers);
//						high--;
//						low++;
						//remove dupicate
//						while (low < high && num[low] == num[low - 1]) {
//							low++;
//						}
//						while (low < high && num[high] == num[high + 1]) {
//							high--;
//						}
					} else if (sum > 0) {
						high--;
					} else {
						low++;
					}
				}
			}
		}
		return list;
	}

	@Test
	public void test() {
		int[] arr = {1, 0, -1, 0, -2, 2};
		int[] arr2 = {-3, -3, 1, 0, -1, 0, 0, 1, 1, -2, 2, 3, 3, 3, 3, 4};
		int target = 0;
		List<List<Integer>> list = fourSum(arr, 0);
		System.out.println(list);
	}
}
