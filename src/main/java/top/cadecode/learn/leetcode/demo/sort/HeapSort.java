package top.cadecode.learn.leetcode.demo.sort;

import top.cadecode.learn.leetcode.demo.heap.MaxTopHeap;

/**
 * 堆排序
 *
 * @author Cade Li
 * @since 2024/3/26
 */
public class HeapSort {

    public static void sort(int[] arr) {
        MaxTopHeap heap = new MaxTopHeap(arr, 0);
        for (int j : arr) {
            heap.add(j);
        }
        for (int i = 0; i < arr.length; i++) {
            heap.removeTop();
        }
    }
}
