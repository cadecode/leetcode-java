package top.cadecode.learn.leetcode.demo.tree;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 二叉树工具类
 *
 * @author Cade Li
 * @since 2024/4/1
 */
public class TreeTool {

    public static void firstOrderPrint(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        firstOrderPrint(node.left);
        firstOrderPrint(node.right);
    }

    public static void middleOrderPrint(TreeNode node) {
        if (node == null) {
            return;
        }
        middleOrderPrint(node.left);
        System.out.print(node.value + " ");
        middleOrderPrint(node.right);
    }

    public static void lastOrderPrint(TreeNode node) {
        if (node == null) {
            return;
        }
        lastOrderPrint(node.left);
        lastOrderPrint(node.right);
        System.out.print(node.value + " ");
    }

    /**
     * 层序遍历
     * 宽度优先遍历
     */
    public static HashMap<TreeNode, Integer> layerPrint(TreeNode node) {
        if (node == null) {
            return null;
        }
        HashMap<TreeNode, Integer> layerMap = new HashMap<>();
        layerMap.put(node, 1);
        int currLayer = 1;
        int currLayerNodeNum = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            Integer layer = layerMap.get(curr);
            if (layer == currLayer) {
                currLayerNodeNum++;
            } else {
                currLayer++;
                currLayerNodeNum = 1;
            }
            if (curr.left != null) {
                layerMap.put(curr.left, currLayer + 1);
                queue.add(curr.left);
            }
            if (curr.right != null) {
                layerMap.put(curr.right, currLayer + 1);
                queue.add(curr.right);
            }
            System.out.println(curr.value);
        }
        return layerMap;
    }

}
