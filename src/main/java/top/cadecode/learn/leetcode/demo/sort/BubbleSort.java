package top.cadecode.learn.leetcode.demo.sort;

/**
 * @author Cade Li
 * @date 2022/1/27
 * @description 冒泡排序
 */
public class BubbleSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) return;

        // 从每一位开始，向后两两比较
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    SortTool.swap(arr, i, j);
                }
            }
        }
    }
}
