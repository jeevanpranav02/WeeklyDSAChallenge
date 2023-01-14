package Day_2;

import java.util.ArrayList;
import java.util.List;

public class SieveFactorization {
    public static void main(String[] args) {
        int n = 1312312;
        System.out.println(findPrimeFactors(n));
    }

    static List<Integer> findPrimeFactors(int n) {
        boolean[] primeCheck = new boolean[n + 1];
        sieve(primeCheck, n);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            while (!primeCheck[i] && n % i == 0) {
                list.add(i);
                n = n / i;
            }
        }
        return list;
    }

    static void sieve(boolean[] primeCheck, int n) {
        for (int i = 2; i * i <= n; i++) {
            if (!primeCheck[i]) {
                for (int j = i * i; j <= n; j += i) {
                    primeCheck[j] = true;
                }
            }
        }
    }
}
