package top.cadecode.learn.leetcode.answer;

import java.util.Objects;
import java.util.Stack;

public class P155MinStack {

    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();

    public void push(int val) {
        stack.push(val);
        if (!min.isEmpty() && val > min.peek()) {
            return;
        }
        min.push(val);
    }

    public void pop() {
        Integer pop = stack.pop();
        if(Objects.equals(pop, min.peek())) {
           min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
