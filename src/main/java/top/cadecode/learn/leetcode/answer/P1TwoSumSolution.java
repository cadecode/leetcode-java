package top.cadecode.learn.leetcode.answer;

import java.util.HashMap;
import java.util.Map;

public class P1TwoSumSolution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        // 使用一个 map 缓存遍历的元素及下标
        // 指定初始容量，避免扩容消耗
        Map<Integer, Integer> hashMap = new HashMap<>(len - 1);
        hashMap.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            // 目标值在 map 中就返回下标
            int another = target - nums[i];
            if (hashMap.containsKey(another)) {
                return new int[]{i, hashMap.get(another)};
            }
            hashMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No solution");
    }
}
