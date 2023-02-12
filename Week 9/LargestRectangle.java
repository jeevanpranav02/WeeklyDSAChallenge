package Day_3;

import java.util.Stack;

public class LargestRectangle {
	public static void main(String[] args) {
		int[] nums = { 2, 1, 5, 6, 2, 3 };
		System.out.println(largestRectangleArea(nums));
	}

	public static int largestRectangleArea(int[] heights) {
		Stack<Integer> stack = new Stack<>();
		int max = 0;
		stack.push(0);
		for (int i = 0; i < heights.length; i++) {
			while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
				max = findMaximum(heights, stack, max, i);
			}
			stack.push(i);
		}
		int i = heights.length;
		while (!stack.isEmpty()) {
			max = findMaximum(heights, stack, max, i);
		}
		return max;
	}

	private static int findMaximum(int[] nums, Stack<Integer> stack, int max, int i) {
		int area;
		int popped = stack.pop();
		if (stack.isEmpty()) {
			area = nums[popped] * i;
		} else {
			area = nums[popped] * (i - 1 - stack.peek());
		}
		return Math.max(max, area);
	}
}
