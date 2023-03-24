package org.weeklydsa.Day_7;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int countFreshOranges = 0;
        Queue<Pair> queue = new LinkedList<>();
        int[][] visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new Pair(i, j, 0));
                    visited[i][j] = 2;
                } else {
                    visited[i][j] = 0;
                }
                if (grid[i][j] == 1) {
                    countFreshOranges++;
                }
            }
        }
        int[] rowChange = {-1, 0, 1, 0};
        int[] colChange = {0, 1, 0, -1};
        int time = 0;
        int countRotten = 0;
        while (!queue.isEmpty()) {
            int row = queue.peek().row;
            int col = queue.peek().col;
            int currTime = queue.peek().currentTime;
            time = Integer.max(time, currTime);
            queue.poll();
            for (int i = 0; i < 4; i++) {
                int r = row + rowChange[i];
                int c = col + colChange[i];
                if (r >= 0 && r < n && c >= 0 && c < m && visited[r][c] == 0 && grid[r][c] == 1) {
                    queue.add(new Pair(r, c, currTime + 1));
                    visited[r][c] = 2;
                    countRotten++;
                }
            }
        }
        return countRotten == countFreshOranges ? time : -1;
    }

    private static class Pair {
        int row;
        int col;
        int currentTime;

        public Pair(int row, int col, int currentTime) {
            this.row = row;
            this.col = col;
            this.currentTime = currentTime;
        }
    }
}
