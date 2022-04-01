package com.data.structure.recursion;

import org.junit.jupiter.api.Test;

/**
 * 递归
 *
 * @author chenpeng
 */
public class RecursionTest {

    /**
     * 楼梯 n 个台阶，每次你可以跨 1 个台阶或者 2 个台阶，请问走这 n 个台阶有多少种走法？
     */
    @Test
    public void stairs() {
        System.out.println(3);
    }

    /**
     * 楼梯走法
     *
     * @param n 台阶
     * @return 走法
     */
    private int stairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return stairs(n - 1) + stairs(n - 2);
    }

    /**
     * 电影院第几排
     */
    @Test
    public void row() {
        System.out.println(f(7));
    }

    private int f(int n) {
        if (n == 1) {
            return 1;
        }
        return f(n - 1) + 1;
    }
}
