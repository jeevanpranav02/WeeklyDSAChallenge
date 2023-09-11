package Daily_Challenge.LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaximumVowelsSubstringLengthK {
    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;
        System.out.println(maxVowels(s, k));
    }

    private final static Set<Character> VOWELS = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    public static int maxVowels(String s, int k) {
        int left = 0;
        int right = k - 1;
        int maxVowels = 0;
        int count = 0;
        for (int i = 0; i <= right; i++) {
            if (VOWELS.contains(s.charAt(i))) {
                count++;
            }
        }
        maxVowels = count;
        while (right < s.length() - 1) {
            if (VOWELS.contains(s.charAt(left))) {
                count--;
            }
            left++;
            right++;
            if (VOWELS.contains(s.charAt(right))) {
                count++;
            }
            maxVowels = Math.max(count, maxVowels);
        }
        return maxVowels;
    }
}
