package Day_2;

public class FindSetBits {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(countSetBits(n));
    }

    private static int countSetBits(int n) {
        n++;
        int count = n / 2;
        int powerOfTwo = 2;
        while (n >= powerOfTwo) {
            int numOfPairs = n / powerOfTwo;
            count += (numOfPairs / 2) * powerOfTwo;

            if ((numOfPairs & 1) != 0) {
                count += n % powerOfTwo;
            }
            powerOfTwo = powerOfTwo << 1;
        }
        return count;
    }
}
