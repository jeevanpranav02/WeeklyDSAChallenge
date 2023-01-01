public class DepthOfParenthesis {
    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";
        System.out.println(maxDepth(s));
    }

    static int maxDepth(String s) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                count += 1;
            if (count > max)
                max = count;
            if (s.charAt(i) == ')')
                count -= 1;
        }
        return max;
    }
}
