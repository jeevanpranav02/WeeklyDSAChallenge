package Daily_Challenges;

public class PatterMatchingUsingKMPAlgo {
    public static void main(String[] args) {
        String haystack = "sadbutsad";
        String needle = "sad";
        System.out.println(strStr(haystack,needle));
    }
    public static int strStr(String haystack, String needle) {
        if(haystack.equals(needle)) {
            return 0;
        }
        int index = -1;
        int m = needle.length();
        int n = haystack.length();
        int lps[] = new int[m];
        int j = 0;
        computeLPSArray(needle, m, lps);

        int i = 0;
        while ((n - i) >= (m - j)) {
            if (needle.charAt(j) == haystack.charAt(i)) {
                j++;
                i++;
            }
            if (j == m) {
                index = i - j;
                j = lps[j - 1];
                break;
            } else if (i < n && needle.charAt(j) != haystack.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i = i + 1;
                }
            }
        }
        return index;
    }
    private static void computeLPSArray(String needle, int m, int lps[]) {
        int len = 0;
        int i = 1;
        lps[0] = 0;
        while (i < m) {
            if (needle.charAt(i) == needle.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
}
