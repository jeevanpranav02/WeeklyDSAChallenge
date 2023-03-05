package Day_3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class ReplaceWithRank {
    public static void main(String[] args) {
        int[] nums = {20, 15, 26, 2, 98, 6};
        replaceWithRank(nums, nums.length);
        System.out.println(Arrays.toString(nums));
    }

    private static int[] replaceWithRank(int[] nums, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.stream(nums).forEach(pq::add);
        /*
        * for(Integer num : nums) {
        *    pq.add(num);
        * }
        */
        int rank = 1;
        int prev = -1;
        while (!pq.isEmpty()) {
            if (prev == pq.peek()) {
                pq.poll();
            } else {
                prev = pq.poll();
                map.put(prev, rank++);
            }
        }
        IntStream.range(0, nums.length).forEach(i -> nums[i] = map.get(nums[i]));
        /*
        * for(int i = 0; i < nums.length; i++) {
        *       nums[i] = map.get(nums[i]);
        * }
        */
        return nums;
    }
}
