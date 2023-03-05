package Day_2;

import java.util.PriorityQueue;

public class FindKthSmallestElement {
    public static void main(String[] args) {
        int[] arr = {10, 20, 12, 31, 23, 12, 24, 12, 31};
        System.out.println(kthSmallest(arr, 0, arr.length - 1, 3));
    }

    public static int kthSmallest(int[] arr, int l, int r, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int a : arr) {
            pq.add(a);
        }
        for (int i = 0; i < k - 1; i++) {
            pq.poll();
        }
        return pq.peek();
    }
}
