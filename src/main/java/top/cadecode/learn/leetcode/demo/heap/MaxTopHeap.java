package top.cadecode.learn.leetcode.demo.heap;

/**
 * 大顶堆
 *
 * @author Cade Li
 * @since 2024/3/25
 */
public class MaxTopHeap {

    private final int[] arr;
    private int heapSize;

    public MaxTopHeap(int[] arr, int heapSize) {
        this.arr = arr;
        this.heapSize = heapSize;
    }

    /**
     * 加入新数，返回最终确定的 index
     */
    public int add(int val) {
        // 加入新数
        arr[heapSize] = val;
        heapSize++;
        return heapInsert(arr, heapSize - 1);
    }

    /**
     * 删除并返回顶数
     */
    public int removeTop() {
        int top = arr[0];
        swap(arr, 0, heapSize - 1);
        heapSize--;
        heapify(arr, 0, heapSize);
        return top;
    }

    public int[] getArr() {
        return arr;
    }

    public int getHeapSize() {
        return heapSize;
    }

    /**
     * 当一个数在 index 上，尝试向上调整
     * 反正最后确定的 index
     */
    public static int heapInsert(int[] arr, int index) {
        // 计算
        int pIndex = (index - 1) / 2;
        while (arr[index] > arr[pIndex]) {
            swap(arr, index, pIndex);
            index = pIndex;
            pIndex = (pIndex - 1) / 2;
        }
        return pIndex;
    }

    /**
     * 当一个数在 index 上，尝试向下调整
     * 反正最后确定的 index
     */
    public static int heapify(int[] arr, int index, int heapSize) {
        // 左孩子
        int left = 2 * index + 1;
        while (left < heapSize) {
            int maxChildIndex = left;
            // 比较左右孩子
            if (left + 1 < heapSize) {
                maxChildIndex = arr[left + 1] > arr[left] ? left + 1 : left;
            }
            // 比较父和大孩子
            int largestIndex = arr[maxChildIndex] > arr[index] ? maxChildIndex : index;
            if (largestIndex == index) {
                break;
            }
            swap(arr, index, largestIndex);
            index = largestIndex;
            left = 2 * index + 1;
        }
        return index;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 0 1 2 3 4 5 6
     *    0
     * 1    2
     * 3 4  5 6
     */
    public static void printArrAsTree(int[] arr, int heapSize) {
        int layer = 1;
        for (int i = 0; i < heapSize; i++) {
            if (i == (int) Math.pow(2, layer) - 1) {
                layer++;
                System.out.println();
            }
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
