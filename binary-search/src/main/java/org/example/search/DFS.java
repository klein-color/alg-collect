package org.example.search;

import java.util.*;

/**
 * DFS (深度优先搜索) 实现
 * 使用递归和栈两种方式实现，适用于图或树的遍历
 */
public class DFS {

    /**
     * 图的邻接表表示
     */
    private Map<Integer, List<Integer>> graph;

    public DFS() {
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
     * DFS 遍历 - 递归实现
     * @param start 起始节点
     * @return 访问顺序列表
     */
    public List<Integer> dfsRecursive(int start) {
        List<Integer> result = new ArrayList<>();
        if (!graph.containsKey(start)) {
            return result;
        }

        Set<Integer> visited = new HashSet<>();
        dfsHelper(start, visited, result);
        return result;
    }

    /**
     * DFS 辅助递归方法
     */
    private void dfsHelper(int node, Set<Integer> visited, List<Integer> result) {
        visited.add(node);
        result.add(node);

        for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited, result);
            }
        }
    }

    /**
     * DFS 遍历 - 迭代实现（使用栈）
     * @param start 起始节点
     * @return 访问顺序列表
     */
    public List<Integer> dfsIterative(int start) {
        List<Integer> result = new ArrayList<>();
        if (!graph.containsKey(start)) {
            return result;
        }

        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            
            if (!visited.contains(node)) {
                visited.add(node);
                result.add(node);

                // 将邻居节点压入栈（逆序以保证与递归相同的访问顺序）
                List<Integer> neighbors = graph.getOrDefault(node, new ArrayList<>());
                for (int i = neighbors.size() - 1; i >= 0; i--) {
                    int neighbor = neighbors.get(i);
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }

        return result;
    }

    /**
     * DFS 查找是否存在从 start 到 target 的路径
     * @param start 起始节点
     * @param target 目标节点
     * @return 是否存在路径
     */
    public boolean hasPath(int start, int target) {
        if (!graph.containsKey(start) || !graph.containsKey(target)) {
            return false;
        }

        Set<Integer> visited = new HashSet<>();
        return hasPathHelper(start, target, visited);
    }

    /**
     * DFS 路径查找辅助方法
     */
    private boolean hasPathHelper(int node, int target, Set<Integer> visited) {
        if (node == target) {
            return true;
        }

        visited.add(node);

        for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                if (hasPathHelper(neighbor, target, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        DFS dfs = new DFS();
        
        // 构建示例图
        //     0
        //   / | \
        //  1  2  3
        //  |     |
        //  4     5
        dfs.addEdge(0, 1);
        dfs.addEdge(0, 2);
        dfs.addEdge(0, 3);
        dfs.addEdge(1, 4);
        dfs.addEdge(3, 5);

        System.out.println("DFS 遍历结果 - 递归 (从节点 0 开始): " + dfs.dfsRecursive(0));
        System.out.println("DFS 遍历结果 - 迭代 (从节点 0 开始): " + dfs.dfsIterative(0));
        System.out.println("从节点 0 到节点 5 是否有路径: " + dfs.hasPath(0, 5));
        System.out.println("从节点 0 到节点 6 是否有路径: " + dfs.hasPath(0, 6));
    }
}
