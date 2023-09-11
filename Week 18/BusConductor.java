package GFG;

import java.util.Arrays;

public class BusConductor {
    public static int findMoves(int n, int[] chairs, int[] passengers) {
        Arrays.sort(chairs);
        Arrays.sort(passengers);
        int result = 0;
        for (int i = 0; i < chairs.length; i++) {
            while (chairs[i] != passengers[i]) {
                if (chairs[i] < passengers[i]) {
                    passengers[i]--;
                } else {
                    passengers[i]++;
                }
                result++;
            }
        }
        return result;
    }
}
