package Day_3;

public class MinimumBitsFlips {
    public static void main(String[] args) {
        int start = 10;
        int goal = 7;
        System.out.println(minBitFlips(start, goal));
    }

    static int minBitFlips(int start, int goal) {
        int count = 0;
        int max = Math.max(start, goal);
        while (max > 0) {
            if ((start & 1) != (goal & 1)) {
                count++;
            }
            start >>= 1;
            goal >>= 1;
            max >>= 1;
        }
        return count;
    }
}
