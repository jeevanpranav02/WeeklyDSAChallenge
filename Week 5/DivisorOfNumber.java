package Day_2;

public class DivisorOfNumber {
    public static void main(String[] args) {
        int n = 322341;
        print_divisors(n);
    }

    static void print_divisors(int n) {
        if (n == 0) {
            return;
        }
        int i;
        for (i = 1; i * i < n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }
        if (i - (n / i) == 1) {
            i--;
        }
        for (; i >= 1; i--) {
            if (n % i == 0) {
                System.out.print(n / i + " ");
            }
        }
    }
}
