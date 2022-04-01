package com.data.structure.sort;

import java.util.Arrays;

/**
 * 排序
 *
 * @author chenpeng
 */
public class Sorts {

    public static void main(String[] args) {
        int[] array = {3, 4, 5, 2, 1};
        // 冒泡排序
//        bubbleSort(array);
        // 插入排序
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 冒泡排序
     * <p>
     * 从前往后两两比对 每次循环把最大数据移动到末尾 下一次循环减一次
     * 是原地排序法
     * 是稳定排序法
     * 组好情况时间复杂度为O(n) 最坏O(n^2)
     *
     * @param array 要排序的数组
     */
    public static void bubbleSort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            // 提前退出循环标记位
            boolean flag = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = true;
                }
            }
            // 如果第二层循环没有一次进行移动则说明顺序已经排好 第一层的循环可以提前结束了
            if (!flag) {
                break;
            }
        }
    }

    /**
     * 插入排序
     * <p>
     * 是原地排序法
     * 是稳定排序法
     * 组好情况时间复杂度为O(n) 最坏O(n^2)
     *
     * @param array 要排序的数组
     */
    public static void insertSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (array[j] > temp) {
                    // 数据移动
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            // 插入数据
            array[j + 1] = temp;
        }
    }

    /**
     * 选择排序
     * 是原地排序法
     * 不是是稳定排序法
     * 组好情况时间复杂度为O(n) 最坏O(n^2)
     *
     * @param array 要排序的数组
     */
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            // 查找最小的值
            int minIndex = i;
            for (int j = 0; j < array.length; ++j) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // 交换
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    /**
     * 归并排序
     * <p>
     * 分治思想 递归实现
     *
     * @param array 要排序的数组
     */
    public static void mergeSort(int[] array) {

    }

    /**
     * 快速排序
     * 分治和分区 递归实现
     *
     * @param array 要排序的数组
     */
    public static void quicksort(int[] array) {

    }

    /**
     * 计数排序（桶排序）
     * <p>
     * 考生的满分是 900 分，最小是 0 分，这个数据的范围很小，所以我们可以分成 901 个桶，
     * 对应分数从 0 分到 900 分。根据考生的成绩，我们将这 50 万考生划分到这 901 个桶里。
     * 桶内的数据都是分数相同的考生，所以并不需要再进行排序。我们只需要依次扫描每个桶，
     * 将桶内的考生依次输出到一个数组中，就实现了 50 万考生的排序。因为只涉及扫描遍历操作，所以时间复杂度是 O(n)。
     *
     * @param array 要排序的数组
     */
    public static void countSort(int[] array) {

    }

    /**
     * 基数排序
     * @param array 要排序的数组
     */
    public static void radixSort(int[] array) {

    }

    /**
     * 堆排序
     *
     * @param array 要排序的数组
     */
    public static void heapSort(int[] array) {

    }

}
