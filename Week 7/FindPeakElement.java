package Day_1;

public class FindPeakElement {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 1, 3, 5, 6, 4 };
		System.out.println(findPeakElement(arr));
	}

	static int findPeakElement(int[] nums) {
		if (nums.length < 2) {
			return 0;
		}

		int n = nums.length;

		if (nums[0] > nums[1]) {
			return 0;
		}
		if (nums[n - 1] > nums[n - 2]) {
			return n - 1;
		}

		int left = 1;
		int right = nums.length - 2;

		while (left <= right) {
			int mid = left + ((right - left) >> 1);
			if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
				return mid;
			} else if (nums[mid] < nums[mid - 1]) {
				right = mid - 1;
			} else if (nums[mid] < nums[mid + 1]) {
				left = mid + 1;
			}
		}
		return Integer.MAX_VALUE;
	}
}
