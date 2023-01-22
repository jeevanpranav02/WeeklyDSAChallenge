package Day_3;

import java.util.Stack;

public class ReverseStack {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(11);
		stack.push(2);
		stack.push(23);
		stack.push(3);
		stack.push(41);
		reverse(stack);
		System.out.println(stack);
	}

	static void reverse(Stack<Integer> s) {
		if (s.empty())
			return;
		int val = s.peek();
		s.pop();
		reverse(s);
		reverseHelper(s, val);
	}

	static void reverseHelper(Stack<Integer> s, int val) {
		if (s.empty())
			s.push(val);
		else {
			int temp = s.peek();
			s.pop();
			reverseHelper(s, val);
			s.push(temp);
		}
	}
}
