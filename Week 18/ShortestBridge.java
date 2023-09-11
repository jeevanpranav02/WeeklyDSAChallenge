package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestBridge {
    private final int[] DIRX = {-1, 1, 0, 0};
    private final int[] DIRY = {0, 0, -1, 1};

    public int shortestBridge(int[][] grid) {
        var q = new ArrayDeque<int[]>();

        firstIsland(grid, q);

        int dist = 0, N = grid.length;

        while (!q.isEmpty()) {

            for (int i = 0, Q = q.size(); i < Q; ++i) {
                var xy = q.poll();

                for (var d = 0; d < 4; ++d) {
                    var x = xy[0] + DIRX[d];
                    var y = xy[1] + DIRY[d];

                    if (isOut(N, x, y))
                        continue;

                    if (grid[x][y] == 1)
                        return dist;

                    if (grid[x][y] == 0) {
                        q.add(new int[]{x, y});
                        grid[x][y] = -1;
                    }
                }
            }

            ++dist;
        }

        return dist;
    }

    private void firstIsland(int[][] grid, Deque<int[]> q) {
        for (var i = 0; i < grid.length; ++i) {
            for (var j = 0; j < grid.length; ++j) {
                if (grid[i][j] == 1) {
                    dfs(grid, q, i, j);
                    return;
                }
            }
        }
    }

    private void dfs(int[][] grid, Deque<int[]> q, int i, int j) {
        if (isOut(grid.length, i, j) || grid[i][j] != 1)
            return;

        grid[i][j] = -1;
        q.add(new int[]{i, j});

        dfs(grid, q, i - 1, j);
        dfs(grid, q, i + 1, j);
        dfs(grid, q, i, j - 1);
        dfs(grid, q, i, j + 1);
    }

    private boolean isOut(int N, int i, int j) {
        return i < 0 || i >= N || j < 0 || j >= N;
    }
}
