package com.xu.algorithm.other;

import java.util.Arrays;

/**
 * Created by CharleyXu on 2020-06-09
 * <p>
 * 三角形的最大周长
 */
public class LargestPerimeter {

    public int largestPerimeter(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; i--) {
            if (A[i - 1] + A[i - 2] > A[i]) {
                return A[i - 1] + A[i - 2] + A[i];
            }
        }
        return 0;
    }
}
