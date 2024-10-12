package top.cadecode.learn.leetcode.demo.sort;

/**
 * @author Cade Li
 * @date 2022/1/27
 * @description 冒泡排序
 */
public class BubbleSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) return;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    SortTool.swap(arr, j, j - 1);
                }
            }
        }
    }
}
