package Day_1;

public class SumOfSubArrayRange {
	public static void main(String[] args) {
		int[] nums = { 1, 3, 3 };
		System.out.println(subArrayRanges(nums));
	}

	public static long subArrayRanges(int[] nums) {
		long result = 0;
		for (int i = 0; i < nums.length; i++) {
			int maximum = nums[i], minimum = nums[i];
			for (int j = i; j < nums.length; j++) {
				maximum = Math.max(maximum, nums[j]);
				minimum = Math.min(minimum, nums[j]);
				result += maximum - minimum;
			}
		}
		return result;
	}
}
