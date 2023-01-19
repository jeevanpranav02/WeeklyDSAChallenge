package Day_7;

import java.util.HashMap;
import java.util.Map;

public class ContinousSubArraySum {
    public static void main(String[] args) {
        int[] nums = {23, 2, 4, 6, 6};
        int k = 7;
        System.out.println(checkSubarraySum(nums, k));
    }

    static boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, 0);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (!map.containsKey(sum % k)) {
                map.put(sum % k, i + 1);
            } else if (map.get(sum % k) < i) {
                return true;
            }
        }
        return false;
    }
}
