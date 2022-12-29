import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int nums[] = { -1, 2, 1, -4 };
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }

    static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minimum = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int current = i + 1;
            int maxIdx = nums.length - 1;
            while (current < maxIdx) {
                int tempSum = nums[i] + nums[current] + nums[maxIdx];
                int tempDiff = Math.abs(tempSum - target);
                if (tempDiff < minimum) {
                    result = tempSum;
                    minimum = tempDiff;
                }
                if (tempSum == target) {
                    return tempSum;
                } else if (tempSum > target) {
                    maxIdx--;
                } else {
                    current++;
                }
            }
        }
        return result;
    }
}
