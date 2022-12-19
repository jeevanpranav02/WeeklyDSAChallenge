public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] array = {0,0,1,1,1,2,2,3,3,4,4,4,4,4,6,6,6,6,7,7};
        int res = removeDuplicates(array);
        System.out.println(res);
    }

    public static int removeDuplicates(int[] nums) {
        int index = 0;
        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] != nums[index])
            {
                index += 1;
                nums[index] = nums[i];
            }
        }

        if(nums.length == 0) index = 0;
        else index += 1;
        return index;
    }
}
