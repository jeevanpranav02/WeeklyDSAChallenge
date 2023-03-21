package org.weeklydsa.Daily_Challenges;

public class CountOfSubarrayWithZero {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0;
        long subArrayWithZero = 0;
        for (int n : nums) {
            if (n == 0) {
                count += ++subArrayWithZero;
            } else {
                subArrayWithZero = 0;
            }
        }
        return count;
    }
}
