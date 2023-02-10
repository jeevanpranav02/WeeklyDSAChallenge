package Daily_Challenges;

public class ShuffleArray {
	public static void main(String[] args) {
		int[] nums = { 2, 5, 1, 3, 4, 7 };
		int n = nums.length / 2;
		System.out.println(shuffle(nums, n));
	}

	public static int[] shuffle(int[] nums, int n) {
		int[] ans = new int[2 * n];
		for (int i = 0; i < n; i++) {
			ans[2 * i] = nums[i];
			ans[2 * i + 1] = nums[i + n];
		}
		return ans;
	}
}
