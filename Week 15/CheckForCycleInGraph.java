package Day_1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheckForCycleInGraph {

    // Using DFS
    public static boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                if (checkCycle(i, v, adj, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkCycle(int source, int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[source] = true;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(source, -1));
        while (!queue.isEmpty()) {
            int src = queue.peek().src;
            int parent = queue.peek().prnt;
            queue.poll();
            for (int node : adj.get(src)) {
                if (!visited[node]) {
                    visited[node] = true;
                    queue.add(new Pair(node, src));
                } else if (parent != node) {
                    return true;
                }
            }
        }
        return false;
    }

    private static class Pair {
        int src;
        int prnt;

        Pair(int s, int p) {
            src = s;
            prnt = p;
        }
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(3).add(4);
        adj.get(4).add(3);
        adj.get(4).add(0);
        adj.get(0).add(4);
        System.out.println(isCycle(v, adj));
    }
}
