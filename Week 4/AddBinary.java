package Day_1;

import java.math.BigInteger;

public class AddBinary {
    public static void main(String[] args) {
        String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
        String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
        System.out.println(addBinary(a,b));
    }

    private static String addBinary(String a, String b) {
        if(a == null || b == null)
        {
            return a == null ? b : a;
        }
        String result = "";
        BigInteger a1 = new BigInteger(a,2);
        BigInteger b1 = new BigInteger(b,2);
        result = (a1.add(b1)).toString(2);
        return result;
    }
}
