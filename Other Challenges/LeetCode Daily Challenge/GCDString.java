package Daily_Challenge;

public class GCDString {
	public static void main(String[] args) {
		String s1 = "ABABAB";
		String s2 = "ABAB";
//		String s1 = "LEET";
//		String s2 = "CODE";
		System.out.println(gcdOfStrings(s1, s2));
	}

	public static String gcdOfStrings(String str1, String str2) {
		if (str2.length() > str1.length()) {
			return gcdOfStrings(str2, str1);
		}
		if (str2.equals(str1)) {
			return str1;
		}
		if (str1.startsWith(str2)) {
			return gcdOfStrings(str1.substring(str2.length()), str2);
		}
		return "";
	}
}
