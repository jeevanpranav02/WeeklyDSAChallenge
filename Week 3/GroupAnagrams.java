import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String str[] = { "eat", "tea", "tan", "ate", "nat", "bat" };
        List<List<String>> list = groupAnagrams(str);
        for (List<String> outer : list) {
            for (String inner : outer) {
                System.out.print(inner + "\t");
            }
            System.out.println();
        }
    }

    static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        int n = strs.length;

        for (int i = 0; i < n; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            StringBuilder key = new StringBuilder();
            for (int k = 0; k < arr.length; k++) {
                key.append(arr[k]);
            }
            if (!map.containsKey(key.toString())) {
                map.put(key.toString(), new ArrayList<>());
                map.get(key.toString()).add(strs[i]);
            } else {
                map.get(key.toString()).add(strs[i]);
            }
        }
        return new ArrayList<>(map.values());
    }
}
