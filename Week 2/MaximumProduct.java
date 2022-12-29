public class MaximumProduct {
    public static void main(String[] args) {
        int nums[] = { 3, -1, 4 };
        int nu[] = { -3, -1, -1 };
        int n[] = { 5, -2, -1, 0, 1, 2, 4 };
        System.out.println(maxProduct(nums));
        System.out.println(maxProduct(nu));
        System.out.println(maxProduct(n));
    }

    static int maxProduct(int[] nums) {
        int maximum = nums[0];
        int product = 1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            product *= nums[i];
            maximum = Math.max(maximum, product);
            maximum = Math.max(maximum, nums[i]);
            if (nums[i] == 0) {
                product = Math.max(1, product);
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            product *= nums[i];
            maximum = Math.max(maximum, product);
            maximum = Math.max(maximum, nums[i]);
            if (nums[i] == 0) {
                product = Math.max(1, product);
            }
        }
        return maximum;
    }
}
