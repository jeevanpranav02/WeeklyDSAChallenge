package CodeChef_JAN231D;

import java.util.Arrays;
import java.util.Scanner;

public class AsymmetricSwap {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws java.lang.Exception {
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    static void solve() {
        int n = sc.nextInt();
        int[] combinedArray = new int[n + n];
        for (int i = 0; i < n; i++) {
            combinedArray[i] = sc.nextInt();
        }
        for (int i = n; i < n + n; i++) {
            combinedArray[i] = sc.nextInt();
        }
        Arrays.sort(combinedArray);
        System.out.println(Arrays.toString(combinedArray));
        int slidingSumOfMaxAndMin = combinedArray[(n + n) - 1] - combinedArray[0];
        for (int i = 0; i <= n; i++) {
            slidingSumOfMaxAndMin = Math.min(slidingSumOfMaxAndMin, combinedArray[i + n - 1] - combinedArray[i]);
        }
        System.out.println(slidingSumOfMaxAndMin);
    }
}
