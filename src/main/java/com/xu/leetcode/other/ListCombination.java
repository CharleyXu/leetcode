package com.xu.leetcode.other;

import java.util.Arrays;
import org.junit.Test;

/**
 * @author charlie Created on 2018/1/31.
 *
 * 输入1个字符串,打印出该字符串中字符的所有排列
 *
 * abc	所有字符串 abd、acb、bac、bca、cab、cba
 */
public class ListCombination {

	@Test
	public void test() {
		final String str = "abc";
		char[] chars = str.toCharArray();
		recursionSwap(chars, 0, chars.length);
	}

	public void recursionSwap(char[] chars, int start, int length) {
		if (start >= length - 1) {
			print(chars);
			return;
		}
		for (int i = start; i < length; i++) {
			swap(chars, start, i);
			recursionSwap(chars, start + 1, length);
			swap(chars, start, i);
		}
	}

	public void swap(char[] chars, int a, int b) {
		char temp = chars[a];
		chars[a] = chars[b];
		chars[b] = temp;
	}

	public void print(char[] chars) {
		System.out.println(Arrays.toString(chars));
	}
}
