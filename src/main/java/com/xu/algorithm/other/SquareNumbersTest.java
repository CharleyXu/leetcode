package com.xu.algorithm.other;

import org.junit.Test;

/**
 * @author CharleyXu Created on 2019/2/28.
 *
 * Sum of Square Numbers (Easy)
 *
 * Input: 5
 *
 * Output: True
 *
 * Explanation: 1 * 1 + 2 * 2 = 5
 *
 * 判断一个数是否为两个数的平方和
 */
public class SquareNumbersTest {

  public boolean judgeSquareNumbers(int number) {
    int left = 0;
    int right = (int) Math.sqrt(number);
    while (left < right) {
      int sum = left * left + right * right;
      if (sum < number) {
        left++;
      } else if (sum == number) {
        return true;
      } else {
        right--;
      }
    }
    return false;
  }

  @Test
  public void judgeSquareNumbersTest() {
    int number = 11;
    System.out.println(judgeSquareNumbers(number));
  }
}
