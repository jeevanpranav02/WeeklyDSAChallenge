package Day_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonCharacters {
	public static void main(String[] args) {
		String[] strings = {"roller","lla","label"};
		System.out.println(commonChars(strings));
	}
	static List<String> commonChars(String[] words) {
		List<String> list = new ArrayList<>();
        if (words == null || words.length == 0) {
            return list;
        }
        Map<Character, Integer> countAllString = new HashMap<>();
        for (char ch : words[0].toCharArray()) {
            countAllString.put(ch, countAllString.getOrDefault(ch, 0) + 1);
        }
        for (int i = 1; i < words.length; i++) {
            Map<Character, Integer> currentCount = new HashMap<>();
            for (char ch : words[i].toCharArray()) {
                if (countAllString.getOrDefault(ch, 0) > 0) {
                    countAllString.put(ch, countAllString.getOrDefault(ch, 0) - 1);
                    currentCount.put(ch, currentCount.getOrDefault(ch, 0) + 1);
                }
            }
            countAllString = currentCount;
        }
        for (Map.Entry<Character, Integer> entry : countAllString.entrySet()) {
            for(int i=0;i< entry.getValue(); i++){
                list.add(String.valueOf(entry.getKey()));
            }
        }
        return list;
	}
}
