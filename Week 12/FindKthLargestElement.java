package Day_2;

import Day_1.MinHeap;

public class FindKthLargestElement {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        System.out.println(findKthLargest(nums, k));
    }

    public static int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        MinHeap heap = new MinHeap(n);
        for (int num : nums) {
            heap.insertKey(num);
        }
        k = n - k;
        for (int i = 0; i < k; i++) {
            heap.extractMin();
        }
        return heap.extractMin();
    }
}
