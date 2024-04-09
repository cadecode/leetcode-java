package top.cadecode.learn.leetcode.answer;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class P20Solution {

    Map<Character, Character> charMap = new HashMap<Character, Character>() {{
        put(')', '(');
        put(']', '[');
        put('}', '{');
    }};

    public boolean isValid(String s) {
        // 判断空、偶数个字符
        if (s.isEmpty() || s.length() % 2 != 0) return false;
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (char c : chars) {
            // 遇到左括号入栈
            if (charMap.containsValue(c)) {
                stack.push(c);
                continue;
            }
            // 不是左括号时，必有右括号
            if (stack.isEmpty()) return false;
            // 取栈顶比较匹配
            Character left = stack.pop();
            if (charMap.get(c) != left) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
