package Daily_Challenge.GFG;

public class PalindromeWithMinimumSum {
    public static int minimumSum(String s) {
        int index = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '?') {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return 0;
        }
        int ans = 0;
        char prev = s.charAt(index);
        for (int i = index; i < s.length() / 2; i++) {
            char x = s.charAt(i);
            char y = s.charAt(s.length() - i - 1);
            if (x != '?' && y != '?') {
                if (x == y) {
                    ans += Math.abs(prev - x);
                    prev = x;
                } else {
                    return -1;
                }
            } else if (x == '?' && y == '?') {
                continue;
            } else {
                if (x != '?') {
                    ans += Math.abs(prev - x);
                    prev = x;
                } else {
                    ans += Math.abs(prev - y);
                    prev = y;
                }
            }
        }
        prev = s.charAt(index);
        for (int i = index - 1; i >= 0; i--) {
            char x = s.charAt(i);
            char y = s.charAt(s.length() - i - 1);
            if (x != '?' && y != '?') {
                if (x == y) {
                    ans += Math.abs(prev - x);
                    prev = x;
                    continue;
                } else {
                    return -1;
                }
            } else if (x == '?' && y == '?') {
                continue;
            } else {
                if (x != '?') {
                    ans += Math.abs(prev - x);
                    prev = x;
                } else {
                    ans += Math.abs(prev - y);
                    prev = y;
                }
            }
        }
        return ans * 2;
    }
}
