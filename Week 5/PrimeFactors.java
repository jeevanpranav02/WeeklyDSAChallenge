package Day_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeFactors {
    public static void main(String[] args) {
        int n = 100;
        System.out.println(Arrays.toString(AllPrimeFactors(n)));
    }

    static int[] AllPrimeFactors(int n) {
        List<Integer> list = new ArrayList<>();
        int c = 2;
        while (n > 1) {
            if (n % c == 0) {
                if (!list.contains(c)) {
                    list.add(c);
                }
                n /= c;
            } else {
                c++;
            }
        }
        int[] result = list.stream().mapToInt(i->i).toArray();
        return result;
    }
}
