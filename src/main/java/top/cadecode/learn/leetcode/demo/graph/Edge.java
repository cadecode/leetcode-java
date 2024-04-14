package top.cadecode.learn.leetcode.demo.graph;

import java.util.ArrayList;

/**
 * 图的边
 *
 * @author Cade Li
 * @since 2024/4/10
 */
public class Edge {
    public int weight;

    /**
     * 起点
     */
    public Node from;

    /**
     * 终点
     */
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
