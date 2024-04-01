package top.cadecode.learn.leetcode;

import top.cadecode.learn.leetcode.demo.list.ListNode;
import top.cadecode.learn.leetcode.demo.tree.TreeNode;
import top.cadecode.learn.leetcode.demo.tree.TreeTool;

import java.util.HashMap;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(4);
        ListNode ln5 = new ListNode(5);
        ListNode ln6 = new ListNode(6);
        ln1.nextNode = ln2;
        ln2.nextNode = ln3;
        ln3.nextNode = ln4;
        ln4.nextNode = ln5;
        ln5.nextNode = ln6;
        ln6.nextNode = ln5;

        TreeNode tn1 = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);
        TreeNode tn4 = new TreeNode(4);
        TreeNode tn5 = new TreeNode(5);
        TreeNode tn6 = new TreeNode(6);
        tn1.left = tn2;
        tn1.right = tn3;
        tn2.left = tn4;
        tn2.right = tn5;
        tn3.left = tn6;

        HashMap<TreeNode, Integer> map = TreeTool.layerPrint(tn1);
       map.forEach((k,v) -> {
           System.out.println(k.value + "," + v);
       });
    }
}
