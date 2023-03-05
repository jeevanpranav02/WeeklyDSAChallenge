package Day_2;

import java.util.Arrays;

public class MinToMaxHeap {
    public static void main(String[] args) {
        int[] nums = {9,12,45,49,55,69,78,87,90};
        convertMinToMaxHeap(nums.length,nums);
        System.out.println(Arrays.toString(nums));
    }
    private static void convertMinToMaxHeap(int N, int arr[]) {
        for (int i = (N - 2) / 2; i >= 0; --i) {
            MaxHeapify(arr, i, N);
        }
    }
    private static void MaxHeapify(int arr[], int i, int N) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int largest = i;
        if (l < N && arr[l] > arr[i])
            largest = l;
        if (r < N && arr[r] > arr[largest])
            largest = r;
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            MaxHeapify(arr, largest, N);
        }
    }
}
