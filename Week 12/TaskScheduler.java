package Day_3;

import java.util.Map;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Collections;
import java.util.HashMap;

public class TaskScheduler {
    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int k = 3;
        System.out.println(leastInterval(tasks.length, k, tasks));
    }

    private static int leastInterval(int n, int k, char[] tasks) {
        if (k == 0) {
            return tasks.length;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        }
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(map.values());
        int maxFreq = pq.isEmpty() ? 0 : pq.poll();
        int totalIdleTime = (maxFreq - 1) * k;
        while (!pq.isEmpty()) {
            int currentFreq = pq.poll();
            if (currentFreq == maxFreq) {
                totalIdleTime -= currentFreq;
                totalIdleTime += 1;
            } else {
                totalIdleTime -= currentFreq;
            }
        }
        if (totalIdleTime > 0) {
            return totalIdleTime + tasks.length;
        }
        return tasks.length;
    }

}
