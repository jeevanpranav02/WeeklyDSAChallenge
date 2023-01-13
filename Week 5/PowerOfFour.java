package Day_1;

public class PowerOfFour {
    public static void main(String[] args) {
        int n = Integer.SIZE;
        System.out.println(isPowerOfFour(n));
    }

    static boolean isPowerOfFour(int n) {
        if (n == 1) {
            return true;
        }
        if (n == 0) {
            return false;
        }
        if (n % 4 != 0) {
            return false;
        }
        return isPowerOfFour(n / 4);
    }
}
