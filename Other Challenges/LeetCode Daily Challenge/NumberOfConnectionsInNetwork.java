package org.weeklydsa.Daily_Challenges;

import java.util.*;

public class NumberOfConnectionsInNetwork {
    public int makeConnected(int n, int[][] connections) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        if (connections.length < n - 1) {
            return -1;
        }

        for (int[] connection : connections) {
            graph.putIfAbsent(connection[0], new ArrayList<>());
            graph.get(connection[0]).add(connection[1]);

            graph.putIfAbsent(connection[1], new ArrayList<>());
            graph.get(connection[1]).add(connection[0]);
        }

        Set<Integer> visited = new HashSet<>();
        int numberOfConnections = 0;

        for (int i = 0; i < n; i++) {
            if (visited.contains(i)) {
                continue;
            }
            dfs(i, graph, visited);
            numberOfConnections++;
        }

        return numberOfConnections - 1;
    }

    private static void dfs(int currentNode, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        if (visited.contains(currentNode))
            return;
        visited.add(currentNode);
        for (int neighbor : graph.getOrDefault(currentNode, Collections.emptyList())) {
            dfs(neighbor, graph, visited);
        }
    }
}
