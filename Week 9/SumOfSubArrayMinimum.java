package Day_6;

import java.util.Stack;

public class SumOfSubArrayMinimum {
	public static void main(String[] args) {
		int[] arr = { 3, 1, 2, 4 };
		System.out.println(sumSubarrayMins(arr));
	}

	public static int sumSubarrayMins(int[] arr) {
		long result = 0;
		Stack<Integer> stack = new Stack<Integer>();
		final long MOD = (long) 1e9 + 7;
		stack.push(-1);

		for (int i = 0; i < arr.length + 1; i++) {
			int currentValue = (i < arr.length) ? arr[i] : 0;
			while (stack.peek() != -1 && currentValue < arr[stack.peek()]) {
				int index = stack.pop();
				int j = stack.peek();
				int left = index - j;
				int right = i - index;
				long add = (long) (left * right * (long) arr[index]) % MOD;
				result += add;
				result %= MOD;
			}
			stack.push(i);
		}

		return (int) result;
	}

//	public static int sumSubarrayMins(int[] nums) {
//        Stack<Integer> s1 = new Stack<>();
//        Stack<Integer> s2 = new Stack<>();
//        
//        int result = 0;
//        int mod = (int) (1e9 + 7);
//        int n = nums.length;
//        
//        int[] nextSmaller = new int[n];
//        int[] prevSmaller = new int[n];
//        
//        for(int i = 0; i < n; i++) {
//            nextSmaller[i] = n - i - 1;
//            prevSmaller[i] = i;
//        }
//
//        for(int i = 0; i < n; i++) {
//            while(!s1.isEmpty() && nums[s1.peek()] > nums[i]) {
//                nextSmaller[s1.peek()] = i - s1.peek() - 1;
//                s1.pop();
//            }
//            s1.push(i);
//        }
//
//        for(int i = n - 1; i >= 0; i--) {
//            while(!s2.isEmpty() && nums[s2.peek()] >= nums[i]) {
//                prevSmaller[s2.peek()] = s2.peek() - i - 1;
//                s2.pop();
//            }
//            s2.push(i);
//        }
//
//        for(int i = 0; i < n; i++) {
//            result += (nums[i] * (prevSmaller[i] + 1) * (nextSmaller[i] + 1));
//            result %= mod;
//        }
//
//        return result;
//    }

// Method for O(n^2) 
//	public static int sumSubarrayMins(int[] arr) {
//		List<List<Integer>> result = generatedSubArrays(arr);
//		int sum = 0;
//		int mod = (int) (1e9 + 7);
//		for (List<Integer> list : result) {
//			sum = (sum + Collections.min(list)) % mod;
//		}
//		return sum;
//	}
//
//	public static List<List<Integer>> generatedSubArrays(int[] nums) {
//		List<List<Integer>> result = new ArrayList<>();
//		List<List<Integer>> inProgress = new ArrayList<>();
//
//		for (int next : nums) {
//			List<List<Integer>> proceedWith = new ArrayList<>();
//
//			for (List<Integer> subArr : inProgress) {
//				result.add(subArr);
//
//				List<Integer> copy = new ArrayList<>(subArr);
//				copy.add(next);
//				proceedWith.add(copy);
//			}
//			proceedWith.add(List.of(next));
//			inProgress = proceedWith;
//		}
//
//		result.addAll(inProgress);
//
//		return result;
//	}
}
