<<<<<<< HEAD:src/main/java/com/xu/algorithm/medium/No18.java
package com.xu.algorithm.medium;

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
		int i, j, low, high, temp;
		for (i = 0; i < length - 3; i++) {
			for (j = i + 1; j < length - 2; j++) {
				low = j + 1;
				high = length - 1;
				temp = target - num[i] - num[j];
				while (low < high) {
					if (temp < num[low] + num[high]) {
						high--;
						continue;
					}
					if (temp == num[low] + num[high]) {
						List<Integer> integers = new ArrayList<>(
								Arrays.asList(num[i], num[j], num[low], num[high]));
						list.add(integers);
					}
					low++;
					while (low < high && num[low] == num[low - 1]) {
						low++;
					}
				}
				while (num[j] == num[j + 1] && j < length - 2) {
					j++;
				}
			}
			while (num[i] == num[i + 1] && i < length - 3) {
				i++;
			}
		}
		return list;
	}

	@Test
	public void test() {
		int[] arr = {1, 0, -1, 0, -2, 2};
		int[] arr2 = {-3, -3, 1, 0, -1, 0, 0, 0, 0, 1, 1, -2, 2, 3, 3, 3, 3, 4};
		int[] arr3 = {0, 4, -5, 2, -2, 4, 2, -1, 4};
		int target = 0;
		List<List<Integer>> list = fourSum(arr3, 12);
		System.out.println(list);
	}
}
=======
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
		int i, j, low, high, temp;
		for (i = 0; i < length - 3; i++) {
			for (j = i + 1; j < length - 2; j++) {
				low = j + 1;
				high = length - 1;
				temp = target - num[i] - num[j];
				while (low < high) {
					if (temp < num[low] + num[high]) {
						high--;
						continue;
					}
					if (temp == num[low] + num[high]) {
						List<Integer> integers = new ArrayList<>(
								Arrays.asList(num[i], num[j], num[low], num[high]));
						list.add(integers);
					}
					low++;
					while (low < high && num[low] == num[low - 1]) {
						low++;
					}
				}
				while (num[j] == num[j + 1] && j < length - 2) {
					j++;
				}
			}
			while (num[i] == num[i + 1] && i < length - 3) {
				i++;
			}
		}
		return list;
	}

	@Test
	public void test() {
//		int[] arr = {1, 0, -1, 0, -2, 2};
//		int[] arr2 = {-3, -3, 1, 0, -1, 0, 0, 0, 0, 1, 1, -2, 2, 3, 3, 3, 3, 4};
		int[] arr3 = {0, 4, -5, 2, -2, 4, 2, -1, 4};
		int target = 12;
		List<List<Integer>> list = fourSum(arr3, target);
		System.out.println(list);
	}
}
>>>>>>> 45881e9358f9bb61c0f9a28aa4aace01dbd96342:src/main/java/com/xu/leetcode/medium/No18.java
