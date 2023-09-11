package Day_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class TopologicalSort {
    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(2).add(3);
        graph.get(3).add(1);
        graph.get(4).add(0);
        graph.get(4).add(1);
        graph.get(5).add(0);
        graph.get(5).add(2);
        System.out.println(Arrays.toString(topoSort(V, graph)));
    }

    public static int[] topoSort(int V, ArrayList<ArrayList<Integer>> graph) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, visited, stack, graph);
            }
        }

        int[] result = new int[V];
        int i = 0;
        while (!stack.isEmpty()) {
            result[i++] = stack.pop();
        }
        return result;
    }

    private static void dfs(int node, boolean[] visited, Stack<Integer> stack, ArrayList<ArrayList<Integer>> graph) {
        visited[node] = true;
        for (int it : graph.get(node)) {
            if (!visited[it])
                dfs(it, visited, stack, graph);
        }
        stack.push(node);
    }
}
