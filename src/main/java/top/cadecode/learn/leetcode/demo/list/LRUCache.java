package top.cadecode.learn.leetcode.demo.list;

import java.util.HashMap;

public class LRUCache {

    public int capacity;
    public ListNode head = new ListNode(-1);
    public ListNode tail = new ListNode(-1);
    public HashMap<Integer, ListNode> keyNodeMap;
    public HashMap<ListNode, Integer> nodeKeyMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.keyNodeMap = new HashMap<>(capacity);
        this.nodeKeyMap = new HashMap<>(capacity);
        // 哨兵节点
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!keyNodeMap.containsKey(key)) {
            return -1;
        }
        ListNode node = keyNodeMap.get(key);
        // 踢出原位置
        node.prev.next = node.next;
        node.next.prev = node.prev;
        // 加在队尾
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
        node.next = tail;
        return node.val;
    }

    public void put(int key, int value) {
        // 已经在链表中
        if (keyNodeMap.containsKey(key)) {
            keyNodeMap.get(key).val = value;
            get(key);
            return;
        }
        // 链表已满，移除 head 下一节点
        if (keyNodeMap.size() == capacity) {
            // 清理 map
            keyNodeMap.remove(nodeKeyMap.get(head.next));
            nodeKeyMap.remove(head.next);
            head.next.prev = null;
            head.next.next.prev = head;
            head.next = head.next.next;
        }
        // 链表未满，加在队尾
        ListNode node = new ListNode(value);
        // 插在 tail 和上一节点间
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
        node.next = tail;
        keyNodeMap.put(key, node);
        nodeKeyMap.put(node, key);
    }
}
