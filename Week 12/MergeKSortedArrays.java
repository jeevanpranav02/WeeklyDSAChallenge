package Day_2;

import Day_1.MinHeap;

import java.util.ArrayList;

public class MergeKSortedArrays {
    public static void main(String[] args) {
        int[][] nums = {
                {99, 12, 41},
                {12, 23, 77},
                {44, 51, 52}
        };
        System.out.println(mergeKArrays(nums, nums.length));
    }

    public static ArrayList<Integer> mergeKArrays(int[][] nums, int k) {
        MinHeap heap = new MinHeap(k * k);
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                heap.insertKey(nums[i][j]);
            }
        }
        for (int i = 0; i < k * k; i++) {
            list.add(heap.extractMin());
        }
        return list;
    }
}
