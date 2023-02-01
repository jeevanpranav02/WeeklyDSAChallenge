package Day_5;

public class SplitArraySum {

	public static void main(String[] args) {
		int[] arr = {7,2,5,10,8};
		int k = 2;
		System.out.println(splitArray(arr, k));
	}

	public static int splitArray(int[] nums, int k) {
		int left = Integer.MIN_VALUE;
		int right = 0;
		for (int num : nums) {
			left = Math.max(left, num);
			right += num;
		}
		while (left < right) {
			int mid = left + ((right - left) >> 1);
			int currentSum = 0;
			int parts = 1;
			for (int num : nums) {
				if (currentSum + num > mid) {
					currentSum = num;
					parts++;
				} else {
					currentSum += num;
				}
			}

			if (parts > k) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;
	}
}
