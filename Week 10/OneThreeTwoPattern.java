package Day_2;

import java.util.TreeMap;

public class OneThreeTwoPattern {
	public static void main(String[] args) {
		int[] nums = { 3, 1, 4, 2 };
		System.out.println(find132pattern(nums));
	}

	public static boolean find132pattern(int[] nums) {
		int n = nums.length;
		if (n < 3) {
			return false;
		}

		TreeMap<Integer, Integer> rightMap = new TreeMap<>();
		for (int i = 2; i < n; i++) {
			rightMap.put(nums[i], rightMap.getOrDefault(nums[i], 0) + 1);
		}

		int leftMin = nums[0];
		for (int j = 1; j < n - 1; j++) {
			if (leftMin < nums[j]) {
				Integer numK = rightMap.ceilingKey(leftMin + 1);
				if (numK != null && numK < nums[j]) {
					return true;
				}
			}

			leftMin = Math.min(leftMin, nums[j]);
			rightMap.put(nums[j + 1], rightMap.get(nums[j + 1]) - 1);
			if (rightMap.get(nums[j + 1]) == 0) {
				rightMap.remove(nums[j + 1]);
			}
		}

		return false;
	}
}
