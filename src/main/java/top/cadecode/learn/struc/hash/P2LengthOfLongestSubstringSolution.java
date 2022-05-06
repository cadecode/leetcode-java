package top.cadecode.learn.struc.hash;

import java.util.HashMap;
import java.util.Map;

public class P2LengthOfLongestSubstringSolution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        // 处理特殊情况：空串和一个字符
        if (len <= 1) return len;
        Map<Character, Integer> cache = new HashMap<>();
        int max = 0, left = 0, right = 0;
        while (right < len) {
            char c = s.charAt(right);
            // 判断是否缓存过该字符，其该字符在当前窗口内
            if (cache.containsKey(c) && cache.get(c) >= left) {
                // 向左滑动窗口
                left = cache.get(c) + 1;
            }
            // 缓存字符和索引
            cache.put(c, right);
            // 比较大小，此时保证索引 left 到 right 不重复
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}
