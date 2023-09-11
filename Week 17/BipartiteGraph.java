package Day_1;

import java.util.Arrays;

public class BipartiteGraph {
    public static void main(String[] args) {
        int[][] graph = {
                {1, 3},
                {0, 2},
                {1, 3},
                {0, 2}
        };
        System.out.println(isBipartite(graph));
    }

    public static boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];
        Arrays.fill(visited, -1);
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == -1 && !dfs(graph, visited, i, 0)) {
                return false;
            }
        }
        return true;
    }

    private static boolean dfs(int[][] graph, int[] visited, int node, int col) {
        if (visited[node] != -1) {
            return visited[node] == col;
        }
        visited[node] = col;
        for (int i : graph[node]) {
            if (!dfs(graph, visited, i, 1 - col)) {
                return false;
            }
        }
        return true;
    }
}
