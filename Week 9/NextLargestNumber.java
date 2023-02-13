package Day_4;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextLargestNumber {
	public static void main(String[] args) {
		long[] nums = new long[100];
		String[] strings = (" 5808 5808 4300 4300 8168 8168 9351 9351 4755 4755"
				+ " 6305 6305 1197 1197 8645 8645 7832 7832 9780 9780"
				+ " 5368 5368 5751 5751 7943 7943 5945 5945 6790 6790"
				+ " 6129 6129 2502 2502 5688 5688 8218 8218 3163 3163"
				+ " 9357 9357 5171 5171 2031 2031 8825 8825 4090 4090"
				+ " 6269 6269 2094 2094 7541 7541 9176 9176 9312 9312"
				+ " 2812 2812 8193 8193 5594 5594 8093 8093 4008 4008"
				+ " 8015 8015 512 512 4783 4783 8401 8401 1303 1303 434"
				+ " 434 5525 5525 4406 4406 5313 5313 7795 7795"
				+ " 5769 5769 718 718 5511 5511 433 433 8168 8168").split("\\s");
		int a = 0;
		for(String string : strings) {
			nums[a++] = Long.parseLong(string);
		}
		/* Expected OP :
		 * 8168 8168 8168 8168 9351 9351 9780 9780 6305 6305
		 * 8645 8645 8645 8645 9780 9780 9780 9780 -1 -1 
		 * 5751 5751 7943 7943 8218 8218 6790 6790 8218 8218
		 * 8218 8218 5688 5688 8218 8218 9357 9357 9357 9357 
		 * -1 -1 8825 8825 8825 8825 9176 9176 6269 6269 7541 
		 * 7541 7541 7541 9176 9176 9312 9312 -1 -1 
		 * 8193 8193 8401 8401 8093 8093 8401 8401 8015 8015 
		 * 8401 8401 4783 4783 8401 8401 -1 -1 5525 5525 5525 
		 * 5525 7795 7795 5313 5313 7795 7795 8168 8168 8168 
		 * 8168 5511 5511 8168 8168 8168 8168 -1 -1 
		 */
		nextLargerElement(nums, nums.length);
		int k = 0;
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				System.out.print(" " + nums[k++] + " ");
			}
			System.out.println();
		}
	}
	
	public static long[] nextLargerElement(long[] nums, int N)
    { 
        Map<Long, Long> map = new HashMap<>();
        Stack<Long> stack = new Stack<>();

        for (long n : nums) {
            while (!stack.isEmpty() && stack.peek() < n) {
                map.put(stack.pop(), n);
            }

            stack.push(n);
        }

        for (int i = 0; i < N; i++) {
            nums[i] = map.getOrDefault(nums[i], -1L);
        }

        return nums;
    } 
}
