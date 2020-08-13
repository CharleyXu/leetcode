package com.xu.algorithm.easy;

import org.junit.Test;

/**
 * @author charlie Created on 2018/2/1.
 *
 * Longest Common Prefix
 *
 * 查找字符串数组中最长的公共前缀字符串
 *
 * 最长前缀肯定不能大于字符串的最小长度
 */
public class NO14 {

	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		String firstString = strs[0];
		for (int i = 0, length = firstString.length(); i < length; i++) {
			char c = firstString.charAt(i);
			for (int j = 1, size = strs.length; j < size; j++) {
				if (strs[j].length() == i || strs[j].charAt(i) != c) {
					return firstString.substring(0, i);
				}
			}
		}
		return firstString;
	}

	@Test
	public void test() {
		String[] strings = {"awq1", "aw2322", "awq333", "awq444"};
		System.out.println(longestCommonPrefix(strings));
	}
}
