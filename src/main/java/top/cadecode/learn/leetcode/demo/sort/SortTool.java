package top.cadecode.learn.leetcode.demo.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author Cade Li
 * @date 2022/1/27
 * @description 数组交换元素
 */
public class SortTool {

    public static void swap(int[] arr, int i, int j) {
        if (i == j) return;
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void printArr(int[] arr) {
        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
    }
}
