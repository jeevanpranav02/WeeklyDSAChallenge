public class SortColors {
    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0};
        sortColors(arr);
        for(int a:arr)
        {
            System.out.println(a);
        }

    }
    static void sortColors(int[] nums)
    {
        for (int a = 1; a < nums.length; ++a) {
            int temp = nums[a];
            int b = a - 1;
            while (b >= 0 && nums[b] > temp) {
                nums[b + 1] = nums[b];
                b = b - 1;
            }
            nums[b + 1] = temp;
        }
    }
}
