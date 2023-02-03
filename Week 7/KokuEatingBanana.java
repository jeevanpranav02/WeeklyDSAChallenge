package Day_7;

public class KokuEatingBanana {

	public static void main(String[] args) {
		int[] piles = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int h = 5;
		System.out.println(minEatingSpeed(piles, h));
	}

	public static int minEatingSpeed(int[] piles, int h) {
		int left = 1;
		int right = 1;
		for (int i = 0; i < piles.length; i++) {
			right = Math.max(right, piles[i]);
		}
		while (left < right) {
			int mid = left + ((right - left) >> 1);
			int hr = 0;
			for (int i = 0; i < piles.length; i++) {
				hr += piles[i] / mid;
				if (piles[i] % mid != 0) {
					hr++;
				}
			}
			if (hr <= h) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

}
