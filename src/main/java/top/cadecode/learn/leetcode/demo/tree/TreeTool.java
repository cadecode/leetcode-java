package top.cadecode.learn.leetcode.demo.tree;

import java.util.*;

/**
 * 二叉树工具类
 *
 * @author Cade Li
 * @since 2024/4/1
 */
public class TreeTool {

    public static void firstOrderPrint(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        firstOrderPrint(root.left);
        firstOrderPrint(root.right);
    }

    public static void middleOrderPrint(TreeNode root) {
        if (root == null) {
            return;
        }
        middleOrderPrint(root.left);
        System.out.print(root.val + " ");
        middleOrderPrint(root.right);
    }

    public static void lastOrderPrint(TreeNode root) {
        if (root == null) {
            return;
        }
        lastOrderPrint(root.left);
        lastOrderPrint(root.right);
        System.out.print(root.val + " ");
    }

    /**
     * 层序遍历
     * 宽度优先遍历
     */
    public static HashMap<TreeNode, Integer> layerPrint(TreeNode root) {
        if (root == null) {
            return null;
        }
        HashMap<TreeNode, Integer> layerMap = new HashMap<>();
        layerMap.put(root, 1);
        int currLayer = 1;
        int currLayerNodeNum = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
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
            System.out.println(curr.val);
        }
        return layerMap;
    }

    /**
     * 最大深度
     * 基于后序遍历
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lRes = maxDepth(root.left);
        int rRes = maxDepth(root.right);

        return Math.max(lRes, rRes) + 1;
    }

    /**
     * 节点数
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = countNodes(root.left);
        int r = countNodes(root.right);
        return l + r + 1;
    }

    /**
     * 收集节点
     */
    public List<Integer> listNodes(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> lList = listNodes(root.left);
        List<Integer> rList = listNodes(root.right);
        lList.add(root.val);
        lList.addAll(rList);
        return lList;
    }

    /**
     * 是否是搜索二叉树
     * 以单调递增来判断
     */
    public static long BST_PRE_VAL = Long.MIN_VALUE;

    public static boolean isBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isBST(root.left)) {
            return false;
        }
        if (root.val <= BST_PRE_VAL) {
            return false;
        } else {
            BST_PRE_VAL = root.val;
        }
        return isBST(root.right);
    }

    /**
     * 是否是搜索二叉树
     * 递归，返回 [是否搜索二叉树 0/1, 最小值, 最大值]
     */
    public static boolean isBST2(TreeNode root) {
        int[] arr = isBST2Process(root);
        if (arr == null) {
            return false;
        }
        return arr[0] == 1;
    }

    public static int[] isBST2Process(TreeNode root) {
        if (root == null) {
            return null;
        }
        int[] lArr = isBST2Process(root.left);
        int[] rArr = isBST2Process(root.right);

        int min = root.val;
        int max = root.val;
        if (lArr != null) {
            min = Math.min(min, lArr[1]);
            max = Math.max(max, lArr[2]);
        }
        if (rArr != null) {
            min = Math.min(min, rArr[1]);
            max = Math.max(max, rArr[2]);
        }
        int flag = 1;
        if (lArr != null && (lArr[0] == 0 || lArr[2] >= root.val)) {
            flag = 0;
        }

        if (rArr != null && (rArr[0] == 0 || rArr[1] <= root.val)) {
            flag = 0;
        }
        return new int[]{flag, min, max};
    }

    /**
     * 判断平衡二叉树
     * 求
     * 递归，返回 [是否平衡二叉树 0/1，高度]
     */
    public static boolean isBBT(TreeNode root) {
        return isBBTProcess(root)[0] == 1;
    }

    public static int[] isBBTProcess(TreeNode root) {
        if (root == null) {
            // 没有节点时，认为是平衡的
            return new int[]{1, 0};
        }
        int[] lArr = isBBTProcess(root.left);
        int[] rArr = isBBTProcess(root.right);
        int isBalanced = (lArr[0] == 1 && rArr[0] == 1 && Math.abs(lArr[1] - rArr[1]) < 2) ? 1 : 0;
        int height = Math.max(lArr[1], rArr[1]) + 1;
        return new int[]{isBalanced, height};
    }

    /**
     * 判断满二叉树
     * 求节点数和层数是否满足数学关系
     * 递归，返回 [高度，节点数]
     */
    public static boolean isFBT(TreeNode root) {
        int[] arr = isFBTProcess(root);
        return arr[1] == Math.pow(2, arr[0]) - 1;
    }

    public static int[] isFBTProcess(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] lArr = isFBTProcess(root.left);
        int[] rArr = isFBTProcess(root.right);
        int height = Math.max(lArr[0], rArr[0]) + 1;
        int nodes = lArr[1] + rArr[1] + 1;
        return new int[]{height, nodes};
    }

    /**
     * 判断完全二叉树
     * 从左到右变不满
     */
    public static boolean isCBT(TreeNode root) {
        // 是否需要只有一个左孩子的节点
        boolean onlyLeft = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            // 有右无左，直接 false
            if (currNode.left == null && currNode.right != null) {
                return false;
            }
            if (onlyLeft && currNode.left != null) {
                return false;
            }
            if (currNode.left == null || currNode.right == null) {
                onlyLeft = true;
            }
            if (currNode.left != null) {
                queue.offer(currNode.left);
            }
            if (currNode.right != null) {
                queue.offer(currNode.right);
            }
        }
        return true;
    }


    /**
     * 找两节点在树上的公共祖先
     */
    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        // 根节点父级设置为 null
        parentMap.put(root, null);
        // 递归填充其他节点的父级关系
        lcaProcess(root, parentMap);
        Set<TreeNode> set = new HashSet<>();
        while (p != null) {
            set.add(p);
            p = parentMap.get(p);
        }
        while (q != null) {
            if (set.contains(q)) {
                return q;
            }
            q = parentMap.get(q);
        }
        return null;
    }

    public void lcaProcess(TreeNode root, Map<TreeNode, TreeNode> map) {
        if (root == null) {
            return;
        }
        lcaProcess(root.left, map);
        lcaProcess(root.right, map);
        map.put(root.left, root);
        map.put(root.right, root);
    }

    public TreeNode lca2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lca2(root.left, p, q);
        TreeNode right = lca2(root.right, p, q);
        if (left == null && right == null) return null;
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}
