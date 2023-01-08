package Day_3;

public class NumberOfone {
    public static void main(String[] args) {
        int n = 0b00000010100101000001111010011100;
        System.out.println(hammingWeight(n));
    }
    static int hammingWeight(int n) {
        int count = 0;
        for(int i = 0; i < 32; i++) {
            if((n & 1) == 1) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }
}
