package Day_1;

public class FindMinimumInRotatedSortedArray {

	public static void main(String[] args) {
		int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
		System.out.println(findMin(arr));
	}

	static int findMin(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		boolean isRotated = false;
		if (nums[left] > nums[right]) {
			isRotated = true;
		} else {
			return nums[left];
		}
		if (isRotated) {
			while (left < right) {
				int mid = left + ((right - left) >> 1);
				if (nums[mid] > nums[mid + 1]) {
					return nums[mid + 1];
				}
				if (nums[mid - 1] > nums[mid]) {
					return nums[mid];
				}
				if (nums[mid] > nums[0]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}
		return Integer.MAX_VALUE;
	}
}
