public class LargestOddNumber {
    public static void main(String[] args) {
        String num = "463236";
        System.out.println(largestOddNumber(num));
    }

    static String largestOddNumber(String num) {
        int n = num.length() - 1;
        String result = "";
        while (n >= 0) {
            String temp = Character.toString(num.charAt(n));
            int numStr = Integer.parseInt(temp);
            if (numStr % 2 != 0) {
                result = num.substring(0, n + 1);
                break;
            }
            n--;
        }
        return result;
    }
}
