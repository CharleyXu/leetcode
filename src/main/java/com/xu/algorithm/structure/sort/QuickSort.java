package com.xu.algorithm.structure.sort;

import org.junit.Test;

/**
 * @author CharleyXu Created on 2019/3/10.
 * <p>
 * 快速排序
 * <p>
 * 基本思想：挖坑填数+分治法(partition)
 * <p>
 * 选一个轴值(pivot，也有叫基准的)，通过一趟排序将待排记录分隔成独立的两部分，
 * <p>
 * 其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序
 */
public class QuickSort extends BaseSort {

    public void quickSort(int[] arr) {
        if (arr == null || arr.length == 0 || arr.length == 1) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int i = partition(arr, low, high);
        //基准左边再做排序，直到左边剩下一个数(递归出口)
        quickSort(arr, low, i - 1);
        //右边
        quickSort(arr, i + 1, high);
    }

    private int partition(int[] arr, int low, int high) {
        //挖坑1,保存基准值
        int pivot = arr[low];
        //左右两端进行扫描
        while (low < high) {
            //坑2：从后向前找到比基准小的元素，插入到基准位置坑1中
            while (low < high && arr[high] >= pivot) {
                high--;
            }
            arr[low] = arr[high];
            //坑3：从前往后找到比基准大的元素，放到刚才挖的坑2中
            while (low < high && arr[low] <= pivot) {
                low++;
            }
            arr[high] = arr[low];
        }
        //基准值填补到坑3中，准备分治递归快排
        arr[low] = pivot;
        return low;
    }

    @Test
    public void quickSortTest() {
        int[] arr = new int[]{24, 17, 87, 35, 19, 7, 85, 61, 47, 50};
        quickSort(arr);
        printArr(arr);
    }

    @Test
    public void quicksSortTest() {
        int[] arr = new int[]{24, 17, 87, 35, 19, 7, 85, 61, 47, 50};
        quicks(arr);
        printArr(arr);
    }

    public void quicks(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        quicks(arr, 0, arr.length - 1);
    }

    private void quicks(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int partitions = partitions(arr, low, high);
        quicks(arr, low, partitions - 1);
        quicks(arr, partitions + 1, high);
    }

    /**
     * @return 轴值 位置
     */
    private int partitions(int[] arr, int low, int high) {
        // 1
        int pivot = arr[low];
        while (low < high) {
            // 2
            while (low < high && arr[high] >= pivot) {
                high--;
            }
            arr[low] = arr[high];
            // 3
            while (low < high && arr[low] <= pivot) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }

}
