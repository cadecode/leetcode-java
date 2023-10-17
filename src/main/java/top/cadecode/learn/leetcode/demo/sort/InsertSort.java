package top.cadecode.learn.leetcode.demo.sort;

/**
 * @author Cade Li
 * @date 2022/1/27
 * @description 插入排序
 */
public class InsertSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) return;

        // 每一位和前面的元素比较，直到找到自己的位置
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] >= arr[j - 1]) break;
                SortTool.swap(arr, j, j - 1);
            }
        }
    }
}
