public class TwoPointerRotateArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int k = 3;
        rotateArray(arr, k);
    }

    public static void rotateArray(int[] nums, int k) {
        if(k > nums.length) k = k % nums.length;
        Reverse(nums, 0, nums.length - k - 1);
        Reverse(nums, nums.length - k, nums.length - 1);
        Reverse(nums, 0, nums.length - 1);
    }

    public static void Reverse(int[] nums, int start, int end) {
    while (start <= end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }
}