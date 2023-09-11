package Daily_Challenge.GFG;

public class StringMirror {
    public static void main(String[] args) {
        String test1 = "abdcba";
        String test2 = "aba";
        String result1 = stringMirror(test1);
        String result2 = stringMirror(test2);
        System.out.println("Input : " + test1 + "; Result : " + result1);
        System.out.println("Input : " + test2 + "; Result : " + result2);
    }

    public static String stringMirror(String str) {
        int index = 0;
        if (str.length() == 1 || str.charAt(0) == str.charAt(1)) {
            return str.charAt(0) + str.substring(0, 1);
        }

        while (index < str.length() - 1 && str.charAt(index + 1) <= str.charAt(index)) {
            index++;
        }

        String firstHalf = str.substring(0, index + 1);
        String secondHalf = "";

        for (int i = 0; i < firstHalf.length(); i++) {
            secondHalf = firstHalf.charAt(i) + secondHalf;
        }

        return firstHalf + secondHalf;
    }
}
