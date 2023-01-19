package Daily_Challenges;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumsDivisibleByK {
    public static void main(String[] args) {
        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;
        System.out.println(subarraysDivByK(nums, k));
        ;
    }

    static int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum % k;
            if (rem < 0) {
                rem = rem + k;
            }
            if (map.containsKey((rem))) {
                count += map.get(rem);

            }
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        return count;
    }
}
