package Day_1;

import java.util.Stack;

public class AddMinValidParenthesis {

	public static void main(String[] args) {
		String string = "())))";
		System.out.println(minAddToMakeValid(string));
	}

	public static int minAddToMakeValid(String s) {
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (stack.size() > 0 && ch == ')' && s.charAt(stack.peek()) == '(') {
				stack.pop();
			} else {
				stack.push(i);
			}

		}

		return stack.size();
	}

}
