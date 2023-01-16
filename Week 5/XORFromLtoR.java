package Day_4;

public class XORFromLtoR {
    public static void main(String[] args) {
        int l = 4;
        int r = 8;
        System.out.println(findXOR(l, r));
    }

    static int findXOR(int l, int r) {
        return XOR(l - 1) ^ XOR(r);
    }

    public static int XOR(int n) {
        if (n % 4 == 0) {
            return n;
        } else if (n % 4 == 1) {
            return (1);
        } else if (n % 4 == 2) {
            return (n + 1);
        } else {
            return 0;
        }
    }
}
