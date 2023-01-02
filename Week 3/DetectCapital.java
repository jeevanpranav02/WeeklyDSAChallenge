public class DetectCapital {
    public static void main(String[] args) {
        String s = "Google";
        String s2 = "leetcode";
        System.out.println(detectCapitalUse(s));
        System.out.println(detectCapitalUse(s2));
    }

    static boolean detectCapitalUse(String word) {
        int numUpperCase = 0;
        int numLowerCase = 0;

        for (int i = 0; i < word.length(); i++) {

            int x = word.charAt(i);

            if (x >= 'A' && x <= 'Z') {
                numUpperCase++;
            }

            else {
                numLowerCase++;
            }
            System.out.println(x);

        }

        if (numUpperCase == word.length() || numLowerCase == word.length()) {
            return true;
        }

        else if (numUpperCase == 1) {
            if (word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') {
                return true;
            }
        }
        return false;
    }
}