package com.xu.leetcode;

/**
 *  There are two sorted arrays nums1 and nums2 of size m and n respectively.
 	Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).



 那么如何判断两个有序数组A,B中第k大的数呢？
 我们需要判断A[k/2-1]和B[k/2-1]的大小。

 如果A[k/2-1]==B[k/2-1]，那么这个数就是两个数组中第k大的数。

 如果A[k/2-1]<B[k/2-1], 那么说明A[0]到A[k/2-1]都不可能是第k大的数，所以需要舍弃这一半，继续从A[k/2]到A[A.length-1]继续找。
 当然，因为这里舍弃了A[0]到A[k/2-1]这k/2个数，那么第k大也就变成了，第k-k/2个大的数了。

 如果 A[k/2-1]>B[k/2-1]，就做之前对称的操作
 */
public class No4 {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		double result = 0.0;
		int a = nums1.length;
		int b = nums2.length;

		return result;
	}

	public int findKey(int [] arr1,int [] arr2,int key){
		if (arr1.length<=0){
			return arr2[key-1];
		}
		if (arr2.length<=0){
			return arr1[key-1];
		}
		if (key==1){
			Math.min(arr1[0],arr2[0]);
		}


		return  0 ;
	}





}

