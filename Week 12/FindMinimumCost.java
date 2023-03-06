package Day_4;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindMinimumCost {
    public static void main(String[] args) {
        long[] nums = {4, 2, 7, 6, 9};
        System.out.println(minCost(nums, nums.length));
    }

    private static long minCost(long[] nums, int n) {
        Queue<Long> pq = new PriorityQueue<Long>();
        Arrays.stream(nums).forEach(pq::add);
        long totalCost = 0L;
        long currentCost = pq.poll();
        while (!pq.isEmpty()) {
            currentCost += pq.poll();
            totalCost += currentCost;
            pq.add(currentCost);
            currentCost = pq.poll();
        }

        return totalCost;
    }
}
