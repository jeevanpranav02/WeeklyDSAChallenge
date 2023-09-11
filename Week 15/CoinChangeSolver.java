package Daily_Challenge.Todo.GFG;

import java.util.Arrays;

public class CoinChangeSolver {
    private static int[][][] memo;

    private static boolean canMakeChange(int idx, int k, int target, int[] coins) {
        if (k == 0 && target == 0) {
            return true;
        }

        if (idx == coins.length || k == 0) {
            return false;
        }

        if (memo[idx][k][target] != -1) {
            return memo[idx][k][target] == 1;
        }

        for (int numberOfCoins = 1;; numberOfCoins++) {
            if (k - numberOfCoins < 0 || (coins[idx] * numberOfCoins > target)) {
                break;
            }
            if (canMakeChange(idx + 1, k - numberOfCoins, target - (coins[idx] * numberOfCoins), coins)) {
                memo[idx][k][target] = 1;
                return true;
            }
        }

        memo[idx][k][target] = canMakeChange(idx + 1, k, target, coins) ? 1 : 0;
        return memo[idx][k][target] == 1;
    }

    public static boolean makeChangePossible(int numberOfCoins, int k, int target, int[] coins) {
        memo = new int[numberOfCoins][k + 1][target + 1];
        for (int[][] x : memo) {
            for (int[] y : x) {
                Arrays.fill(y, -1);
            }
        }
        return canMakeChange(0, k, target, coins);
    }
}

