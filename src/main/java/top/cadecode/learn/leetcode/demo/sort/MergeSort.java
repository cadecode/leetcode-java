package top.cadecode.learn.leetcode.demo.sort;

/**
 * @author Cade Li
 * @date 2022/1/28
 * @description 归并排序
 */
public class MergeSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int l, int r) {
        if (l == r) return;
        // 计算中点，>> 优先级低
        int m = l + ((r - l) >> 1);
        System.out.println(m);
        process(arr, l, m);
        process(arr, m + 1, r);
        merge(arr, l, m, r);
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int[] tmp = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        while (p1 <= m && p2 <= r) {
            tmp[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            tmp[i++] = arr[p1++];
        }
        while (p2 <= r) {
            tmp[i++] = arr[p2++];
        }
        for (int j = 0; j < tmp.length; j++) {
            arr[l + j] = tmp[j];
        }
    }
}
