package Day_6;

import java.util.Arrays;

public class DecodeXORArray {
    public static void main(String[] args) {
        int encoded[] = {6, 2, 7, 3};
        int first = 4;
        System.out.println(Arrays.toString(decode(encoded, first)));
    }

    static int[] decode(int[] encoded, int first) {
        int[] decoded = new int[encoded.length + 1];
        decoded[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            decoded[i + 1] = decoded[i] ^ encoded[i];
        }
        return decoded;
    }
}
