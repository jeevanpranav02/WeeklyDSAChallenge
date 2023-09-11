package Daily_Challenge;

import java.util.ArrayList;
import java.util.List;

public class ReorderRoutesToMakeAllPathsLeadToTheCityZero {
    public static int minReorder(int n, int[][] connections) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] connection : connections) {
            int u = connection[0];
            int v = connection[1];
            graph.get(u).add(new int[]{v, 1}); // 0 -> 1
            graph.get(v).add(new int[]{u, 0}); // 0 <- 4
        }

        return dfs(graph, 0, -1);
    }

    private static int dfs(List<List<int[]>> graph, int u, int parent) {
        int cnt = 0;
        for (int[] vw : graph.get(u)) {
            int v = vw[0];
            if (v == parent) continue;
            cnt += vw[1] + dfs(graph, v, u);
        }
        return cnt;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] connections = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
        System.out.println(minReorder(n, connections));
    }
}
