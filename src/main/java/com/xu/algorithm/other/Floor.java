package com.xu.algorithm.other;

import org.junit.Test;

/**
 * @author charlie Created on 2018/2/6.
 * <p>
 * 台阶问题
 * 斐布那契数列
 */
public class Floor {

    /**
     * DP 动态规划
     * <p>
     * 基于变量形式实现
     */
    public int fun(int num) {
        if (num < 1) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        if (num == 2) {
            return 2;
        }
        int a = 1, b = 2, temp = 0;
        for (int i = 3; i <= num; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return temp;
    }

    /**
     * 朴素递归
     */
    public int fibonacci(int num) {
        if (num <= 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        if (num == 2) {
            return 2;
        }
        return fibonacci(num - 1) + fibonacci(num - 2);
    }

    @Test
    public void test() {
        int fun = fun(10);
        int fibonacci = fibonacci(10);
        System.out.println(fun);
        System.out.println(fibonacci);
    }

}
