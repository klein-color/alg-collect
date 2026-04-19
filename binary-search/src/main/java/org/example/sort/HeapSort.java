package org.example.sort;

import java.util.Arrays;

/**
 * 堆排序实现
 * 时间复杂度: O(n log n)
 * 空间复杂度: O(1)
 * 不稳定排序
 */
public class HeapSort {

    /**
     * 堆排序主方法
     * @param arr 待排序数组
     */
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int n = arr.length;

        // 构建最大堆
        // 从最后一个非叶子节点开始，自底向上调整
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // 依次将堆顶元素（最大值）与末尾元素交换，并重新调整堆
        for (int i = n - 1; i > 0; i--) {
            // 交换堆顶和末尾元素
            swap(arr, 0, i);
            // 对剩余元素重新调整为最大堆
            heapify(arr, i, 0);
        }
    }

    /**
     * 调整以 index 为根的子树，使其满足最大堆性质
     * @param arr 数组
     * @param heapSize 堆的大小
     * @param index 当前节点索引
     */
    private static void heapify(int[] arr, int heapSize, int index) {
        int largest = index; // 假设当前节点是最大值
        int left = 2 * index + 1;  // 左子节点
        int right = 2 * index + 2; // 右子节点

        // 如果左子节点大于当前最大值
        if (left < heapSize && arr[left] > arr[largest]) {
            largest = left;
        }

        // 如果右子节点大于当前最大值
        if (right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }

        // 如果最大值不是当前节点，则交换并继续调整
        if (largest != index) {
            swap(arr, index, largest);
            // 递归调整被交换的子树
            heapify(arr, heapSize, largest);
        }
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
        heapSort(arr);
        System.out.println("排序后: " + Arrays.toString(arr));
    }
}
