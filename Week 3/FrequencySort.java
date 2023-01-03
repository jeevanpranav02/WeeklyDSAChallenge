import java.util.*;

public class FrequencySort {
    public static void main(String[] args) {
        String s = "ascacaacaDVASCAdv";
        System.out.println(frequencySort(s));
    }

    static String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        List<Character> list = new ArrayList(map.keySet());
        Collections.sort(list, (a, b) -> (map.get(b) - map.get(a)));

        for (char ch : list) {
            for (int i = 0; i < map.get(ch); i++) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
