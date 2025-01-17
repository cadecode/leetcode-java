package top.cadecode.learn.leetcode.demo.sort;

/**
 * @author Cade Li
 * @date 2022/1/27
 * @description 选择排序，不稳定（交换时破环）
 */
public class SelectSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) return;

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] > arr[minIndex] ? minIndex : j;
            }
            if (minIndex != i) {
                SortTool.swap(arr, i, minIndex);
            }
        }
    }
}
