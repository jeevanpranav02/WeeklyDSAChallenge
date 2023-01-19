package Day_6;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramInAString {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p));
    }

    static List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }
        int[] count = new int[26];
        for (char c : p.toCharArray()) {
            count[(int) c - 'a']++;
        }

        int[] checkPattern = new int[26];

        for (int i = 0; i < p.length(); i++) {
            checkPattern[(int) s.charAt(i) - 'a']++;
        }

        List<Integer> list = new ArrayList<>();

        for (int i = p.length(); i < s.length(); i++) {
            if (areArraysEqual(checkPattern, count)) {
                list.add(i - p.length());
            }
            checkPattern[(int) s.charAt(i) - 'a']++;
            checkPattern[(int) s.charAt(i - p.length()) - 'a']--;
        }
        if (areArraysEqual(checkPattern, count)) {
            list.add(s.length() - p.length());
        }
        return list;
    }

    static boolean areArraysEqual(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
