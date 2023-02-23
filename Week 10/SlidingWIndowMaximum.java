package Day_6;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class SlidingWIndowMaximum {
	public static void main(String[] args) {
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;
		System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
	}

	public static int[] maxSlidingWindow(int[] nums, int k) {
		int len = nums.length;
		List<Integer> list = new ArrayList<>(len);
		Deque<Integer> queue = new ArrayDeque<>();

		for (int i = 0; i < len; i++) {
			if (!queue.isEmpty() && queue.peek() == i - k) {
				queue.poll();
			}
			while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
				queue.pollLast();
			}
			queue.offer(i);
			if (i >= k - 1) {
				list.add(nums[queue.peek()]);
			}
		}
		int[] result = list.stream().mapToInt(a -> a).toArray();
		return result;
	}
}
