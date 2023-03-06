package Day_4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargest {
    private PriorityQueue<Integer> maxPQueue = new PriorityQueue<>(Comparator.reverseOrder());
    private PriorityQueue<Integer> minPQueue = new PriorityQueue<>();
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            push(num);
        }
    }

    public int add(int val) {
        push(val);
        return minPQueue.peek();
    }

    private void push(int val) {
        var t = maxPQueue;
        var t1 = minPQueue;
        maxPQueue.offer(val);
        minPQueue.offer(maxPQueue.poll());
        if (minPQueue.size() > k) {
            maxPQueue.offer(minPQueue.poll());
        }
    }

    private static int[] kthLargestReturningArray(int k, int[] arr, int n) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] res = new int[n];
        int i = 0;
        for (int val : arr) {
            if (pq.size() < k) {
                pq.add(val);
            } else {
                if (val > pq.peek()) {
                    pq.poll();
                    pq.add(val);
                }
            }
            if (pq.size() >= k) {
                res[i++] = pq.peek();
            } else {
                res[i++] = -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 8, 2};
        KthLargest k = new KthLargest(3, nums);
        System.out.println(k.add(10));
        System.out.println(k.add(3));
        System.out.println(k.add(5));
        System.out.println(k.add(9));
        System.out.println(k.add(4));
        System.out.println(Arrays.toString(kthLargestReturningArray(3, nums, nums.length)));
    }
}
