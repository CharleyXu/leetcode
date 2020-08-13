package com.xu.algorithm.structure.binary;

import java.text.NumberFormat;

/**
 * Created by CharleyXu on 2020-08-10
 */
public class Sqrts {

    public static String sqrt(float x) {
        float left = 0, right = x, ans = -1;
        while (left <= right) {
            float mid = (left + right) / 2;
            if (mid * mid <= x) {
                ans = mid;
                left = mid + 0.1f;
            } else {
                right = mid - 0.1f;
            }
        }
        NumberFormat numberInstance = NumberFormat.getNumberInstance();
        numberInstance.setMaximumFractionDigits(2);
        numberInstance.setGroupingUsed(false);
        return numberInstance.format(ans);
    }

    public static void main(String[] args) {
        String sqrt = sqrt(21.332f);
        System.out.println(sqrt);
    }
}
