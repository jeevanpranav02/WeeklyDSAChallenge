package Day_2;

import java.util.ArrayList;
import java.util.List;

public class FindMissingNumber {

	public static void main(String[] args) {
		int nums[] = { 1, 5, 4, 9, 8, 6, 5, 2, 3 };
		System.out.println(findDisappearedNumbers(nums));
	}

	public static List<Integer> findDisappearedNumbers(int[] nums) {
		int i = 0;
		List<Integer> list = new ArrayList<>();
		while (i < nums.length) {
			int correct = nums[i] - 1;
			if (nums[i] != nums[correct]) {
				swap(nums, i, correct);
			} else {
				i++;
			}
		}
		for (int index = 0; index < nums.length; index++) {
			if (index + 1 != nums[index]) {
				list.add(index + 1);
			}
		}
		return list;
	}

	private static void swap(int[] nums, int i, int j) {
		nums[i] ^= nums[j];
		nums[j] ^= nums[i];
		nums[i] ^= nums[j];
	}

}
