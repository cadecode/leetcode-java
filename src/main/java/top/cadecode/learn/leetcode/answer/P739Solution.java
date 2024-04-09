package top.cadecode.learn.leetcode.answer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class P739Solution {

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<LinkedList<Integer>> stack = new Stack<>();
        int[] postLargeArr = new int[temperatures.length];
        Arrays.fill(postLargeArr, -1);
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek().getLast()] < temperatures[i]) {
                LinkedList<Integer> topList = stack.pop();
                for (Integer idx : topList) {
                    postLargeArr[idx] = i;
                }
            }
            if (!stack.isEmpty() && temperatures[stack.peek().getLast()] == temperatures[i]) {
                stack.peek().add(i);
                continue;
            }
            LinkedList<Integer> list = new LinkedList<>();
            list.add(i);
            stack.push(list);
        }

        int[] res = new int[temperatures.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = postLargeArr[i] == -1 ? 0 : postLargeArr[i] - i;
        }

        return res;
    }
}
