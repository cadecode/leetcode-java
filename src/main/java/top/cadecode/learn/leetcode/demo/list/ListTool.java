package top.cadecode.learn.leetcode.demo.list;

/**
 * 链表工具类
 *
 * @author Cade Li
 * @since 2024/4/1
 */
public class ListTool {

    public static void printList(ListNode node) {
        if (isLoop(node)) {
            System.out.println("Loop can not print!");
        }
        System.out.print(node.value + " -> ");
        while (node.nextNode != null) {
            System.out.print(node.nextNode.value + " -> ");
            node = node.nextNode;
        }
        System.out.println("null");
    }

    public static boolean isLoop(ListNode node) {
        ListNode s = node;
        ListNode q = node;
        while (q.nextNode != null && q.nextNode.nextNode != null) {
            s = s.nextNode;
            q = q.nextNode.nextNode;
            // 快慢相遇在环上
            if (s == q) {
                return true;
            }
        }
        return false;
    }

    public static ListNode getLoopNode(ListNode node) {
        ListNode s = node;
        ListNode q = node;
        while (q.nextNode != null && q.nextNode.nextNode != null) {
            s = s.nextNode;
            q = q.nextNode.nextNode;
            // 快慢相遇在环上
            if (s == q) {
                // 慢2号 重头出发，s 也开始走，二者必相遇在入环节点
                ListNode s2 = node;
                while (s2 != null) {
                    s2 = s2.nextNode;
                    s = s.nextNode;
                    if (s2 == s) {
                        return s;
                    }
                }
            }
        }
        return null;
    }

    public static ListNode getMidNode(ListNode node) {
        ListNode s = node;
        ListNode q = node;
        while (q.nextNode != null && q.nextNode.nextNode != null) {
            s = s.nextNode;
            q = q.nextNode.nextNode;
        }
        return s;
    }
}
