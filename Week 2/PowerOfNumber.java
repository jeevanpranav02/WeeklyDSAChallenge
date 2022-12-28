public class PowerOfNumber {
    public static void main(String[] args) {
        double x = 2;
        int n = -2147483648;
        double ans = myPow(x, n);
        System.out.println(ans);
    }

    static double myPow(double x, int n) {
        double res = 1;
        double tempN = n;
        boolean isNEven = n % 2 == 0;
        n = n < 0 ? Math.abs(n) : n;
        if (n == 0)
            return res;
        if (n == Integer.MIN_VALUE) {
            n = Integer.MAX_VALUE;
        }
        while (n > 0) {
            if ((n & 1) == 1) {
                res = res * x;
            }
            x = x * x;
            n >>= 1;
        }

        if (tempN < 0 && isNEven)
            return Math.abs(1 / res);
        if (tempN < 0 && !isNEven)
            return 1 / res;
        return res;
    }
}