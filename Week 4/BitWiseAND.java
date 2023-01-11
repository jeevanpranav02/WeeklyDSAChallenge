package Day_6;

public class BitWiseAND {
    public static void main(String[] args) {
        int left = 6;
        int right = 10;
        System.out.println(rangeBitwiseAnd(left, right));
    }

    static int rangeBitwiseAnd(int left, int right) {
        int ans = 0;
        while (left != right) {
            left >>= 1;
            right >>= 1;
            ans += 1;
        }
        return left <<= ans;
    }
}
