<<<<<<< HEAD:src/main/java/com/xu/algorithm/easy/No7.java
package com.xu.algorithm.easy;

import org.junit.Test;
/**
 * Reverse Integer
 *
 *
 *
 * 这种题的考察重点并不在于问题本身，
 * 越是简单的题目越要注意细节，
 * 一般来说整数的处理问题要注意的有两点，一点是符号，另一点是整数越界问题
 *
 * 注意Integer.MIN_VALUE的绝对值是比Integer.MAX_VALUE大1
 *
 */
public class No7 {

	public int reverse(int x) {
		if (x==Integer.MIN_VALUE){
			return 0;
		}
		int nums = Math.abs(x);
		int result = 0;
		while(nums!=0){
			if(result>(Integer.MAX_VALUE-nums%10)/10){
				return 0;
			}
			result = result*10+nums%10;
			nums = nums/10;
		}
		return x>0?result:-result;
	}


	public int reverse2(int x) {
		int output = 0;

		while (true) {
			if (x == 0) {
				return x;
			}

			output = output * 10 + x % 10;

			if ((x /= 10) == 0) {
				return output;
			}

			if (output > 214748364 || output < -214748364) {
				return 0;
			}
		}
	}
	@Test
	public void test(){
		int num = 2147481112;
		System.out.println(num+"\n"+ reverse(num)+"\n"+ reverse2(num));
	}
}
=======
package com.xu.leetcode.easy;

import org.junit.Test;
/**
 * Reverse Integer
 *
 *
 *
 * 这种题的考察重点并不在于问题本身，
 * 越是简单的题目越要注意细节，
 * 一般来说整数的处理问题要注意的有两点，一点是符号，另一点是整数越界问题
 *
 * 注意Integer.MIN_VALUE的绝对值是比Integer.MAX_VALUE大1
 *
 */
public class No7 {

	public int reverse(int x) {
		if (x==Integer.MIN_VALUE){
			return 0;
		}
		int num = Math.abs(x);
		int result = 0;
		while (num != 0) {
			if (result > (Integer.MAX_VALUE - num % 10) / 10) {
				return 0;
			}
			result = result * 10 + num % 10;
			num = num / 10;
		}
		return x>0?result:-result;
	}


	public int reverse2(int x) {
		int output = 0;

		while (true) {
			if (x == 0) {
				return x;
			}

			output = output * 10 + x % 10;

			if ((x /= 10) == 0) {
				return output;
			}

			if (output > 214748364 || output < -214748364) {
				return 0;
			}
		}
	}
	@Test
	public void test(){
		int num = 2147481112;
		System.out.println(num+"\n"+ reverse(num)+"\n"+ reverse2(num));
	}
}
>>>>>>> 45881e9358f9bb61c0f9a28aa4aace01dbd96342:src/main/java/com/xu/leetcode/easy/No7.java
