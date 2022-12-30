public class CheckStringHalfsAreAlike {
    public static void main(String[] args) {
        String str = "textbook";
        System.out.println(halvesAreAlike(str));
    }

    static boolean halvesAreAlike(String s) {
        int n = s.length();
        int mid = n / 2;
        String vowels = "aeiouAEIOU";
        String firstHalf = s.substring(0, mid);
        String secondHalf = s.substring( mid, n );
        int firstCount = 0;
        int secondCount = 0;
        for(int i = 0; i < mid; i++)
        {
            String firstChar = Character.toString(firstHalf.charAt(i));
            String secondChar = Character.toString(secondHalf.charAt(i));
            if(vowels.contains(firstChar))
            {
                firstCount += 1;
            }
            if(vowels.contains(secondChar))
            {
                secondCount += 1;
            }
        }
        if(firstCount == secondCount) return true;
        return false;
    }
}