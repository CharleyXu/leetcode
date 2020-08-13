package com.xu.algorithm.structure.string;

import org.junit.Test;

/**
 * @author CharleyXu Created on 2019/3/17.
 *
 * 回文字符串
 */
public class PalindromeString {

  /**
   * 正则剔除+反转法
   *
   * 时间复杂度：O(n),空间复杂度：O(n)
   */
  public boolean isPalindromeByReverse(String s) {
    if (checkFirst(s)) {
      return false;
    }
    //  [^\\d^a-z^A-Z^] 等同于[^a-z^A-Z^0-9]
    String result = s.replaceAll("[^a-z^A-Z^0-9]", "").toLowerCase();
    String reverseString = new StringBuilder(result).reverse().toString();
    return result.equals(reverseString);
  }

  /**
   * 正则剔除+双指针
   */
  public boolean isPalindromeByTwoPointer(String s) {
    if (checkFirst(s)) {
      return false;
    }
    String result = s.replaceAll("[^a-z^A-Z^0-9]", "").toLowerCase();
    int start = 0, end = result.length() - 1;
    while (start < end) {
      if (result.charAt(start) != result.charAt(end)) {
        return false;
      }
      start++;
      end--;
    }
    return true;
  }

  private boolean checkFirst(String s) {
    if (s == null || s.isEmpty() || s.length() == 1) {
      return true;
    }
    return false;
  }

  @Test
  public void isPalindromeTest() {
    //A man, a plan, a canal: Panama
    //race a car
    String string = "A man, a plan, a canal: Panama";
    boolean palindromeByReverse = isPalindromeByReverse(string);
    boolean palindromeByTwoPointer = isPalindromeByTwoPointer(string);
    System.out.println(palindromeByReverse);
    System.out.println(palindromeByTwoPointer);
  }


}
