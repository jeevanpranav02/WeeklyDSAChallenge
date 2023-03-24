package org.weeklydsa.Day_7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        Map<Integer, List<Integer>> graph = createGraph(isConnected);
        int n = isConnected.length;
        int numberOfProvinces = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                numberOfProvinces++;
                dfs(i, graph, visited);
            }
        }
        return numberOfProvinces;
    }

    private Map<Integer, List<Integer>> createGraph(int[][] isConnected) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int n = isConnected.length;
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
            for (int j = 0; j < n; j++) {
                if (j != i && isConnected[i][j] == 1) {
                    graph.get(i).add(j);
                }
            }
        }
        return graph;
    }

    private void dfs(int i, Map<Integer, List<Integer>> graph, boolean[] visited) {
        if (visited[i]) {
            return;
        }
        visited[i] = true;
        for (int it : graph.get(i)) {
            if (!visited[it]) {
                dfs(it, graph, visited);
            }
        }
    }
}
