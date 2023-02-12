package Day_3;

import java.util.Stack;

public class PrefixToInfix {
	public static void main(String[] args) {
		String expString = "*-A/BC-/AKL";
		System.out.println(preToInfix(expString));
	}

	private static String preToInfix(String s) {
		String reverse = new StringBuilder(new String(s)).reverse().toString();
		char[] charArray = reverse.toCharArray();
		Stack<String> st = new Stack<>();
		for (char c : charArray) {
			if (Character.isAlphabetic(c)) {
				st.push("" + c);
			} else {
				String op1 = st.pop();
				String op2 = st.pop();
				st.push("" + '(' + op1 + c + op2 + ')');
			}
		}
		return st.peek();
	}
}
