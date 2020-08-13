package com.xu.algorithm.structure.string;

import java.util.Arrays;
import java.util.Collections;
import org.junit.Test;

/**
 * 反转字符串里的单词
 *
 * @author CharleyXu Created on 2019/3/17.
 */
public class ReverseWords {

  /**
   * split + Collections.reverse()
   *
   * 时间复杂度O(n)  空间复杂度O(n)
   */
  private String reverseWords(String string) {
    if (string == null || string.isEmpty() || string.length() == 1) {
      return string;
    }
    //trim()是为了去掉前导或尾随空格
    //split():这是正则表达式。+表示至少1，所以在这种情况下，" +"意味着至少有一个空格
    String[] split = string.trim().split(" +");
    Collections.reverse(Arrays.asList(split));
    return String.join(" ", split);
  }

  /**
   * 先将整个字符串的字符反转，再将单个词的字符反转
   *
   * 去多余的空格、字符串反转、单词反转
   */
  private String reverseWords2(String string) {
    if (string == null || string.isEmpty() || string.length() == 1) {
      return string;
    }
    char[] chars = delExtraSpaces(string).toCharArray();
    reverseArray(chars, 0, chars.length - 1);
    reverseWord(chars, chars.length);
    return new String(chars);
  }

  private void reverseArray(char[] chars, int i, int j) {
    while (i < j) {
      char temp = chars[i];
      chars[i++] = chars[j];
      chars[j--] = temp;
    }
  }

  private String delExtraSpaces(String string) {
    char[] chars = string.trim().toCharArray();
    String result = "";
    int start = 0, end = chars.length;
    while (start < end) {
      if (chars[start] != ' ') {
        result += chars[start++];
      } else {
        result += " ";
        while (chars[start] == ' ') {
          start++;
        }
      }
    }
    return result;
  }

  /**
   * 找到单词的起始结束位置
   */
  private void reverseWord(char[] chars, int end) {
    int i = 0, j = 0;
    while (i < end) {
      // skip spaces
      while (i < j || i < end && chars[i] == ' ') {
        i++;
      }
      // skip no spaces
      while (j < i || j < end && chars[j] != ' ') {
        j++;
      }
      // reverse
      reverseArray(chars, i, j - 1);
    }
  }

  @Test
  public void reverseWordsTest() {
    String string = "This  is a classroom";
    String s = reverseWords2(string);
    System.out.println(s);
  }

}
