package Day_2;

import java.util.Arrays;

public class TwoSumII {
	public static void main(String[] args) {
		int[] numbers = { 25, 50, 75, 90 };
		int target = 100;
		System.out.println(Arrays.toString(twoSum(numbers, target)));
	}

	static int[] twoSum(int[] numbers, int target) {
		if (numbers[0] + numbers[numbers.length - 1] == target) {
			return new int[] { 1, numbers.length };
		}
		int[] result = new int[] { -1, -1 };
		int n = numbers.length;
		for (int i = 0; i < n; ++i) {
			int left = i + 1;
			int right = n - 1;
			while (left <= right) {
				int mid = left + ((right - left) >> 1);
				if (numbers[i] + numbers[mid] == target) {
					result[0] = i + 1;
					result[1] = mid + 1;
					break;
				} else if (numbers[i] + numbers[mid] > target) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
		}
		return result;
	}
}
