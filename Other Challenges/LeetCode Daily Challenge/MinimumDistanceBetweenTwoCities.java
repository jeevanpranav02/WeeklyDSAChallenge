package org.weeklydsa.Daily_Challenges;

import java.util.*;

public class MinimumDistanceBetweenTwoCities {
    int min;

    public int minScore(int n, int[][] roads) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            graph.get(road[0] - 1).add(new int[]{road[1] - 1, road[2]});
            graph.get(road[1] - 1).add(new int[]{road[0] - 1, road[2]});
        }
        min = Integer.MAX_VALUE;
        boolean[] visited = new boolean[n];
        dfs(graph, visited, 0);
        if (visited[n - 1]) {
            return min;
        }
        return -1;
    }

    private void dfs(List<List<int[]>> graph, boolean[] visited, int s) {
        if (visited[s]) {
            return;
        }
        visited[s] = true;
        for (int[] child : graph.get(s)) {
            dfs(graph, visited, child[0]);
            min = Math.min(min, child[1]);
        }
    }
}