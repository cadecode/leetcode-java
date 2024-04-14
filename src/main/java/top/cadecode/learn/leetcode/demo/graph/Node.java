package top.cadecode.learn.leetcode.demo.graph;

import java.util.ArrayList;

/**
 * 图的点
 *
 * @author Cade Li
 * @since 2024/4/10
 */
public class Node {

    public int value;
    /**
     * 入度
     */
    public int in = 0;
    /**
     * 出度
     */
    public int out = 0;

    public ArrayList<Node> nexts = new ArrayList<>();
    public ArrayList<Edge> edges = new ArrayList<>();

    public Node(int value) {
        this.value = value;
    }
}
