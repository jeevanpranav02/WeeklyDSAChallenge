package Biweekly_Contest_97;

import java.util.ArrayList;
import java.util.List;

public class SeperateDigitsInArray {

	public static void main(String[] args) {
		int nums[] = { 13, 25, 83, 77 };
		System.out.println(separateDigits(nums));
	}

	public static int[] separateDigits(int[] nums) {
		List<Integer> list = new ArrayList<>();
		for (int num : nums) {
			String n = Integer.toString(num);
			for (int i = 0; i < n.length(); i++) {
				list.add(Integer.parseInt(Character.toString(n.charAt(i))));
			}
		}
		int[] array = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			array[i] = list.get(i);
		}
		return array;
	}

}
