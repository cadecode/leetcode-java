package top.cadecode.learn.leetcode.demo.sort;

/**
 * 基数排序
 *
 * @author Cade Li
 * @since 2024/4/1
 */
public class RadixSort {

    public static void sort(int[] arr) {
        int[] bucket = new int[arr.length];
        // 获取最大的位数
        int maxBits = maxBits(arr);
        // 需要进出桶的次数，代表当前统计的位
        for (int i = 1; i <= maxBits; i++) {
            // 计数器
            int[] counter = new int[10];
            // 统计当前位的数量
            for (int j = 0; j < arr.length; j++) {
                int bit = getBit(arr[j], i);
                counter[bit]++;
            }
            // 前缀和，将统计当前位变成统计小于等于当前位的数量
            for (int j = 1; j < counter.length; j++) {
                counter[j] = counter[j] + counter[j - 1];
            }
            // 入桶出通
            for (int j = arr.length - 1; j >= 0; j--) {
                int bit = getBit(arr[j], i);
                bucket[counter[bit] - 1] = arr[j];
                counter[bit]--;
            }
            // 赋值
            System.arraycopy(bucket, 0, arr, 0, bucket.length);
        }
    }

    public static int maxBits(int[] arr) {
        int maxNum = Integer.MIN_VALUE;
        for (int a : arr) {
            maxNum = Math.max(maxNum, a);
        }
        int bits = 0;
        while (maxNum != 0) {
            maxNum = maxNum / 10;
            bits++;
        }
        return bits;
    }

    public static int getBit(int i, int b) {
        int divisor = (int) Math.pow(10, b - 1);
        return (i / divisor) % 10;
    }
}
