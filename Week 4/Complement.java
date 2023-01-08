package Day_3;

public class Complement {
    public static void main(String[] args) {
        int n = 3939;
        String ns = Integer.toBinaryString(n);
        System.out.println();
        System.out.println(findComplement(n,ns));
    }

    static int findComplement(int num,String ns) {
        int numOfBits = (int) (Math.log(num) / Math.log(2));
        for (int i = 0; i <= numOfBits; i++) {
            int powOfTwo = 1 << i;
            num = num ^ powOfTwo;
        }
        return num;
    }
}
