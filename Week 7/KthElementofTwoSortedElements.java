package Day_3;

public class KthElementofTwoSortedElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long arr1[] = { 2, 3, 6, 7, 9 };
		long arr2[] = { 1, 4, 8, 10 };
		int n = arr1.length;
		int m = arr2.length;
		int k = 5;
		System.out.println(kthElement(arr1, arr2, n, m, k));
	}

	private static long kthElement(long[] arr1, long[] arr2, int n, int m, int k) {
		if (n > m) {
			return kthElement(arr2, arr1, m, n, k);
		}
		int left = Math.max(0, k - m);
		int right = Math.min(n, k);

		while (left <= right) {
			int mid1 = (left + right) >> 1;
			int mid2 = k - mid1;

			int left1 = (int) (mid1 == 0 ? Integer.MIN_VALUE : arr1[mid1 - 1]);
			int left2 = (int) (mid2 == 0 ? Integer.MIN_VALUE : arr2[mid2 - 1]);
			int right1 = (int) (mid1 == n ? Integer.MAX_VALUE : arr1[mid1]);
			int right2 = (int) (mid2 == m ? Integer.MAX_VALUE : arr2[mid2]);

			if (left1 <= right2 && left2 <= right1) {
				return Math.max(left1, left2);
			} else if (left1 > right2) {
				right = mid1 - 1;
			} else {
				left  = mid1 + 1;
			}
		}
		return 1;
	}
}
