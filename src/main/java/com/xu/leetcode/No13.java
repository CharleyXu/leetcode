package com.xu.leetcode;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

/**
 * Roman to Integer Created by charlie on 2017/12/13.
 */
public class No13 {

  public int romanToInt(String s) {
    Map<Character, Integer> map = new HashMap<>();
    map.put('I', 1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('L', 50);
    map.put('C', 100);
    map.put('D', 500);
    map.put('M', 1000);
    int sum = 0;
    int len = s.length();
    if (len <= 0) {
      return sum;
    }
    sum = map.get(s.charAt(len - 1));

    for (int i = len - 2; i >= 0; i--) {
      if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
        sum -= map.get(s.charAt(i));
      } else {
        sum += map.get(s.charAt(i));
      }
    }
    return sum;
  }

  @Test
  public void test(){
    String s = "MXIV";
    System.out.println(romanToInt(s));
  }
}
