package top.cadecode.learn.leetcode.answer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P36Solution {
    public boolean isValidSudoku(char[][] board) {
        // 初始化列容器
        Map<Integer, Set<Character>> colMap = new HashMap<>();
        // 初始化宫容器
        Map<String, Set<Character>> squMap = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            char[] chars = board[i];
            // 初始化行容器
            Set<Character> row = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                // 初始化列容器
                colMap.putIfAbsent(j, new HashSet<>());
                // 初始化宫容器（难点，根据左边找到宫的左上位，用作哈希键）
                String squKey = (i - i % 3) + "" + (j - j % 3);
                squMap.putIfAbsent(squKey, new HashSet<>());
                // 判断是否空格
                if (chars[j] == '.') continue;
                // 判断该行有没有重复
                if (row.contains(chars[j])) return false;
                row.add(chars[j]);
                // 判断该列有没有重复
                if (colMap.get(j).contains(chars[j])) return false;
                colMap.get(j).add(chars[j]);
                // 判断该宫有没有重复
                if (squMap.get(squKey).contains(chars[j])) return false;
                squMap.get(squKey).add(chars[j]);
            }
        }
        return true;
    }
}
