package org.example.sort;

import java.util.Arrays;

/**
 * 快速排序实现
 * 时间复杂度: 平均 O(n log n), 最坏 O(n²)
 * 空间复杂度: O(log n)
 * 不稳定排序
 */
public class QuickSort {

    /**
     * 快速排序主方法
     * @param arr 待排序数组
     */
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * 递归快速排序
     * @param arr 数组
     * @param low 起始索引
     * @param high 结束索引
     */
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 获取分区点
            int pivotIndex = partition(arr, low, high);
            // 递归排序左右两部分
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    /**
     * 分区操作，将数组分为小于基准和大于基准的两部分
     * @param arr 数组
     * @param low 起始索引
     * @param high 结束索引
     * @return 基准元素的最终位置
     */
    private static int partition(int[] arr, int low, int high) {
        // 选择最后一个元素作为基准
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // 交换 arr[i] 和 arr[j]
                swap(arr, i, j);
            }
        }
        // 将基准元素放到正确位置
        swap(arr, i + 1, high);
        return i + 1;
    }

    /**
     * 交换数组中两个元素
     */
    private static void swap(int[] arr, int i, int j) {
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("排序前: " + Arrays.toString(arr));
        quickSort(arr);
        System.out.println("排序后: " + Arrays.toString(arr));
    }
}
