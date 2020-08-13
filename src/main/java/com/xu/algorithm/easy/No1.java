package com.xu.algorithm.easy;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * Two Sum
 * <p>
 * 利用HashMap，把target-numbers[i]的值放入hashMap中，value存index。
 * <p>
 * 遍历数组时，检查hashMap中是否已经存能和自己加一起等于target的值存在，存在的话把index取出，
 * <p>
 * 连同自己的index也出去，加1（index要求从1开始）后存入结果数组中返回。如果不存在的话，
 * <p>
 * 把自己的值和index存入hashMap中继续遍历。由于只是一遍遍历数组，时间复杂度为O(n)
 */
public class No1 {

    public int[] twoSum(int[] num, int target) {
        Map<Integer, Integer> map = new HashMap(num.length);
        for (int i = 0, length = num.length; i < length; i++) {
            if (map.get(num[i]) != null) {
                return new int[]{map.get(num[i]), i};
            }
            map.put((target - num[i]), i);
        }
        return new int[]{};
    }

	@Test
	public void test() {
		int[] ints = twoSum(new int[]{3, 5, 7, 1}, 12);
		Assert.assertArrayEquals(new int[]{1, 2}, ints);
	}

}
