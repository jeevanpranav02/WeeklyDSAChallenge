package Day_6;

import java.util.Arrays;

public class MinimumBurst {
    public static void main(String[] args) {
        int[][] arr = {{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6},
                {2, 8}};
        System.out.println(findMinArrowShots(arr));
    }

    static int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> {
            if (a[1] == b[1]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });
        int count = 1;
        int i = 0;
        int curr = points[0][1];
        while (i < points.length) {
            if (points[i][0] <= curr && points[i][1] >= curr) {
                i++;
            } else {
                count++;
                curr = points[i][1];
                i++;
            }
        }
        return count;
    }
}