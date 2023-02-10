package Day_7;

public class MinimumSumSubarray {
	public static void main(String[] args) {
		int nums[] = { 2, 3, 1, 2, 4, 3 };
		int target = 7;
		System.out.println(minSubArrayLen(target, nums));
	}

	public static int minSubArrayLen(int target, int[] nums) {
		int len = nums.length;
		int start = 0;
		int end = 0;
		int min = len + 1;

		while (end < len) {
			target -= nums[end];
			end++;

			while (target <= 0) {
				min = Math.min(min, end - start);
				target += nums[start];
				start++;
			}
		}

		return min % (len + 1);
	}
}
