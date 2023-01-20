package Day_1;

public class BinaryClass {
	public static void main(String[] args) {
		int[] array = { -1, 0, 5 };
		int target = -1;
		System.out.println(search(array, target));
	}

	public static int search(int[] nums, int target) {
		return binarySearch(nums, target, 0, nums.length - 1);
	}

	static int binarySearch(int[] nums, int target, int start, int end) {
		if (start > end) {
			return -1;
		}
		int mid = start + ((end - start) >> 1);
		if (target == nums[mid]) {
			return mid;
		} else {
			if (target < nums[mid]) {
				return binarySearch(nums, target, start, mid - 1);
			}
			return binarySearch(nums, target, mid + 1, end);
		}
	}
}
