package Day_6;

import java.util.Arrays;

public class LargestNumber {
	public static void main(String[] args) {
		int[] nums = { 3, 30, 34, 5, 9 };
		System.out.println(largestNumber(nums));
	}

	public static String largestNumber(int[] nums) {
		String[] string = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			string[i] = String.valueOf(nums[i]);
		}
		Arrays.sort(string, (o1, o2) -> {
			String s1 = o1 + o2;
			String s2 = o2 + o1;
			return s2.compareTo(s1);
		});

		if (string[0].equals("0")) {
			return string[0];
		}
		StringBuilder strBldr = new StringBuilder(nums.length);
		for (String s : string) {
			strBldr.append(s);
		}
		return strBldr.toString();
	}
}
