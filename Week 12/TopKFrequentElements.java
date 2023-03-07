package Day_5;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3,2,2,2,2,1,1,1,1,1,1,4,4,4,4,4,4,4,3,3,1,3,3,3,5,5,5,5,5,5,5,5};
        System.out.println(Arrays.toString(topKFrequent(nums, 3)));
    }
    public static int[] topKFrequent(int[] nums, int k) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for(int n : nums){
//            map.put(n, map.getOrDefault( n, 0) + 1);
//        }
        HashMap<Integer, Integer> map = (HashMap<Integer, Integer>) Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toMap(Function.identity(), n -> 1, Integer::sum));

//        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
//        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
//            pq.add(new int[]{e.getKey(), e.getValue()});
//            while (pq.size() > k) {
//                pq.poll();
//            }
//        }

        PriorityQueue<int[]> pq = map.entrySet().stream()
                .map(e -> new int[]{e.getKey(), e.getValue()})
                .sorted(Comparator.comparingInt(a -> a[1]))
                .collect(Collectors.toCollection(() -> new PriorityQueue<>(Comparator.comparingInt(a -> a[1]))));

        while (pq.size() > k) {
            pq.poll();
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll()[0];
        }
        return res;
    }
}
