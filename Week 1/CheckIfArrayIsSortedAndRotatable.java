public class CheckIfArrayIsSortedAndRotatable {
    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        System.out.println(check(nums));
    }
    public static boolean check(int[] nums) {   
        boolean flag = false;
        for(int i = 0; i<nums.length-1; ++i) {
            if (nums[i] > nums[i+1])
                if (flag)
                    return false;
                else
                    flag = true;
        }
		return !flag || nums[nums.length-1] <= nums[0];
    }
}
