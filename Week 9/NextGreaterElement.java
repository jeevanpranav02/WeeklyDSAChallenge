package Day_4;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 3 };
		System.out.println(Arrays.toString(nextGreaterElements(nums)));
	}

	private static int[] nextGreaterElements(int[] nums) {
		Stack<Integer> stack = new Stack<>();
		for (int i = nums.length - 1; i >= 0; i--) {
			stack.push(nums[i]);
		}
		for (int i = nums.length - 1; i >= 0; i--) {
			int num = nums[i];
			while (!stack.isEmpty() && stack.peek() <= nums[i]) {
				stack.pop();
			}
			nums[i] = stack.empty() ? -1 : stack.peek();
			stack.push(num);
		}

		return nums;
	}
}
