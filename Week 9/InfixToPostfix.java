package Day_2;

import java.util.ArrayDeque;
import java.util.Deque;

public class InfixToPostfix {
	public static void main(String[] args) {
		String epString = "a+b*(c^d-e)^(f+g*h)-i";
		System.out.println(infixToPostfix(epString));
	}
	static int Prec(char ch) {
		switch (ch) {
		case '+':
		case '-':
			return 1;

		case '*':
		case '/':
			return 2;

		case '^':
			return 3;
		}
		return -1;
	}

	public static String infixToPostfix(String exp) {
		StringBuilder result = new StringBuilder();

		Deque<Character> stack = new ArrayDeque<Character>();

		for (int i = 0; i < exp.length(); ++i) {
			char c = exp.charAt(i);

			if (Character.isLetterOrDigit(c)) {
				result.append(c);
			} else if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					result.append(stack.peek());
					stack.pop();
				}
				stack.pop();
			} else {
				while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())) {
					result.append(stack.peek());
					stack.pop();
				}
				stack.push(c);
			}
		}
		while (!stack.isEmpty()) {
			if (stack.peek() == '(')
				break;
			result.append(stack.peek());
			stack.pop();
		}

		return result.toString();
	}

}
