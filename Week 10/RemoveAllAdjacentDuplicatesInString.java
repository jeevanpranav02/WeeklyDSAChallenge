package Day_7;

import java.util.LinkedList;

public class RemoveAllAdjacentDuplicatesInString {
	public static void main(String[] args) {
		String string = "aaaaaaaa";
		System.out.println(removeDuplicates(string));
	}

	public static String removeDuplicates(String s) {
		LinkedList<Character> list = new LinkedList<>();
		for (char c : s.toCharArray()) {
			if (!list.isEmpty()) {
				if (list.peekLast() == c) {
					list.pollLast();
				} else {
					list.add(c);
				}
			} else {
				list.push(c);
			}
		}
		StringBuilder sb = new StringBuilder("");
		if (!list.isEmpty()) {
			while (!list.isEmpty()) {
				sb.append(list.pollLast());
			}
		}
		return sb.reverse().toString();
	}
}
