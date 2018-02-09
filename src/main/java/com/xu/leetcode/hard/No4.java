package com.xu.leetcode.hard;

import org.junit.Test;

/**
 *  There are two sorted arrays nums1 and nums2 of size m and n respectively.
 	Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

 那么-？
 我们需要判断A[k/2-1]和B[k/2-1]的大小。

 如果A[k/2-1]==B[k/2-1]，那么这个数就是两个数组中第k大的数。

 如果A[k/2-1]<B[k/2-1], 那么说明A[0]到A[k/2-1]都不可能是第k大的数，所以需要舍弃这一半，继续从A[k/2]到A[A.length-1]继续找。
 当然，因为这里舍弃了A[0]到A[k/2-1]这k/2个数，那么第k大也就变成了，第k-k/2个大的数了。

 如果 A[k/2-1]>B[k/2-1]，就做之前对称的操作
 */
public class No4 {
	public static double findMedianSortedArrays(int A[], int B[]) {
		int m = A.length;
		int n = B.length;
		int total = m+n;
		if (total % 2 != 0) {
			return (double) findKth(A, 0, m - 1, B, 0, n - 1, total / 2 + 1);//k传得是第k个，index实则k-1
		} else {
			double x = findKth(A, 0, m-1, B, 0, n-1, total/2);//k传得是第k个，index实则k-1
			double y = findKth(A, 0, m-1, B, 0, n-1, total/2+1);//k传得是第k个，index实则k-1
			return (double)(x+y)/2;
		}
	}

	public static int findKth(int[] A, int aStart, int aEnd, int[] B, int bStart, int bEnd, int k) {
		int m = aEnd - aStart + 1;
		int n = bEnd - bStart + 1;
		if (m > n) {
			return findKth(B, bStart, bEnd, A, aStart, aEnd, k);
		}
		if (m == 0) {
			return B[k - 1];
		}
		if (k == 1) {
			return Math.min(A[aStart], B[bStart]);
		}
		// m<=n 即 A.length <= B.length 时

		int partA = Math.min(k/2,m);
		int partB = k - partA;
		if (A[aStart + partA - 1] < B[bStart + partB - 1]) {
			return findKth(A, aStart + partA, aEnd, B, bStart, bEnd, k - partA);
		} else if (A[aStart + partA - 1] > B[bStart + partB - 1]) {
			return findKth(A, aStart, aEnd, B, bStart + partB, bEnd, k - partB);
		} else {
			return A[aStart + partA - 1];
		}
	}

	@Test
	public void test(){
		int [] A = {1,7,9,13,67};
		int [] B = {4,10,15,22,89};
		double medianSortedArrays = findMedianSortedArrays(A, B);
		System.out.println("result:"+medianSortedArrays);
	}

}

