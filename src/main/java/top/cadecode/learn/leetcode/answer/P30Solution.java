package top.cadecode.learn.leetcode.answer;

import java.util.*;

public class P30Solution {

    public List<Integer> findSubstring(String s, String[] words) {
        int len = s.length();
        List<Integer> res = new ArrayList<>();
        // 计算总长度，收集出现次数到 map 中
        int wordsLen = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            wordsLen += word.length();
            map.put(word, map.get(word) == null ? 1 : map.get(word) + 1);
        }
        if (len < wordsLen || wordsLen == 0) return res;
        int wordLen = words[0].length();
        // 滑动窗口
        int k = 0;
        while (k + wordsLen - 1 < len) {
            String substr = s.substring(k, k + wordsLen);
            Map<String, Integer> temp = new HashMap<>();
            for (int i = 0; i < substr.length(); i++) {
                // 截取单元
                String sub = substr.substring(i, i + wordLen);
                // 不在 map 中就跳出
                if (map.get(sub) == null) break;
                // 加到 temp 中
                if (temp.get(sub) == null) {
                    temp.put(sub, 1);
                } else {
                    if (temp.get(sub) >= map.get(sub)) break;
                    temp.put(sub, temp.get(sub) + 1);
                }
                // 定位到下一个单元
                i += wordLen - 1;
            }
            if (temp.equals(map)) res.add(k);
            k++;
        }

        return res;
    }

}
