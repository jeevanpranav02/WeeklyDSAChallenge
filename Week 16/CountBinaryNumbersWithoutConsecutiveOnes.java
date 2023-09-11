package Daily_Challenge.Todo.GFG;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class CountBinaryNumbersWithoutConsecutiveOnes {
    public static void main(String[] args) {
        long n = 10;
        System.out.println(countStrings(n));
    }

    public static int countStrings(long n) {
        Map<String, Integer> memo = new HashMap<>();
        Deque<State> stack = new ArrayDeque<>();
        stack.push(new State(new StringBuilder(), 0));
        int count = 0;

        while (!stack.isEmpty()) {
            State state = stack.pop();
            StringBuilder sb = state.sb;
            int idx = state.idx;

            if (idx == n) {
                count++;
                continue;
            }

            String key = sb.toString() + idx;
            if (memo.containsKey(key)) {
                count += memo.get(key);
                continue;
            }

            // Add a '0' to the string
            sb.append('0');
            stack.push(new State(new StringBuilder(sb), idx + 1));
            sb.deleteCharAt(sb.length() - 1);

            // If the previous digit is not '1', add a '1' to the string
            if (sb.length() == 0 || sb.charAt(sb.length() - 1) != '1') {
                sb.append('1');
                stack.push(new State(new StringBuilder(sb), idx + 1));
                sb.deleteCharAt(sb.length() - 1);
            }

            memo.put(key, count);
        }

        return count;
    }

    private static class State {
        StringBuilder sb;
        int idx;

        State(StringBuilder sb, int idx) {
            this.sb = sb;
            this.idx = idx;
        }
    }
}
