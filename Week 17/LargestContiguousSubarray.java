package Hari.Day_3;

import java.util.*;

public class LargestContiguousSubarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int maxSum = 0;
        int currentSum = 0;
        List<Integer> subarray = new ArrayList<>();
        List<Integer> maxSubarray = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0) {
                currentSum += arr[i];
                subarray.add(arr[i]);
            } else {
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    maxSubarray = new ArrayList<>(subarray);
                }
                currentSum = 0;
                subarray.clear();
            }
        }

        if (currentSum > maxSum) {
            maxSum = currentSum;
            maxSubarray = new ArrayList<>(subarray);
        }

        System.out.println(maxSum);

        for (int num : maxSubarray) {
            System.out.print(num + " ");
        }
    }
}
