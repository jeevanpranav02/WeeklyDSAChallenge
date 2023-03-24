package org.weeklydsa.Day_7;

import java.util.*;


public class GraphTraversals {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        ArrayList<Integer> list = new ArrayList<>();
        Map<Integer, ArrayList<Integer>> graph = constructGraph(adj);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            list.add(node);
            for (Integer it : graph.get(node)) {
                if (!visited[it]) {
                    visited[it] = true;
                    queue.add(it);
                }
            }
        }
        return list;
    }

    private Map<Integer, ArrayList<Integer>> constructGraph(ArrayList<ArrayList<Integer>> adj) {
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for (int i = 0; i < adj.size(); i++) {
            graph.put(i, adj.get(i));
        }
        return graph;
    }

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V + 1];
        ArrayList<Integer> list = new ArrayList<>();
        dfs(0, adj, list, visited);
        return list;
    }

    private void dfs(int i, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> list, boolean[] visited) {
        if (visited[i]) {
            return;
        }
        visited[i] = true;
        list.add(i);
        for (int it : adj.get(i)) {
            if (!visited[it]) {
                dfs(it, adj, list, visited);
            }
        }
    }
}
