package Day_2;

import java.util.Stack;

public class DecodeString {
	public static void main(String[] args) {
		String string = "3[a2[c]]";
		System.out.println(decodeString(string));
	}

	public static String decodeString(String s) {
		String result = "";
		Stack<Integer> countStack = new Stack<>();
		Stack<String> resultStack = new Stack<>();
		int idx = 0;
		while (idx < s.length()) {
			if (Character.isDigit(s.charAt(idx))) {
				int count = 0;
				while (Character.isDigit(s.charAt(idx))) {
					count = 10 * count + (s.charAt(idx) - '0');
					idx++;
				}
				countStack.push(count);
			} else if (s.charAt(idx) == '[') {
				resultStack.push(result);
				result = "";
				idx++;
			} else if (s.charAt(idx) == ']') {
				StringBuilder temp = new StringBuilder(resultStack.pop());
				int repeatCount = countStack.pop();
				for (int i = 0; i < repeatCount; i++) {
					temp.append(result);
				}
				result = temp.toString();
				idx++;
			} else {
				result += s.charAt(idx++);
			}
		}
		return result;
	}
}
