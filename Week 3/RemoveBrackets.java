import java.util.*;

public class RemoveBrackets {
    public static void main(String[] args) {
        String s = "(()())(())(()(()))";
        System.out.println(removeOuterParentheses(s));
    }

    static String removeOuterParentheses(String S) {
        Stack<String> stack = new Stack<>();
        String result = "";
        for (int i = 0; i < S.length(); i++) {
            String ch = Character.toString(S.charAt(i));
            if (ch.equals("(")) {
                if (stack.size() >= 1) {
                    result += ch;
                }
                stack.push(ch);
            } else {
                if (stack.size() > 1) {
                    result += ch;
                }
                stack.pop();
            }
        }
        return result;
    }
}
