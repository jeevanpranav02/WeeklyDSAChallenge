package Week_12.Day_6;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestElementInMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        int k = 4;
        System.out.println(kthSmallest(matrix,k));
    }
    private static int kthSmallest(int[][] matrix, int k) {
        Queue<Integer> pq = new PriorityQueue<>();
        for(int[] row : matrix) {
            Arrays.stream(row).forEach(pq::offer);
        }
        k = k - 1;
        while(k-- > 0) {
            pq.poll();
        }
        return pq.poll();
    }
}
