package top.cadecode.learn.leetcode.answer;


import java.util.*;

public class P438Solution {

    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> res = new ArrayList<>();
        int pLen = p.length();
        if (s.length() < pLen) return res;
        // 窗口指针
        int left = 0;
        int right = left + pLen - 1;
        // p 字符 set
        Set<Character> pSet = new HashSet<>();
        char[] pChars = p.toCharArray();
        for (char c : pChars) {
            pSet.add(c);
        }
        char[] sChars = s.toCharArray();
        while (right < sChars.length) {
            // 检查区间字符
            char[] tempChars = new char[p.length()];
            for (int i = left, j = 0; i <= right; i++, j++) {
                tempChars[j] = sChars[i];
                if (!pSet.contains(sChars[i])) {
                    left = i + 1;
                }
            }
            if (left + pLen - 1 == right) {
                // 当检查出没有格外字符，比对子串
                if (Arrays.equals(tempChars, pChars)) {
                    res.add(left);
                }
                left++;
                right++;
            } else {
                right = left + pLen - 1;
            }
        }

        return res;
    }
}
