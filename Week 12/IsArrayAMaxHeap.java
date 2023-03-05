package Day_1;

import java.util.Arrays;

public class IsArrayAMaxHeap {
    public static void main(String[] args) {
        long[] nums = {9,12,45,49,55,69,78,87,90};
        System.out.println(countSub(nums,nums.length));
    }
    public static boolean countSub(long arr[], long n) {
        for(int i = (int)(n - 2) / 2; i >= 0; i--) {
            int l = 2 * i + 1;
            int r = 2 * i + 2;
            int max = i;
            if(l < n && arr[l] > arr[max]) {
                return false;
            }
            if(r < n && arr[r] > arr[max]) {
                return false;
            }
            if(max != i) {
                return false;
            }
        }
        return true;
    }
}
