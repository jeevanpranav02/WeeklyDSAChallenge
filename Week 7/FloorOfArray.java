package Day_3;

public class FloorOfArray {

	public static void main(String[] args) {
		long arr[] = {1,2,8,10,11,12,19};
		long x = 15;
		System.out.println(findFloor(arr, arr.length, x));
	}

	static int findFloor(long arr[], int n, long x) {
		if (x <= arr[0]) {
			return -1;
		}
		if (x >= arr[n - 1]) {
			return n - 1;
		}
		int left = 0;
		int right = n - 1;
		while (left <= right) {
			int mid = left + ((right - left) >> 1);
			if (arr[mid] == x) {
				return mid;
			} else if (arr[mid] > x) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return right;
	}

}
