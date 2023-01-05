package ToDo;

public class ValidNumber {
    public static void main(String[] args) {
        String s = "+-53.5e-.93";
        System.out.println(isNumber(s));
    }

    static boolean isNumber(String s) {
        return isDecimal(s) || isInteger(s);
    }

    static boolean isDecimal(String s) {
        String regex = "^[+-]?(\\d+)?\\.?(\\d+)([eE][+-]?\\d{1,})?$";
        String regex2 = "^[+-]?(\\d+)\\.?(\\d+)?([eE][+-]?\\d{1,})?$";
        return (s.replaceAll(regex, "").length() == 0) || s.replaceAll(regex2, "").length() == 0;
    }

    static boolean isInteger(String s) {
        String regex = "^[+-]?\\d{1,}$";
        return s.replaceAll(regex, "").length() == 0;
    }
}
