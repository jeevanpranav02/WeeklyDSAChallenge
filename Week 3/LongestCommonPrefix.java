import java.util.Arrays;
import java.util.Comparator;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strings = { "abab", "aba", "abc" };
        System.out.println(longestCommonPrefix(strings));
    }

    static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs, Comparator.comparingInt(String::length));
        int smallestStringLength = strs[0].length();
        int n = strs.length;
        String first = strs[0];
        String last = strs[n - 1];
        int i = 0;
        while (i < smallestStringLength) {
            if (first.charAt(i) == last.charAt(i)) {
                i++;
            } else {
                break;
            }
        }
        return i == 0 ? "" : first.substring(0, i);
    }
}
