package top.cadecode.learn.leetcode.answer;

import java.util.Stack;

public class P42Solution {

    public int trap(int[] height) {
        // 单调栈，出栈递增
        Stack<Integer> stack = new Stack<>();
        int res = 0;

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                Integer top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left], height[i]) - height[top];
                res += currWidth * currHeight;

            }
            stack.push(i);
        }

        return res;
    }
}
