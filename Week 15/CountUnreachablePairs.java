package Daily_Challenge;

import java.util.ArrayList;
import java.util.List;

public class CountUnreachablePairs {
    public static long countPairs(int n, int[][] edges) {
        List<List<Integer>> graph = generateGraph(n, edges);
        boolean[] visited = new boolean[n];
        long[] count = new long[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count[i] = dfs(i, graph, visited);
            }
        }
        long result = 0;
        for (int i = 0; i < n; i++) {
            result += (n - count[i]) * count[i];
        }
        return result / 2;
    }

    private static List<List<Integer>> generateGraph(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return graph;
    }

    private static long dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        int count = 1;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                count += dfs(neighbor, graph, visited);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};
        System.out.println(countPairs(n, edges));
    }
}
