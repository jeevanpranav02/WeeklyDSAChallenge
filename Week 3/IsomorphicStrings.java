import java.util.HashMap;

public class IsomorphicStrings {
    public static void main(String[] args) {
        String s = "paper";
        String t = "title";
        System.out.println(isIsomorphic(s, t));
    }

    static boolean isIsomorphic(String s, String t) {
        if (s == null || s.length() <= 1)
            return true;
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++) {
            char charOfString1 = s.charAt(i);
            char charOfString2 = t.charAt(i);
            if (map.containsKey(charOfString1)) {
                if (map.get(charOfString1).equals(charOfString2))
                    continue;
                else
                    return false;
            } else {
                if (!map.containsValue(charOfString2))
                    map.put(charOfString1, charOfString2);
                else
                    return false;

            }
        }
        return true;
    }
}
