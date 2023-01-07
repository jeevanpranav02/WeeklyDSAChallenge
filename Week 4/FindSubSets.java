package Day_2;

import java.util.*;

public class FindSubSets {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }
    static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        int numOfSub = 1 << n;

        for (int i = 0; i < numOfSub; i++) {
            List<Integer> child = new ArrayList<>();
            int temp = i;
            for (int j = n - 1; j >= 0; j--) {
                int rem = temp & 1;
                temp = temp >> 1;
                if (rem == 1) {
                    child.add(0, nums[j]);
                }
            }
            result.add(child);
        }

        return result;
    }
}
