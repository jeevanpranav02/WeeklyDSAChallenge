import java.util.*;

public class MinimumRoundsToComplete {
    public static void main(String[] args) {
        int nums[] = { 69, 65, 62, 64, 70, 68, 69, 67, 60, 65, 69, 62, 65, 65, 61, 66, 68, 61, 65, 63, 60, 66, 68, 66,
                67, 65, 63, 65, 70, 69, 70, 62, 68, 70, 60, 68, 65, 61, 64, 65, 63, 62, 62, 62, 67, 62, 62, 61, 66,
                69 };
        System.out.println(minimumRounds(nums));
    }

    static int minimumRounds(int[] tasks) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < tasks.length; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        }
        for (int map_count : map.values()) {
            if (map_count < 2) {
                return -1;
            }
            count += (map_count / 3);
            if (map_count % 3 != 0) {
                count++;
            }
        }
        return count;
    }
}