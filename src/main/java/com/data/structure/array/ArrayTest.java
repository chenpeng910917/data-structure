package com.data.structure.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 数组例子
 *
 * @author chenpeng
 */
public class ArrayTest {
    public static void main(String[] args) {
        // 实例化一个int类型空间大小为10的数组
        int[] array = new int[10];
        // 给数组第一位赋值为0
        array[0] = 0;

        // 初始化一个int类型数组 并为其赋值
        int[] array1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(array[0]);
        // 打印引用地址
        System.out.println(array1);
        // 打印数组
        System.out.println(Arrays.toString(array1));
    }

    /**
     * 数组越界
     * java.lang.ArrayIndexOutOfBoundsException
     */
    @Test
    public void arrayBounds() {
        int[] arr = new int[3];
        arr[3] = 10;
        System.out.println(Arrays.toString(arr));
    }
}
