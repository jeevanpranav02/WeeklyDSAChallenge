package CodeChef_JAN231D;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayHalves {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    static void solve() {
        int n = sc.nextInt();
        int[] originalArray = new int[n + n];
        int[] duplicateArray = new int[n + n];
        for (int i = 0; i < n + n; i++) {
            originalArray[i] = sc.nextInt();
            duplicateArray[i] = originalArray[i];
        }
        Arrays.sort(duplicateArray);
        int maxFirstHalf = duplicateArray[n - 1];
        long finalAnswer = 0;
        int arrayIDX = n;
        for (int i = 0; i < arrayIDX; i++) {
            if (originalArray[i] > maxFirstHalf) {
                finalAnswer += arrayIDX - i;
                arrayIDX++;
            }
        }
        System.out.println(finalAnswer);
    }
}
