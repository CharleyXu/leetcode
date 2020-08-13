package com.xu.algorithm.structure.string;

import org.junit.Test;

/**
 * @author CharleyXu Created on 2019/3/14.
 *
 * 反转字符串
 */
public class ReverseString {

  /**
   * 1. 直接倒序拼接,栈的先入后出, new StringBuilder(string).reverse().toString()   时间复杂度 O(n) 空间复杂度O(n)
   *
   * 2.折半交换,时间复杂度O(lgn) 空间复杂度O(n)
   */
  public String reverseBinaryString(String string) {
    if (string == null || string.isEmpty()) {
      throw new NullPointerException();
    }
    char[] chars = string.toCharArray();
    int end = chars.length - 1;
    int start = 0;
    while (start < end) {
      if (chars[start] != chars[end]) {
        swap(chars, start, end);
      }
      start++;
      end--;
    }
    return new String(chars);
  }

  /**
   * 递归，分而治之,时间复杂度：O(n), 空间复杂度：O(1)
   */
  public String recursiveReverseString(String string) {
    if (string == null || string.isEmpty()) {
      throw new NullPointerException();
    }
    int len = string.length();
    if (len == 1) {
      return string;
    }
    String left = string.substring(0, len / 2);
    String right = string.substring(len / 2, len);
    return recursiveReverseString(right) + recursiveReverseString(left);
  }

  private void swap(char[] chars, int low, int high) {
    char temp = chars[low];
    chars[low] = chars[high];
    chars[high] = temp;
  }

  @Test
  public void reverseStringTest() {
    String string = "A, cat ,E";
    String result = reverseBinaryString(string);
    System.out.println(result);
  }

  @Test
  public void recursiveReverseStringTest() {
    String string = "QWERT12,";
    String result = recursiveReverseString(string);
    System.out.println(result);
  }

}
