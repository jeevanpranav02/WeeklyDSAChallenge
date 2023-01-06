package Day_1;

public class PowerOfTwo {
    public static void main(String[] args) {
        int n = -16;
        System.out.println(isPowerOfTwo(n));
    }

    private static boolean isPowerOfTwo(int n) {
        int count = 0;
        if(n < 0) {
            return false;
        }
        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>= 1;
        }
        return count == 1 ? true : false;
    }
}
