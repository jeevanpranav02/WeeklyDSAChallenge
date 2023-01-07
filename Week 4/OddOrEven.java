package Day_2;

public class OddOrEven {
    public static void main(String[] args) {
        int N = 120;
        System.out.println(oddEven(N));
    }
    static String oddEven(int N){
        if((N & 1) == 1){
            return new String("odd");
        }
        return new String("even");
    }
}
