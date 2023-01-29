package Day_3;

public class FindKRotation {

	public static void main(String[] args) {
		int[] arr = { 66, 67, 7, 10, 14, 19, 27, 33, 36, 40, 44, 54, 60 };
		int n = arr.length;
		System.out.println(findKRotation(arr, n));
	}

	static int findKRotation(int arr[], int n) {
		int peak = binarySearch(arr, n);
		return ((peak + 1) % n);
	}

	private static int binarySearch(int[] arr, int n) {
		int left = 0;
		int right = n - 1;
		while (left <= right) {
			int mid = left + ((right - left) >> 1);
			if (mid < right && arr[mid] > arr[mid + 1]) {
				return mid;
			}
			if (mid > left && arr[mid] < arr[mid - 1]) {
				return mid - 1;
			}
			if (arr[mid] > arr[left]) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}
}
