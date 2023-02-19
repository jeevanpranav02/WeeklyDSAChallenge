package Day_3;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class FindMostCompetetiveSubSequence {
	public static void main(String[] args) {
		int[] nums = { 3, 5, 2, 6 };
		int k = 2;
		System.out.println(Arrays.toString(mostCompetitive(nums, k)));
	}

	public static int[] mostCompetitive(int[] nums, int k) {
		if (nums.length == k) {
			return nums;
		}
		int n = nums.length;
		int remaining = n;
		Deque<Integer> stack = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			remaining = n - i - 1;
			while (!stack.isEmpty() && stack.size() + remaining >= k && stack.peek() > nums[i]) {
				stack.pop();
			}
			stack.push(nums[i]);
		}
		Deque<Integer> reverseStack = new LinkedList<>();
		while (!stack.isEmpty()) {
			reverseStack.push(stack.pop());
		}
		int[] result = new int[k];
		int j = 0;
		while (j < k && !reverseStack.isEmpty()) {
			result[j++] = reverseStack.peek();
			reverseStack.pop();
		}
		return result;
	}
}
