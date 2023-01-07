package Day_2;

public class SetRightMostBit {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(setBit(n));
    }

    static int setBit(int n) {
        if ((n & (n + 1)) == 0) {
            return n;
        }
        return (n | (n + 1));
    }
}
