package ToDo;

import java.util.HashMap;
import java.util.Map;

public class CountUniqueSubString {
    public static void main(String[] args) {
        String s = "aba";
        int k = 2;
        System.out.println(substrCount(s, k));
    }

    static long substrCount(String s, int k) {
        int res = 0;
        for (int start = 0; start < s.length(); start++) {
            Map<Character, Integer> map = new HashMap<>();
            for (int end = start; end < s.length(); end++) {
                int count = map.getOrDefault(s.charAt(end), 0);
                map.put(s.charAt(end), count + 1);
                if (map.size() * k == (end - start + 1)) {
                    if (check(map, k)) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    static boolean check(Map<Character, Integer> map, int k) {
        for (Integer i : map.values()) {
            if (i != k) {
                return false;
            }
        }
        return true;
    }
}
