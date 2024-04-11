package top.cadecode.learn.leetcode.answer;

import java.util.HashSet;

public class P3Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;
        char[] chars = s.toCharArray();
        int maxLen = 0;
        int left = 0;
        int right = 0;
        HashSet<Character> set = new HashSet<>();

        while (right < chars.length) {
            char currC = chars[right];
            if (!set.contains(currC)) {
                set.add(currC);
                right++;
                continue;
            }
            maxLen = Math.max(maxLen, right - left);
            set.remove(chars[left]);
            left++;
        }

        return Math.max(maxLen, right - left);
    }
}
