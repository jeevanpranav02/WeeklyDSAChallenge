import java.util.*;

public class MaximumBagWithFullCapacity {
    public static void main(String[] args) {
        int[] capacity = { 54, 18, 91, 49, 51, 45, 58, 54, 47, 91, 90, 20, 85, 20, 90, 49, 10, 84, 59, 29, 40, 9, 100,
                1, 64, 71, 30, 46, 91 };
        int[] rocks = { 14, 13, 16, 44, 8, 20, 51, 15, 46, 76, 51, 20, 77, 13, 14, 35, 6, 34, 34, 13, 3, 8, 1, 1, 61, 5,
                2, 15, 18 };
        int additionalRocks = 100;
        int ans = maximumBags(capacity, rocks, additionalRocks);
        System.out.println(ans);
    }

    static int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        for (int i = 0; i < rocks.length; i++) {
            rocks[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(rocks);
        int count = 0;
        for (int i = 0; i < rocks.length && (rocks[i] - additionalRocks) <= 0; i++) {
            count++;
            additionalRocks -= rocks[i];
        }
        return count;
    }
}
