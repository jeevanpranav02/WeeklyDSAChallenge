package Day_3;

import java.util.Stack;

public class PostfixToPrefix {
	public static void main(String[] args) {
		String string = "ABC/-AK/L-*";
		System.out.println(postToPre(string));
	}

	static String postToPre(String s) {
		Stack<String> stack = new Stack<String>();
		for (char c : s.toCharArray()) {
			if (Character.isAlphabetic(c)) {
				stack.push(c + "");
			} else {
				String op1 = stack.pop();
				String op2 = stack.pop();
				stack.push(c + op2 + op1);
			}
		}
		return new StringBuilder(stack.peek()).toString();
	}
}
