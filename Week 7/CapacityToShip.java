package Day_7;

class CapacityToShip {

	public static void main(String[] args) {
		int[] weights = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int days = 5;
		System.out.println(shipWithinDays(weights, days));
	}

	public static int shipWithinDays(int[] weights, int days) {
		int left = 0;
		int right = 0;

		for (int i = 0; i < weights.length; i++) {
			left = Math.max(left, weights[i]);
			right += weights[i];
		}

		while (left < right) {
			int mid = left + (right - left) / 2;
			int sum = 0;
			int pieces = 1;
			for (int num : weights) {
				if (sum + num > mid) {
					sum = num;
					pieces++;
				} else {
					sum += num;
				}
			}

			if (pieces > days) {
				left = mid + 1;
			} else {
				right = mid;
			}

		}
		return right;
	}
}
