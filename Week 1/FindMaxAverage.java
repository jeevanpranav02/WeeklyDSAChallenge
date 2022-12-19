import java.math.*;

public class FindMaxAverage {
    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        System.out.println(findMaxAverage(nums, k));
    }

    static double findMaxAverage(int[] nums, int k) {
        double result = 0;
        double maxSum = 0;
        double windowSum = 0;

        for(int i = 0; i < k; i++) {
            maxSum += nums[i];
        }
        windowSum = maxSum;

        for(int i = k; i < nums.length; i++)
        {
            windowSum += nums[i] - nums[i - k];
            maxSum = Math.max((int) windowSum, (int)maxSum);
        }
        result = maxSum / k;
        return BigDecimal.valueOf(result).setScale(5, RoundingMode.HALF_UP).doubleValue();
    }
}