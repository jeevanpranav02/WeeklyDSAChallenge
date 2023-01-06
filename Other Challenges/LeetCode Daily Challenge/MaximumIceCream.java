package DailyChallenge;

import java.util.Arrays;

public class MaximumIceCream {
    public static void main(String[] args) {
        int[] costs = {1,3,2,4,1};
        int coins = 7;
        System.out.println(maxIceCream(costs, coins));
    }
    static int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);

        int count = 0;

        while (count < costs.length && costs[count] <= coins) {
            coins -= costs[count];
            count += 1;
        }

        return count;
    }
}