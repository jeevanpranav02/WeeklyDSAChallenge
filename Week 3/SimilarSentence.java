public class SimilarSentence {
    public static void main(String[] args) {
        String sent1 = "My name is Haley";
        String sent2 = "My Haley";
        System.out.println(areSentencesSimilar(sent1, sent2));
    }

    static boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (sentence1.length() == sentence2.length()) {
            if (sentence1.equals(sentence2)) {
                return true;
            } else {
                return false;
            }
        }

        String[] arr1 = sentence1.split("\s+");
        String[] arr2 = sentence2.split("\s+");

        int n1 = arr1.length;
        int n2 = arr2.length;

        int left1 = 0, left2 = 0;
        int right1 = n1 - 1, right2 = n2 - 1;

        while (n1 != 0 && n2 != 0 && arr1[left1].equals(arr2[left2])) {
            n1--;
            n2--;
            left1++;
            left2++;
        }

        while (n1 != 0 && n2 != 0 && arr1[right1].equals(arr2[right2])) {
            n1--;
            n2--;
            right1--;
            right2--;
        }

        return n1 == 0 || n2 == 0;
    }
}
