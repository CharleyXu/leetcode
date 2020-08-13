package com.xu.algorithm.medium;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

/**
 * Longest Substring Without Repeating Characters
 *
 * 给定一个字符串，找到最长的子字符串的长度，不重复字符
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring,
 * "pwke" i
 *  维护两个指针，右指针遍历存入Map，左指针条件移动
 *  相同值之间的最大长度（没有相同值取Max_Length）
 */
public class No3 {
	public int lengthOfLongestSubstring(String s) {
		if (null == s || s.length() < 1) {
			return 0;
		}
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int max = 0;

		for (int i = 0, j = 0, length = s.length(); i < length; i++) {
			if (map.containsKey(s.charAt(i))) {
				j = Math.max(j, map.get(s.charAt(i))+1);
			}
			map.put(s.charAt(i), i);
			max = Math.max(max, i - j+1);
		}
		return max;
	}

	@Test
	public void test() {
		String s = "abcddddadsc";  //abcdfafdvf
		int result = lengthOfLongestSubstring(s);
		System.out.println("int: " + result );
	}
}
