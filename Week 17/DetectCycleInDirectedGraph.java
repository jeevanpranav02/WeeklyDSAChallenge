package Day_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DetectCycleInDirectedGraph {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        graph.add(new ArrayList<>(Arrays.asList(1, 2)));
        graph.add(new ArrayList<>(List.of(2)));
        graph.add(new ArrayList<>(Arrays.asList(0, 3)));
        graph.add(new ArrayList<>(List.of(3)));
        System.out.println(isCyclic(graph.size(),graph));
    }

    private static boolean isCyclic(int n, ArrayList<ArrayList<Integer>> graph) {
        boolean[] visited = new boolean[n];
        boolean[] pathVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i] && dfs(graph, visited, pathVisited, i)) {
                return true;
            }
        }
        return false;
    }

    private static boolean dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, boolean[] pathVisited, int node) {
        visited[node] = true;
        pathVisited[node] = true;
        for (int it : graph.get(node)) {
            if (!visited[it]) {
                if (dfs(graph, visited, pathVisited, it)) {
                    return true;
                }
            } else if (pathVisited[it]) {
                return true;
            }
        }
        pathVisited[node] = false;
        return false;
    }
}
