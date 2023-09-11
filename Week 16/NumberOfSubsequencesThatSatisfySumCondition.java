package Daily_Challenge.LeetCode;

import java.util.Arrays;

public class NumberOfSubsequencesThatSatisfySumCondition {
    public static void main(String[] args) {
        int[] nums = {2,3,3,4,6,7};
        int target = 12;
        int ans = numSubseq(nums, target);
        System.out.println(ans);
    }

    private static int numSubseq(int[] nums, int target) {
        int ans = 0;
        int mod = (int) 1e9 + 7;
        int n = nums.length;
        int[] pow = new int[n];
        pow[0] = 1;
        for (int i = 1; i < n; i++) {
            pow[i] = (pow[i - 1] * 2) % mod;
        }
        int i = 0;
        int j = n - 1;
        Arrays.sort(nums);
        while (i <= j) {
            if (nums[i] + nums[j] > target) {
                j--;
            } else {
                ans = (ans + pow[j - i]) % mod;
                i++;
            }
        }
        return ans;
    }
}
