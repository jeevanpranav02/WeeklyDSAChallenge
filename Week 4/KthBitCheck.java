package Day_2;

public class KthBitCheck {
    public static void main(String[] args) {
        int n = 4;
        int k = 0;
        System.out.println(checkKthBit(n,k));
    }

    private static boolean checkKthBit(int n, int k) {
        if(((n >> k) & 1) > 0) {
            return true;
        }
        return false;
    }
}
