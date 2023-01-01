import java.util.*;

public class WordPattern {
    public static void main(String[] args) {
        String pattern = "adda";
        String s = "dog cat cat dog";
        System.out.println(wordPattern(pattern, s));
    }

    static boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");

        if (arr.length != pattern.length())
            return false;

        Map<Character, String> map = new HashMap<Character, String>();

        for (int i = 0; i < arr.length; i++) {

            char c = pattern.charAt(i);
            String str = arr[i];

            if (map.containsKey(c)) {

                if (!map.get(c).equals(str))
                    return false;

            } else {

                if (map.containsValue(str))
                    return false;

                map.put(c, str);

            }
        }
        return true;
    }
}
