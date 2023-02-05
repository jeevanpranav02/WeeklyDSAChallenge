package Day_3;

import java.util.Arrays;

public class SetMismatch {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 5, 4, 6, 7, 8, 8 };
		System.out.println(Arrays.toString(findErrorNums(nums)));
	}

	public static int[] findErrorNums(int[] nums) {
		int i = 0;
		while (i < nums.length) {
			int correctIndex = nums[i] - 1;
			if (nums[i] != nums[correctIndex]) {
				swap(nums, i, correctIndex);
			} else {
				i++;
			}
		}
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] != j + 1) {
				return new int[] { nums[j], j + 1 };
			}
		}
		return new int[] { -1, -1 };
	}

	private static void swap(int[] nums, int i, int j) {
		nums[i] ^= nums[j];
		nums[j] ^= nums[i];
		nums[i] ^= nums[j];
	}
}
