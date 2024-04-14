package top.cadecode.learn.leetcode.demo.graph;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 图
 *
 * @author Cade Li
 * @since 2024/4/10
 */
public class Graph {
    /**
     * 序号和点 map
     */
    public HashMap<Integer, Node> nodes = new HashMap<>();

    /**
     * 边集
     */
    public HashSet<Edge> edges = new HashSet<>();

}
