package Day_3;

public class CountXORBits {
    public static void main(String[] args) {
        int x = 912731;
        int y = 8383;
        System.out.println(hammingDistance(x,y));
    }

    static int hammingDistance(int x, int y) {
        int result = 0;
        int XOR = x ^ y;
        while (XOR != 0) {
            if ((XOR & 1) == 1)
                result++;
            XOR = XOR >> 1;
        }
        return result;
    }
}
