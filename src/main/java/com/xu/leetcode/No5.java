package com.xu.leetcode;

/**
 * 求最长回文子串(Longest Palindromic Substring) 以中心为轴，这个字符串是左右对称 "a1abcba4a"，"abba"
 */
public class No5 {
	public static String longestPalindrome(String s) {    //	复杂度 O(n3)
		String result = null;
		String substring = null;
		int maxLength = 0;
		int end = s.length();
		if (end <= 0) {
			return null;
		}

		for (int i = 1; i <= end; i++) {
			for (int j = 0; j < i; j++) {
				substring = s.substring(j, i);
				if (isPalindrome(substring) && substring.length() > maxLength) {
					result = substring;
					maxLength = substring.length();
				}
			}
		}

		return result;
	}

	// "a1abcba4a"，"abba"
	public static String longestPalindrome2(String s) {    //	复杂度 O(n2)
		String result = new String();
		String substring = null;
		int end = s.length();
		if (end <= 0) {
			return null;
		}
		for (int i = 0; i < end - 1; i++) {
			substring = isPalindrome2(s, i, i);    //abcba
			if (substring.length() > result.length()) {
				result = substring;
			}

			substring = isPalindrome2(s, i, i + 1);    //abba
			if (substring.length() > result.length()) {
				result = substring;
			}
		}
		return result;
	}

	public static boolean isPalindrome(String s) {

		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	public static String isPalindrome2(String s, int start, int end) {
		while (start >= 0 && end <= s.length() - 1 && s.charAt(start) == s.charAt(end)) {
			start--;
			end++;
		}
		return s.substring(start + 1, end);

	}

	public static void main(String[] args) {
		String test = "tese011234";
		System.out.println(test + " " + longestPalindrome(test));
		System.out.println(test + " " + longestPalindrome2(test));
	}
}
