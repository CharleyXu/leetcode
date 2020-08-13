package com.xu.algorithm.structure.sort;

import org.junit.Test;

/**
 * @author CharleyXu Created on 2019/3/12.
 *
 * 插入排序
 *
 * 基本思想是：将数组中的所有元素依次跟前面已经排好的元素相比较，
 *
 * 如果选择的元素比已排序的元素小，则交换，直到全部元素都比较过为止
 */
public class InsertionSort extends BaseSort {

  private void insertionSort(int[] arr) {
    checkFirst(arr);
    for (int i = 1; i < arr.length; i++) {
      int key = arr[i];
      int j = i - 1;
      while (j >= 0 && arr[j] > key) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = key;
    }
  }

  @Test
  public void insertionSortTest() {
    int[] arr = new int[]{24, 17, 87, 35, 19, 7, 85, 61, 47, 50, 4, 72};
    insertionSort(arr);
    printArr(arr);
  }

  /**
   * 时间复杂度：平均：O(n^2)、最坏：O(n^2)、最优：O(n)。
   * 空间复杂度：O(1)
   *
   * 最好情况，比较次数(KCN)：n−1；移动次数(RMN)为0。则对应的时间复杂度为O(n)。
   */

}
