package Day_5;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfPhoneNumber {
	public static void main(String[] args) {
		String digitString = "";
		System.out.println(letterCombinations(digitString));
//		System.out.println(letterCombinationsCount(digitString));
	}

	static int letterCombinationsCount(String digits) {
		if (digits.isEmpty()) {
			return 0;
		}
		return combinationHelperCount("", digits);
	}

	static int combinationHelperCount(String p, String np) {
		if (np.isEmpty()) {
			return 1;
		}

		int count = 0;
		int digit = np.charAt(0) - '0';

		if (digit >= 2 && digit <= 6) {
			for (int i = (digit - 2) * 3; i <= ((digit - 1) * 3) - 1; i++) {
				char ch = (char) ('a' + i);
				count += combinationHelperCount(p + ch, np.substring(1));
			}
		} else if (digit == 7) {
			for (int i = (digit - 2) * 3; i < ((digit - 1) * 3) + 1; i++) {
				char ch = (char) ('a' + i);
				count += combinationHelperCount(p + ch, np.substring(1));
			}
		} else if (digit == 9) {
			for (int i = (digit - 2) * 3 + 1; i <= ((digit - 1) * 3) + 1; i++) {
				char ch = (char) ('a' + i);
				count += combinationHelperCount(p + ch, np.substring(1));
			}
		} else {
			for (int i = (digit - 2) * 3 + 1; i < ((digit - 1) * 3) + 1; i++) {
				char ch = (char) ('a' + i);
				count += combinationHelperCount(p + ch, np.substring(1));
			}
		}
		return count;
	}

	static List<String> letterCombinations(String digits) {
		if (digits.isEmpty()) {
			return new ArrayList<String>();
		}
		return combinationHelper("", digits);
	}

	static List<String> combinationHelper(String p, String np) {
		if (np.isEmpty()) {
			List<String> list = new ArrayList<>();
			list.add(p);
			return list;
		}

		int digit = np.charAt(0) - '0';
		List<String> list = new ArrayList<>();

		if (digit >= 2 && digit <= 6) {
			for (int i = (digit - 2) * 3; i <= ((digit - 1) * 3) - 1; i++) {
				char ch = (char) ('a' + i);
				list.addAll(combinationHelper(p + ch, np.substring(1)));
			}
		} else if (digit == 7) {
			for (int i = (digit - 2) * 3; i < ((digit - 1) * 3) + 1; i++) {
				char ch = (char) ('a' + i);
				list.addAll(combinationHelper(p + ch, np.substring(1)));
			}
		} else if (digit == 9) {
			for (int i = (digit - 2) * 3 + 1; i <= ((digit - 1) * 3) + 1; i++) {
				char ch = (char) ('a' + i);
				list.addAll(combinationHelper(p + ch, np.substring(1)));
			}
		} else {
			for (int i = (digit - 2) * 3 + 1; i < ((digit - 1) * 3) + 1; i++) {
				char ch = (char) ('a' + i);
				list.addAll(combinationHelper(p + ch, np.substring(1)));
			}
		}
		return list;
	}
}
