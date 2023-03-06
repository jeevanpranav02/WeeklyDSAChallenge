package Day_4;

import java.util.*;

public class MaximumSumCombination {
    public static void main(String[] args) {
        int k = 3;
        int[] a = {1, 4, 2, 3};
        int[] b = {2, 5, 1, 6};
        System.out.println(maxCombinations(a.length, k, a, b));
    }

    private static List<Integer> maxCombinations(int n, int k, int a[], int b[]) {
        Arrays.sort(a);
        Arrays.sort(b);
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        List<Integer> res = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            pq.add(new int[]{a[i] + b[n - 1], i, n - 1});
        }
        while (k-- > 0 && !pq.isEmpty()) {
            int[] curr = pq.poll();
            res.add(curr[0]);
            int i = curr[1];
            int j = curr[2];
            if (j != 0) {
                pq.add(new int[]{a[i] + b[j - 1], i, j - 1});
            }
        }
        return res;
    }
}