package Day_5;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
	public static void main(String[] args) {
		int n = 3;
		System.out.println(generateParenthesis(n));
	}

	public static List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<>();
		generateHelperList(list, 0, 0, "", n);
		return list;
	}

	public static void generateHelperList(List<String> list, int left, int right, String p, int n) {
		if (p.length() == 2 * n) {
			list.add(p);
			return;
		}
		if (left < n) {
			generateHelperList(list, left + 1, right, p + '(', n);
		}
		if (right < left) {
			generateHelperList(list, left, right + 1, p + ')', n);
		}
	}
}
