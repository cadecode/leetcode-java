package top.cadecode.learn.leetcode.demo.graph;

import java.util.*;
import java.util.Map.Entry;

/**
 * 图工具
 *
 * @author Cade Li
 * @since 2024/4/10
 */
public class GraphTool {

    /**
     * matrix 二维数组表示的有向图
     * [
     * [边 weight, from 序号，to 序号]
     * ...
     * ]
     */
    public static Graph createGraph(Integer[][] matrix) {
        Graph graph = new Graph();

        for (int i = 0; i < matrix.length; i++) {
            Integer edgeWt = matrix[i][0];
            Integer fromVal = matrix[i][1];
            Integer toVal = matrix[i][2];
            if (!graph.nodes.containsKey(fromVal)) {
                graph.nodes.put(fromVal, new Node(fromVal));

            }
            if (!graph.nodes.containsKey(toVal)) {
                graph.nodes.put(toVal, new Node(toVal));
            }
            Node from = graph.nodes.get(fromVal);
            Node to = graph.nodes.get(toVal);
            Edge edge = new Edge(edgeWt, from, to);
            graph.edges.add(edge);
            from.edges.add(edge);
            from.out++;
            to.in++;
            from.nexts.add(to);
        }

        return graph;
    }

    /**
     * 宽度优先遍历
     */
    public static void bfs(Node node) {
        Set<Node> set = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        set.add(node);
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            // 处理
            System.out.println(curr.value);

            for (Node next : curr.nexts) {
                if (!set.contains(next)) {
                    set.add(next);
                    queue.offer(next);
                }
            }

        }
    }

    /**
     * 深度优先遍历
     */
    public static void dfs(Node node) {
        Set<Node> set = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        set.add(node);
        stack.push(node);
        System.out.println(node.value);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            for (Node next : curr.nexts) {
                if (!set.contains(next)) {
                    stack.push(curr);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }

    /**
     * 拓扑排序
     * 要求有向图，有入度为 0 的节点，且没有环
     */
    public static List<Node> topologicalSort(Graph graph) {
        // 入度 map
        HashMap<Node, Integer> inMap = new HashMap<>();
        // 处理队列
        Queue<Node> zeroInQueue = new LinkedList<>();
        for (Node node : graph.nodes.values()) {
            inMap.put(node, node.in);
            // 找到入度为 0
            if (node.in == 0) {
                zeroInQueue.offer(node);
            }
        }
        List<Node> resList = new ArrayList<>();
        while (!zeroInQueue.isEmpty()) {
            Node node = zeroInQueue.poll();
            resList.add(node);
            for (Node next : node.nexts) {
                // 消除当前节点对入度的影响
                inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) == 0) {
                    zeroInQueue.offer(next);
                }
            }
        }
        return resList;
    }

    /**
     * K 算法 最小生成树
     * 要求无向图
     * 原理：每次选最短的边，判断该边会不会成环，会成环则不取该边
     * 判断会不会成环，利用并查集思想
     */
    public static Set<Edge> kruskalMST(Graph graph) {
        // 查询合并工具
        MySet mySet = new MySet(new ArrayList<>(graph.nodes.values()));
        // 小顶堆，取最小边
        PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparing(o -> o.weight));
        for (Edge edge : graph.edges) {
            minHeap.offer(edge);
        }
        HashSet<Edge> resSet = new HashSet<>();
        while (!minHeap.isEmpty()) {
            Edge edge = minHeap.poll();
            Node from = edge.from;
            Node to = edge.to;
            if (!mySet.isSameSet(from, to)) {
                resSet.add(edge);
                mySet.union(from, to);
            }
        }
        return resSet;
    }

    static class MySet {

        HashMap<Node, List<Node>> map = new HashMap<>();

        public MySet(List<Node> list) {
            // 开始，每个节点在各自的 set 中
            for (Node node : list) {
                List<Node> set = new ArrayList<>();
                set.add(node);
                map.put(node, set);
            }
        }

        /**
         * 是否在一个集合
         */
        public boolean isSameSet(Node node1, Node node2) {
            return map.get(node1) == map.get(node2);
        }

        /**
         * 合并到一个集合
         */
        public void union(Node node1, Node node2) {
            List<Node> set1 = map.get(node1);
            List<Node> set2 = map.get(node2);

            for (Node node : set2) {
                set1.add(node);
                map.put(node, set1);
            }
        }

    }

    /**
     * P 算法 最小生成树
     * 原理：选择一个点，维护一个小顶堆，加入该点的边，遍历小顶堆来获取最小的边，每次将当前最小边的结束点的边加入小顶堆，
     * 要求无向图
     */
    public static Set<Edge> primMST(Graph graph) {
        HashSet<Edge> resSet = new HashSet<>();
        // 防止重复处理
        HashSet<Node> cache = new HashSet<>();

        PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparing(o -> o.weight));

        // 此 for 循环只是随便挑取一个点
        // 仅仅防止图中存在孤岛，在整个图连通时没有实际作用
        for (Node node : graph.nodes.values()) {
            if (cache.contains(node)) {
                continue;
            }
            cache.add(node);
            for (Edge edge : node.edges) {
                minHeap.offer(edge);
            }
            while (!minHeap.isEmpty()) {
                Edge edge = minHeap.poll();
                Node toNode = edge.to;
                if (!cache.contains(toNode)) {
                    cache.add(toNode);
                    resSet.add(edge);
                    for (Edge toEdge : toNode.edges) {
                        minHeap.offer(toEdge);
                    }
                }
            }
        }

        return resSet;
    }

    /**
     * dj 克斯拉算法
     * 要求不能有权值累加和为负数的环
     */
    public static Map<Node, Integer> dijkstra(Node head) {
        // 从 head 到其他所有节点 key 的距离 val
        // 不在 map 中则到该节点还没有路，或者说距离为正无穷
        Map<Node, Integer> distanceMap = new HashMap<>();
        // head 自己到自己距离为 0
        distanceMap.put(head, 0);
        // 已经处理的点
        Set<Node> selectedNodes = new HashSet<>();
        // 选一个没有处理过、距离最小的点，此时应该就是 head
        Node minNode = getMinDistanceNode(distanceMap, selectedNodes);
        while (minNode != null) {
            Integer distance = distanceMap.get(minNode);
            for (Edge edge : minNode.edges) {
                Node toNode = edge.to;
                if (distanceMap.containsKey(toNode)) {
                    // 比较之前发现的最小路径
                    distanceMap.put(toNode, Math.min(distanceMap.get(toNode), distance + edge.weight));
                } else {
                    // 没有该 key，说明到该节点还没有路
                    distanceMap.put(toNode, distance + edge.weight);
                }
            }
            selectedNodes.add(minNode);
            minNode = getMinDistanceNode(distanceMap, selectedNodes);
        }
        return distanceMap;
    }

    /**
     * 找到没处理过的、距离最小的点
     */
    private static Node getMinDistanceNode(Map<Node, Integer> distanceMap, Set<Node> selectedNodes) {
        Node minNode = null;
        int minDistance = Integer.MAX_VALUE;
        for (Entry<Node, Integer> entry : distanceMap.entrySet()) {
            if (!selectedNodes.contains(entry.getKey()) && entry.getValue() < minDistance) {
                minNode = entry.getKey();
                minDistance = entry.getValue();
            }
        }
        return minNode;
    }
}
