package com.xu.leetcode;

import org.junit.Test;

/**
 * Palindrome Number	回文数字 以中心为轴，左右对称 1221，12321
 */
public class No9 {

	public boolean isPalindrome(int x) {
		//negative numbers are not palindrome
		if (x < 0)
			return false;

		// initialize how many zeros
		int div = 1;
		while (x / div >= 10) {
			div *= 10;
		}

		while (x != 0) {
			int left = x / div;
			int right = x % 10;

			if (left != right)
				return false;

			x = (x % div) / 10;
			div /= 100;
		}
		return true;
	}

	@Test
	public void test() {
		int i = 1233215;
		System.out.println(isPalindrome(i));
	}

	//反转integer后判断
	public boolean isPalindromeTemp(int x) {
		No7 no7 = new No7();
		int reverse = no7.reverse(x);
		return reverse == x;
	}

}
