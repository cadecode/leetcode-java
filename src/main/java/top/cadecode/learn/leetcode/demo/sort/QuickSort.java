package top.cadecode.learn.leetcode.demo.sort;

/**
 * @author Cade Li
 * @date 2022/1/28
 * @description 快排，不稳定（交换时破坏）
 */
public class QuickSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            // 随机取一个元素，换到最后，作为基准
            int randomIdx = l + (int) (Math.random() * (r - l + 1));
            SortTool.swap(arr, randomIdx, r);
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[1] + 1, r);
        }
    }

    public static int[] partition(int[] arr, int l, int r) {
        // r 位置作为基准
        // less 区：小于基准
        int less = l - 1;
        // more 区：大于基准
        int more = r;
        while (l < more) {
            // 小于基准，less 区右扩
            if (arr[l] < arr[r]) {
                SortTool.swap(arr, ++less, l++);
                // 大于基准，more 区左扩
            } else if (arr[l] > arr[r]) {
                SortTool.swap(arr, --more, l);
            } else {
                l++;
            }
        }
        SortTool.swap(arr, more, r);
        // 等于区域的边界
        return new int[]{less + 1, more};
    }
}
