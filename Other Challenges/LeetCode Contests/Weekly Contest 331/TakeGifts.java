package Weekly_Contest_331;

public class TakeGifts {

	public static void main(String[] args) {
		int[] gifts = { 25, 64, 9, 4, 100 };
		int k = 4;
		System.out.println(pickGifts(gifts, k));
	}

	public static long pickGifts(int[] gifts, int k) {
		int n = gifts.length;
		long sum = 0;
		for (int i = 0; i < k; i++) {
			int index = findMax(gifts);
			gifts[index] = (int) Math.floor(Math.sqrt(gifts[index]));
		}
		for (int remained : gifts) {
			sum += (long) remained;
		}
		return sum;
	}

	private static int findMax(int[] nums) {
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			max = nums[i] > nums[max] ? i : max;
		}
		return max;
	}

}
