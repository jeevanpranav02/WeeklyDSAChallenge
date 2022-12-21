public class SearchRange {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        System.out.println(searchRange(nums,8).toString());
    }
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        int firstTarget = 0;
        int lastTarget = 0;
        if(nums.length == 0)
        {
            return result;
        }
        for(int i = 0;i < nums.length; i++)
        {
            if(nums[i] == target)
            {
                firstTarget = i;
                break;
            }
            else if(nums[i] != target)
            {
                firstTarget = -1;
            }
    
        }
        for(int j = nums.length - 1; j>=0 ; j--)
        {
            if(nums[j] == target)
            {
                lastTarget = j;
                break;
            }
            else if(nums[j] != target)
            {
                lastTarget = -1;
            }
        }
        result[0] = firstTarget;
        result[1] = lastTarget;
        return result;
    }
}
