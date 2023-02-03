package Daily_Challenge;

import java.util.HashMap;
import java.util.Map;

public class AlienString {

	public static void main(String[] args) {
		String[] wordStrings = { "hello", "leetcode" };
		String orderString = "hlabcdefgijkmnopqrstuvwxyz";
		System.out.println(isAlienSorted(wordStrings, orderString));
	}

	static Map<Character, Integer> map = new HashMap<>();

	public static boolean isAlienSorted(String[] words, String order) {
		int n = words.length;

		for (int i = 0; i < 26; i++) {
			map.put(order.charAt(i), i);
		}

		for (int i = 0; i < n - 1; i++) {
			if (!checkOrder(words[i], words[i + 1])) {
				return false;
			}
		}
		return true;
	}

	private static boolean checkOrder(String s1, String s2) {
		int maxString = Math.max(s1.length(), s2.length());

		for (int i = 0; i < maxString; i++) {
			int c1 = i < s1.length() ? map.get(s1.charAt(i)) : -1;
			int c2 = i < s2.length() ? map.get(s2.charAt(i)) : -1;

			if (c1 == c2) {
				continue;
			} else if (c1 < c2) {
				return true;
			} else {
				return false;
			}
		}

		return true;
	}
}
