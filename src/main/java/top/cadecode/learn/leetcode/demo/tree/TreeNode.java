package top.cadecode.learn.leetcode.demo.tree;

/**
 * 二叉树树节点
 *
 * @author Cade Li
 * @since 2024/4/1
 */
public class TreeNode {

    public int val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
