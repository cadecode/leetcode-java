package top.cadecode.learn.leetcode.answer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P295MedianFinder {

    private PriorityQueue<Integer> qMin = new PriorityQueue<>(Comparator.reverseOrder());
    private PriorityQueue<Integer> qMax = new PriorityQueue<>();

    public P295MedianFinder() {
    }

    public void addNum(int num) {
        if (qMin.isEmpty() || num <= qMin.peek()) {
            qMin.offer(num);
            if (qMin.size() > qMax.size() + 1) {
                qMax.offer(qMin.poll());
            }
        } else {
            qMax.offer(num);
            if (qMax.size() > qMin.size()) {
                qMin.offer(qMax.poll());
            }
        }
    }

    public double findMedian() {
        if (qMin.size() > qMax.size()) {
            return qMin.peek();
        }
        return (qMin.peek() + qMax.peek()) / 2.0;
    }
}
