package top.cadecode.learn.leetcode.demo.list;

/**
 * 链表节点
 *
 * @author Cade Li
 * @since 2024/4/1
 */
public class ListNode {

    public int val;

    public ListNode prev;

    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode prev, ListNode next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}
