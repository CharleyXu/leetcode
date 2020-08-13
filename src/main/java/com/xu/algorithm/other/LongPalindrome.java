package com.xu.algorithm.other;

import org.junit.Test;

/**
 * @author charlie Created on 2018/3/12.
 *
 * 最长回文串
 */
public class LongPalindrome {

	public String longestPalindrome(String s) {
		int size = s.length();
		//长度为1，返回当前串
		if (size == 1) {
			return s;
		}
		//长度为2
		if (size == 2 && s.charAt(0) == s.charAt(1)) {
			return s;
		}
		//用于标记isLongestPalindrome[j][i]即从j到i是否是回文串；
		//如isLongestPalindrome[1][5]＝＝true则表示字符串索引位置从1到5的子串是回文串。
		boolean[][] isLongestPalindrome = new boolean[size][size];
		//最长回文串初始最大为0
		int maxLength = 0;
		//maxLength
		int beginIndex = 0;
		//对应的maxLength的结束索引位置
		int lastIndex = 0;
		for (int i = 0; i < size; i++) {
			int j = i;
			while (j >= 0) {
				//满足 当前s.charAt(i)==s.charAt(j)并且s[j＋1到i－1]也是回文串
				if (s.charAt(i) == s.charAt(j) && (i - j < 2 || isLongestPalindrome[j + 1][i - 1])) {
					isLongestPalindrome[j][i] = true;
					if (maxLength < i - j + 1) {
						beginIndex = j;
						lastIndex = i + 1;
						maxLength = i - j + 1;
					}
				}
				j--;
			}
		}
		return s.substring(beginIndex, lastIndex);
	}

	@Test
	public void isLongestPalindromeTest() {
		String s = "abcstba";
		System.out.println(longestPalindrome(s));
	}

}
