package Day_2;

public class ATOI {
	public static void main(String[] args) {
		String n = "123";
		System.out.println(atoi(n));
	}

	static int atoi(String str) {
		boolean negative = false;
		int index = 0;
		int ans = 0;
		if (str.charAt(0) == '-') {
			negative = true;
			index++;
		}
		ans = helperFunction(str, index, ans);
		if (negative) {
			if (ans < 0) {
				return ans;
			}
			return ans * -1;
		}
		return ans;
	}

	static int helperFunction(String s, int index, int ans) {
		if (index == s.length()) {
			return ans;
		}
		if (s.charAt(index) < '0' || s.charAt(index) > '9') {
			return -1;
		}
		ans = ans * 10 + (s.charAt(index) - '0');
		return helperFunction(s, index + 1, ans);
	}
}
