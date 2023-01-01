public class MergeAlternateCharactersOfStrings {
    public static void main(String[] args) {
        String word1 = "abc", word2 = "pqr";
        System.out.println(mergeAlternately(word1, word2));
    }

    static String mergeAlternately(String word1, String word2) {
        int i = 0, j = 0;

        StringBuilder builder = new StringBuilder();

        while (i < word1.length() || j < word2.length()) {

            if (i < word1.length()) {
                builder.append(word1.charAt(i));
                i++;
            }

            if (j < word2.length()) {
                builder.append(word2.charAt(j));
                j++;
            }
        }
        return builder.toString();
    }
}
