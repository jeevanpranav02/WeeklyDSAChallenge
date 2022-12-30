public class ReverseStringInSentence {
    public static void main(String[] args) {
        String s = "  hello world  ";
        System.out.println(reverseWords(s));
    }

    static String reverseWords(String s) {
        if (s.length() < 2 && s.equals(" ")) {
            return "";
        }
        if (s.length() < 2 && !s.equals(" ")) {
            return s;
        }
        String result = "";
        String[] stringList = s.split("\\s+");
        for (int i = stringList.length - 1; i >= 0; i--) {
            if (!stringList[i].equals("")) {
                result += stringList[i] + " ";
            }
        }
        return result.trim();
    }
}
