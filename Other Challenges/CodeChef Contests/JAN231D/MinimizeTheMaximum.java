package CodeChef_JAN231D;

import java.util.Scanner;

public class MinimizeTheMaximum {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws java.lang.Exception {
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    static void solve() throws java.lang.Exception {
        int n = sc.nextInt();
        int[] originalArray = new int[n];
        for (int i = 0; i < n; i++) {
            originalArray[i] = sc.nextInt();
        }
        int i = 0;
        int j = findMax(originalArray, n);
        int ans = j;
        while (i <= j) {
            int mid = i + (j - i) / 2;

            int max = makeDuplicateArray_ForTransforming_OriginalArray(n, originalArray, mid);
            if (max > mid) {
                i = mid + 1;
            } else {
                ans = Math.min(ans, max);
                j = mid - 1;
            }
        }
        System.out.println(ans);
    }
    static int makeDuplicateArray_ForTransforming_OriginalArray(int n, int[] originalArray, int mid) {
        int[] duplicateArray = new int[n];
        for (int a = 0; a < n; a++) {
            duplicateArray[a] = originalArray[a];
        }
        for (int a = n - 1; a >= 1; a--) {
            if (duplicateArray[a] > mid) {
                duplicateArray[a - 1] += duplicateArray[a] - mid;
                duplicateArray[a] = mid;
            }
        }
        return findMax(duplicateArray, n);
    }
    static int findMax(int arr[], int n) {
        int maximum = arr[0];
        for (int i = 1; i < n; i++) {
            maximum = Math.max(maximum, arr[i]);
        }
        return maximum;
    }
}