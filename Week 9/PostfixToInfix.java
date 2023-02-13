package Day_4;

import java.util.Stack;

public class PostfixToInfix {
	public static void main(String[] args) {
		String string = "ab*c+ ";
		System.out.println(postToInfix(string));
	}
	static String postToInfix(String exp) {
        // code here
        Stack<String> stack = new Stack<>();
        for(char c: exp.toCharArray()) {
            if(Character.isAlphabetic(c)) {
                stack.push(Character.toString(c));
            } else {
                String op1 = stack.pop();
                String op2 = stack.pop();
                stack.push("(" + op2 + c + op1 + ")");
            }
        }
        
        return stack.peek();
    }
}
