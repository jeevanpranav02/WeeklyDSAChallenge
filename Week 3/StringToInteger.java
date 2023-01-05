package ToDo;

public class StringToInteger {
    public static void main(String[] args) {
        String s = "   -42";
        System.out.println(myAtoi(s));
    }

    static int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }

        int i = 0;

        // Checking for sign
        int sign = 1;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = s.charAt(i) == '+' ? 1 : -1;
            i++;
        }

        int num = 0;

        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            num = num * 10 + digit;
            i++;
        }

        return sign * num;
    }
}
