package top.cadecode.learn.leetcode.demo.list;

/**
 * 链表工具类
 *
 * @author Cade Li
 * @since 2024/4/1
 */
public class ListTool {

    public static void printList(ListNode head) {
        if (isLoop(head)) {
            System.out.println("Loop can not print!");
        }
        System.out.print(head.val + " -> ");
        while (head.next != null) {
            System.out.print(head.next.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static boolean isLoop(ListNode head) {
        ListNode s = head;
        ListNode q = head;
        while (q.next != null && q.next.next != null) {
            s = s.next;
            q = q.next.next;
            // 快慢相遇在环上
            if (s == q) {
                return true;
            }
        }
        return false;
    }

    public static ListNode getLoopNode(ListNode head) {
        ListNode s = head;
        ListNode q = head;
        while (q.next != null && q.next.next != null) {
            s = s.next;
            q = q.next.next;
            // 快慢相遇在环上
            if (s == q) {
                // 慢2号 重头出发，s 也开始走，二者必相遇在入环节点
                ListNode s2 = head;
                while (s2 != null) {
                    s2 = s2.next;
                    s = s.next;
                    if (s2 == s) {
                        return s;
                    }
                }
            }
        }
        return null;
    }

    public static ListNode getMidNode(ListNode head) {
        ListNode s = head;
        ListNode q = head;
        while (q.next != null && q.next.next != null) {
            s = s.next;
            q = q.next.next;
        }
        return s;
    }
}
