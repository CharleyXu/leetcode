package com.xu.algorithm.structure.binary;

import org.junit.Test;

import java.text.NumberFormat;

/**
 * Created by CharleyXu on 2020-08-10
 * <p>
 * 求平方根，结果精确到0.01
 */
public class Sqrts {

    private String sqrt(float x) {
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

    @Test
    public void sqrtTest() {
        System.out.println(sqrt(21.332f));
        System.out.println(sqrt(481.332f));
    }
}
