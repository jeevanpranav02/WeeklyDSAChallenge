package GFG;

import java.util.Arrays;

public class TreeTransformation {
    public static int solve(int n, int[] p) {
        int[] arr = new int[n];
        Arrays.fill(arr, 0);
        for (int i = 1; i < n; i++) {
            arr[p[i]]++;
            arr[i]++;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                count++;
            }
        }
        if (count == n) {
            return 0;
        }
        return n - 1 - count;
    }
}
