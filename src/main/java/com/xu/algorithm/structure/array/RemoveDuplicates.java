package com.xu.algorithm.structure.array;

import java.util.Arrays;
import org.junit.Test;

/**
 * @author CharleyXu Created on 2019/3/17.\
 *
 * 删除数组中的重复项
 */
public class RemoveDuplicates {

  /**
   * 给定一个排序数组，你需要在原地删除重复出现的元素，
   *
   * 使得每个元素只出现一次，返回移除后数组的新长度。
   *
   * 不要使用额外的数组空间，
   *
   * 你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
   */
  private int removeDuplicates(int[] arr) {
    if (arr == null || arr.length < 2) {
      return arr.length;
    }
    int temp = 0;
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] != arr[temp]) {
        temp++;
        arr[temp] = arr[i];
      }
    }
    System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 0, temp + 1)));
    return temp + 1;

  }

  /**
   * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，
   *
   * 返回移除后数组的新长度。 不要使用额外的数组空间，
   *
   * 你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成
   */
  private int removeDuplicatesTwoElement(int[] arr) {
    if (arr == null || arr.length < 1) {
      return 0;
    }
    if (arr.length <= 2) {
      return arr.length;
    }
    int len = 0;
    int flag = 1;
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] == arr[len]) {
        flag++;
      } else {
        flag = 1;
      }
      if (flag <= 2) {
        len++;
        arr[len] = arr[i];
      }
    }
    System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 0, len + 1)));
    return len + 1;
  }

  @Test
  public void removeDuplicatesTest() {
    int[] arr = new int[]{1, 2, 2, 2, 3, 4, 5, 5, 5, 6};
    int[] ints = Arrays.copyOf(arr, arr.length);
    int num = removeDuplicates(arr);
    System.out.println(num);
    int result = removeDuplicatesTwoElement(ints);
    System.out.println(result);
  }
}
