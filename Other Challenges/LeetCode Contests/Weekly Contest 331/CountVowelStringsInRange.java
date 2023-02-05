package Weekly_Contest_331;

public class CountVowelStringsInRange {

	public static void main(String[] args) {
		String[] wordStrings = { "aba", "bcb", "ece", "aa", "e" };
		int[][] range = { { 0, 2 }, { 1, 4 }, { 1, 1 } };
		System.out.println(vowelStrings(wordStrings, range));
	}

	public static int[] vowelStrings(String[] words, int[][] queries) {
		int n = words.length;
		int[] prefixSumofVowels = new int[n + 1];
		for (int i = 0; i < n; i++) {
			if (isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(words[i].length() - 1))) {
				prefixSumofVowels[i + 1] = prefixSumofVowels[i] + 1;
			} else {
				prefixSumofVowels[i + 1] = prefixSumofVowels[i];
			}
		}
		int queriesLength = queries.length;
		int[] countResult = new int[queriesLength];
		for (int i = 0; i < queriesLength; i++) {
			countResult[i] = prefixSumofVowels[queries[i][1] + 1] - prefixSumofVowels[queries[i][0]];
		}
		return countResult;
	}

	private static boolean isVowel(char chars) {
		if (chars == 'a' || chars == 'e' || chars == 'i' || chars == 'o' || chars == 'u') {
			return true;
		}
		return false;
	}
}
