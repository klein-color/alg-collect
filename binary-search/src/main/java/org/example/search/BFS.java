package org.example.search;

import java.util.*;

/**
 * BFS (广度优先搜索) 实现
 * 使用队列实现，适用于图或树的层序遍历
 */
public class BFS {

    /**
     * 图的邻接表表示
     */
    private Map<Integer, List<Integer>> graph;

    public BFS() {
        this.graph = new HashMap<>();
    }

    /**
     * 添加边（无向图）
     */
    public void addEdge(int u, int v) {
        graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
    }

    /**
     * BFS 遍历
     * @param start 起始节点
     * @return 访问顺序列表
     */
    public List<Integer> bfs(int start) {
        List<Integer> result = new ArrayList<>();
        if (!graph.containsKey(start)) {
            return result;
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        // 初始化
        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            // 访问所有未访问的邻居节点
            for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }

        return result;
    }

    /**
     * BFS 查找目标节点（返回最短路径长度）
     * @param start 起始节点
     * @param target 目标节点
     * @return 最短距离，如果找不到返回 -1
     */
    public int bfsShortestPath(int start, int target) {
        if (!graph.containsKey(start) || !graph.containsKey(target)) {
            return -1;
        }

        if (start == target) {
            return 0;
        }

        Set<Integer> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>(); // [节点，距离]

        queue.offer(new int[]{start, 0});
        visited.add(start);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int distance = current[1];

            for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                if (neighbor == target) {
                    return distance + 1;
                }
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(new int[]{neighbor, distance + 1});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        BFS bfs = new BFS();
        
        // 构建示例图
        //     0
        //   / | \
        //  1  2  3
        //  |     |
        //  4     5
        bfs.addEdge(0, 1);
        bfs.addEdge(0, 2);
        bfs.addEdge(0, 3);
        bfs.addEdge(1, 4);
        bfs.addEdge(3, 5);

        System.out.println("BFS 遍历结果 (从节点 0 开始): " + bfs.bfs(0));
        System.out.println("从节点 0 到节点 5 的最短距离: " + bfs.bfsShortestPath(0, 5));
        System.out.println("从节点 0 到节点 4 的最短距离: " + bfs.bfsShortestPath(0, 4));
    }
}
