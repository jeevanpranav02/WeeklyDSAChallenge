package Day_3;

import java.util.Stack;

public class PrefixToPostfix {
	public static void main(String[] args) {
		String string = "*-A/BC-/AKL";
		System.out.println(preToPost(string));
	}

	static String preToPost(String s) {
		String reverse = new StringBuilder(new String(s)).reverse().toString();
		char[] charArray = reverse.toCharArray();
		Stack<String> stack = new Stack<String>();
		for (char c : charArray) {
			if (Character.isAlphabetic(c)) {
				stack.push(c + "");
			} else {
				String op1 = stack.pop();
				String op2 = stack.pop();
				stack.push(op1 + op2 + c);
			}
		}
		return stack.peek();
	}
}
