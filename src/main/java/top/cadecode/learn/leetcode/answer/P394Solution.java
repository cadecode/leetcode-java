package top.cadecode.learn.leetcode.answer;

import java.util.Stack;

public class P394Solution {

    public String decodeString(String s) {
        if (s == null || s.isEmpty()) return "";
        Stack<Character> stack = new Stack<Character>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c != ']') {
                stack.push(c);
                continue;
            }
            int len = 0;
            // 获取字母
            StringBuilder wordSb = new StringBuilder();
            while (!stack.isEmpty() && stack.peek() != '[') {
                wordSb.insert(0, stack.pop());
                len++;
            }
            // 取出 [
            stack.pop();
            len++;
            // 获取数字
            StringBuilder numSb = new StringBuilder();
            while (!stack.isEmpty() && 48 <= stack.peek() && stack.peek() <= 57) {
                numSb.insert(0, stack.pop());
                len++;
            }
            int num = Integer.parseInt(numSb.toString());
            char[] wordCharArr = wordSb.toString().toCharArray();
            for (int j = 0; j < num; j++) {
                for (char wc : wordCharArr) {
                    stack.push(wc);
                }
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }
        return res.toString();
    }

}
