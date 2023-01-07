package Day_2;

public class BitManipulation {
    public static void main(String[] args) {
        int num = 459582597;
        int i = 33;
        bitManipulation(num, i);
    }

    private static void bitManipulation(int num, int i) {
        System.out.print(((num & 1L << i - 1) >> i - 1 ) + " ");
        System.out.print((num | 1L << i - 1) + " ");
        System.out.print((num & (~(1L << i - 1))) + " ");
    }
}
