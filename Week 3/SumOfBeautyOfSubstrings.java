import java.util.Arrays;

public class SumOfBeautyOfSubstrings {
    public static void main(String[] args) {
        String s = "aabcbaa";
        System.out.println(beautySum(s));
    }

    static int beautySum(String s) {
        int sum = 0;
        int count[] = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            Arrays.fill(count, 0);
            int maxFreq = 0, minFreq = 0;

            for (int j = i; j < s.length(); ++j) {

                int idx = s.charAt(j) - 'a';
                maxFreq = Math.max(maxFreq, ++count[idx]);

                if (minFreq >= count[idx] - 1) {
                    minFreq = count[idx];

                    for (int k = 0; k < 26; ++k) {
                        minFreq = Math.min(minFreq, count[k] == 0 ? Integer.MAX_VALUE : count[k]);
                    }
                }
                sum += maxFreq - minFreq;
            }
        }
        return sum;
    }
}
