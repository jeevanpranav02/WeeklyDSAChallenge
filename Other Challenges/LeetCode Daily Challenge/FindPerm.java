package Daily_Challenges;

public class FindPerm {

	public static void main(String[] args) {
		String s1 = "ab";
		String s2 = "eidboaooo";
		System.out.println(checkInclusion(s1, s2));
	}
	
	public static boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        StringBuilder revStr1 = new StringBuilder();
        revStr1.append(s1);
        revStr1.reverse();
        for(int i = 0; i < s2.length(); i++) {
            if(i + n < s2.length() && (checkPerm(s1,s2.substring(i,i + n)) || checkPerm(revStr1.toString(),s2.substring(i,i + n)))) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkPerm(String s1, String s2) {
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

}
