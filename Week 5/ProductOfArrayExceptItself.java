package Day_4;

import java.util.Arrays;

public class ProductOfArrayExceptItself {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    static int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length < 1) return new int[0];

        int[] array = new int[nums.length];
        Arrays.fill(array,1);
        for(int i = 1; i < nums.length; i++) {
            array[i] = array[i - 1] * nums[i - 1];
        }
        int product = nums[nums.length - 1];
        for(int i = nums.length - 2; i >= 0; i--) {
            array[i] = array[i] * product;
            product *= nums[i];
        }
        return array;
    }
}
