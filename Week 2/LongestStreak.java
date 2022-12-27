import java.util.Arrays;

public class LongestStreak {
    public static void main(String[] arg)
    {
        int[] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }
    static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        int currCount = 1;
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int prev = nums[i - 1]  + 1;
            if (nums[i] != nums[i-1]) {    
                if ( curr == prev ) {
                    currCount += 1;
                }
                else {
                    count = Math.max(count, currCount);
                    currCount = 1;
                }
            }
        }
        return Math.max(count, currCount);   
    }
}