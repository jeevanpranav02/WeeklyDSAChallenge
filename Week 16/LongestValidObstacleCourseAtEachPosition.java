package Daily_Challenge.LeetCode;

import java.util.Arrays;

public class LongestValidObstacleCourseAtEachPosition {
    public static void main(String[] args) {
        int[] obstacles = {1, 2, 3, 2};
        int[] result = getLongestObstacleCourse(obstacles);
        System.out.println(Arrays.toString(result)); // expected output: [1, 2, 3, 3]

        obstacles = new int[]{2, 2, 1};
        result = getLongestObstacleCourse(obstacles);
        System.out.println(Arrays.toString(result)); // expected output: [1, 2, 1]

        obstacles = new int[]{3, 1, 5, 6, 4, 2};
        result = getLongestObstacleCourse(obstacles);
        System.out.println(Arrays.toString(result)); // expected output: [1, 1, 2, 3, 2, 2]
    }


    static int upperBound(int[] arr, int low, int high, int x) {
        int mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (x >= arr[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if (arr[low] <= x) {
            low++;
        }
        return low;
    }

    public static int[] getLongestObstacleCourse(int[] obstacles) {
        int n = obstacles.length;
        int[] ans = new int[n];
        int[] maxHeights = new int[n];
        int length = 0;
        for (int i = 0; i < n; i++) {
            if (length == 0 || maxHeights[length - 1] <= obstacles[i]) {
                maxHeights[length++] = obstacles[i];
            } else {
                maxHeights[upperBound(maxHeights, 0, length - 1, obstacles[i])] = obstacles[i];
            }
            ans[i] = upperBound(maxHeights, 0, length - 1, obstacles[i]);
        }
        return ans;
    }
}
