package top.cadecode.learn.leetcode.demo.stack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 栈工具类
 *
 * @author Cade Li
 * @since 2024/4/8
 */
public class StackTool {

    /**
     * 单调栈：出栈递增（数组从左到右处理）
     * 获取每个元素对应的后面第一个比它大的元素下标
     */
    public static int[] postLargeElement(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] postLargeArr = new int[nums.length];
        Arrays.fill(postLargeArr, -1);

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                int idx = stack.pop();
                postLargeArr[idx] = i;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            postLargeArr[stack.pop()] = -1;
        }

        return postLargeArr;
    }

    /**
     * 单调栈：出栈递增（数组从右到左处理）
     * 获取每个元素对应的前面第一个比它大的元素下标
     */
    public static int[] prevLargeElementByReversed(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] prevLargeArr = new int[nums.length];
        Arrays.fill(prevLargeArr, -1);

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                int idx = stack.pop();
                prevLargeArr[idx] = i;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            prevLargeArr[stack.pop()] = -1;
        }
        return prevLargeArr;
    }

    /**
     * 单调栈：出栈递增（数组从左到到处理）
     * 获取每个元素对应的前面第一个比它大的元素下标
     */
    public static int[] prevLargeElement(int[] nums) {
        Stack<LinkedList<Integer>> stack = new Stack<>();
        int[] prevLargeArr = new int[nums.length];
        Arrays.fill(prevLargeArr, -1);

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek().peekLast()] < nums[i]) {
                // 栈顶 list
                LinkedList<Integer> topList = stack.pop();
                // 栈顶 list 的上一个 list 的尾部
                int lastIdx = stack.isEmpty() ? -1 : stack.peek().getLast();
                for (Integer idx : topList) {
                    prevLargeArr[idx] = lastIdx;
                }
            }
            // 相等时追加到 list 中
            if (!stack.isEmpty() && nums[stack.peek().peekLast()] == nums[i]) {
                stack.peek().add(i);
                continue;
            }
            LinkedList<Integer> list = new LinkedList<>();
            list.add(i);
            stack.push(list);
        }
        // 清理数组
        while (!stack.isEmpty()) {
            LinkedList<Integer> topList = stack.pop();
            int lastIdx = stack.isEmpty() ? -1 : stack.peek().getLast();
            for (Integer idx : topList) {
                prevLargeArr[idx] = lastIdx;
            }
        }
        return prevLargeArr;
    }
}
