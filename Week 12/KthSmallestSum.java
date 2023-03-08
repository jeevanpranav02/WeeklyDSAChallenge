package Week_12.Day_6;

import java.util.*;

public class KthSmallestSum {
    public static void main(String[] args) {
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 5;
        System.out.println(kSmallestPairs(nums1, nums2, k));
    }

    private static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Set<String> visited = new HashSet<>();
        List<List<Integer>> outer = new ArrayList<>();

        heap.offer(new int[]{nums1[0] + nums2[0], 0, 0});

        while (!heap.isEmpty() && outer.size() < k) {
            int[] curr = heap.poll();
            int i = curr[1], j = curr[2];
            outer.add(List.of(nums1[i], nums2[j]));

            if (i < nums1.length - 1 && !visited.contains((i + 1) + "," + j)) {
                heap.offer(new int[]{nums1[i + 1] + nums2[j], i + 1, j});
                visited.add((i + 1) + "," + j);
            }

            if (j < nums2.length - 1 && !visited.contains(i + "," + (j + 1))) {
                heap.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
                visited.add(i + "," + (j + 1));
            }
        }
        return outer;
    }
}
