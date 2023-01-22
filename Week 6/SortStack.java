package Day_3;

import java.util.Stack;

public class SortStack {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(11);
		stack.push(2);
		stack.push(23);
		stack.push(3);
		stack.push(41);
		System.out.println(sort(stack));
	}

	public static Stack<Integer> sort(Stack<Integer> s) {
		if (s.size() == 1)
			return s;
		int top = s.peek();
		s.pop();
		s = sort(s);
		return correctIn(top, s);
	}

	public static Stack<Integer> correctIn(int num, Stack<Integer> s) {
		if (s.isEmpty() || num > s.peek()) {
			s.push(num);
			return s;
		} else {
			int temp = s.peek();
			s.pop();
			s = correctIn(num, s);
			s.push(temp);
			return s;
		}
	}
}
