package top.cadecode.learn.leetcode.answer;

import java.util.Arrays;
import java.util.HashSet;

public class P128Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            set.add(num);
        }

        int maxLen = 0;

        for (int num : set) {
            // 只要检查 num - 1，不存在，说明是没有检查过的
            if (!set.contains(num - 1)) {
                int currNum = num;
                int len = 1;

                while (set.contains(currNum + 1)) {
                    currNum++;
                    len++;
                }
                maxLen = Math.max(maxLen, len);
            }
        }

        return maxLen;
    }

    public int longestConsecutive2(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);

        int maxLen = 1;
        int currLen = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] == nums[i - 1] + 1) {
                currLen++;
            } else {
                maxLen = Math.max(maxLen, currLen);
                currLen = 1;
            }
        }
        return Math.max(maxLen, currLen);
    }
}
