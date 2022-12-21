public class Insertion {

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        System.out.println(searchInsert(nums,5));
    }

    public static int searchInsert(int[] nums, int target) {
        int i;
        for(i = 0; nums[i] <= target && i < nums.length-1 ; i++)
        {
            if(nums[i] >= target)
            {
                return i;
            }
        }
        if(target > nums[nums.length - 1])
        {
            return i + 1;
        }
        else
        {
            return i;
        }
    }
}