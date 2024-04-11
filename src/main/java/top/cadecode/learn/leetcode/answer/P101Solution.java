package top.cadecode.learn.leetcode.answer;

import top.cadecode.learn.leetcode.demo.tree.TreeNode;

public class P101Solution {
    public boolean isSymmetric(TreeNode root) {
        return process(root, root);
    }

    public boolean process(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        return process(node1.left, node2.right) && process(node1.right, node2.left) && node1.val == node2.val;
    }
}
