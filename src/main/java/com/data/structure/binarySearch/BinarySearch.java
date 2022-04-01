package com.data.structure.binarySearch;

/**
 * 二分查找
 *
 * @author chenpeng
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        System.out.println(binarySearch(array, 5));
    }

    public static int binarySearch(int[] array, int value) {
        // 低
        int low = 0;
        // 高
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] == value) {
                return mid;
            } else if (array[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int recursionBinarySearch(int[] a, int low, int high, int value) {
        if (low > high) {
            return -1;
        }

        int mid = low + ((high - low) >> 1);
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] < value) {
            return recursionBinarySearch(a, mid + 1, high, value);
        } else {
            return recursionBinarySearch(a, low, mid - 1, value);
        }
    }
}
