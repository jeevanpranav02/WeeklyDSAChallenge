package Day_1;

public class ThirdGreaterNumber {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 ,5};
		System.out.println(thirdMax(nums));
	}

	public static int thirdMax(int[] nums) {
		int n = nums.length;
		int positionOfThirdLargest = -1;
		int large = Integer.MIN_VALUE;
		for (int x : nums) {
			large = Math.max(large, x);
		}
		int secondLarge = Integer.MIN_VALUE;
		int thirdLarge = Integer.MIN_VALUE;

		for (int x : nums) {
			if (x > secondLarge && x != large) {
				secondLarge = x;
			}
		}

		for (int i = 0; i < n; i++) {
			if (nums[i] >= thirdLarge && nums[i] != secondLarge && nums[i] != large) {
				thirdLarge = nums[i];
				positionOfThirdLargest = i;
			}
		}
		if (n == 1) {
			return nums[0];
		} else if (positionOfThirdLargest == -1) {
			return large;
		}
		return thirdLarge;
	}
}
