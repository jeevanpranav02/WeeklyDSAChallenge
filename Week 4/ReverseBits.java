package Day_3;

public class ReverseBits {
    public static void main(String[] args) {
        int n = 0b00000010100101000001111010011100;
        System.out.println(reverseBits(n));
    }

    static int reverseBits(int n) {
        int reverse = 0;
        for(int i = 0; i < 32; i++) {
            reverse <<= 1;
            reverse += (n & 1);
            n >>= 1;
        }
        return reverse;
    }
}
