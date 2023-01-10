package Day_5;

import java.util.*;

public class RepeatedDNASequences {
    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(findRepeatedDnaSequences(s));
    }

    static List<String> findRepeatedDnaSequences(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);
        Set<Integer> candidates = new HashSet<>();
        Set<String> duplicates = new HashSet<>();
        int cur = 0;
        for (int i = 0; i < s.length(); i++) {
            cur %= 1 << 18;
            cur = cur * 4 + map.get(s.charAt(i));
            if (i < 9) continue;
            if (candidates.contains(cur)) {
                duplicates.add(s.substring(i - 9, i + 1));
            } else {
                candidates.add(cur);
            }
        }
        return new ArrayList<String>(duplicates);
    }
}
