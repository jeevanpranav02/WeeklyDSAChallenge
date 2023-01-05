package ToDo;

public class PalindromeFormation {
    public static void main(String[] args) {
        String s1 = "ulacfd";
        String s2 = "jizalu";
        System.out.println(checkPalindromeFormation(s1, s2));
    }

    static boolean checkPalindromeFormation(String a, String b) {
        return check(a, b) || check(b, a);
    }

    static boolean check(String a, String b) {
        int left = 0, right = a.length() - 1;
        while (left < right && a.charAt(left) == b.charAt(right)) {
            left++;
            right--;
        }
        if (left >= right) return true;
        return palindromeCheck(a, left, right) || palindromeCheck(b, left, right);
    }

    static boolean palindromeCheck(String s, int left, int right) {
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
