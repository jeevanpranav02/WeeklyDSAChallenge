package Daily_Challenge.GFG;

import java.util.Arrays;

public class TotalCuts {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 5;
        int n = nums.length;
        System.out.println(totalCuts(n, k, nums));
    }

    public static int totalCuts(int n, int k, int[] nums) {
        int[] left = new int[n];
        left[0] = nums[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], nums[i]);
        }
        int[] right = new int[n];
        right[n - 1] = nums[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            right[i] = Math.min(right[i + 1], nums[i]);
        }
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            if (left[i] + right[i + 1] >= k) {
                count++;
            }
        }
        return count;
    }
}
