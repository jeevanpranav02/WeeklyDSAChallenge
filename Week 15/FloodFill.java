package Day_1;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int target = image[sr][sc];
        image[sr][sc] = newColor;
        if (target == newColor) {
            return image;
        }

        final int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir : directions) {
                int row = cur[0] + dir[1];
                int col = cur[1] + dir[0];
                if (isVaildCell(row, col, image, target)) {
                    image[row][col] = newColor;
                    queue.add(new int[]{row, col});
                }
            }
        }
        return image;
    }

    private boolean isVaildCell(int row, int col, int[][] image, int target) {
        return row < image.length && row >= 0 && col < image[0].length && col >= 0 && image[row][col] == target;
    }
}
