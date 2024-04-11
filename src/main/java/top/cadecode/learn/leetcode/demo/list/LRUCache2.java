package top.cadecode.learn.leetcode.demo.list;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * 基于 LinkHashMap
 *
 * @author Cade Li
 * @since 2024/4/11
 */
public class LRUCache2 extends LinkedHashMap<Integer, Integer> {

    int myCapacity;

    public LRUCache2(int capacity) {
        super(16, 0.75F, true);
        this.myCapacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Entry<Integer, Integer> eldest) {
        return size() > myCapacity;
    }

    @Override
    public Integer get(Object key) {
        Integer i = super.get(key);
        return i == null ? -1 : i;
    }
}
