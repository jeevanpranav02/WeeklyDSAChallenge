
public class ShuffleString {
    public static void main(String[] args) {
        int indices[] = { 4, 5, 6, 7, 0, 2, 1, 3 };
        String s = "codeleet";
        System.out.println(restoreString(s, indices));
    }

    static String restoreString(String s, int[] indices) {
        char[] charArray = new char[s.length()];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indices.length; i++) {
            charArray[indices[i]] = s.charAt(i);
        }
        for (int i = 0; i < indices.length; i++) {
            sb.append(charArray[i]);
        }

        return sb.toString();
    }
}