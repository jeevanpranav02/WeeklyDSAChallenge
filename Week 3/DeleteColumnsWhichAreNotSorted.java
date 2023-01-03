public class DeleteColumnsWhichAreNotSorted {
    public static void main(String[] args) {
        String[] strs = {};
        System.out.println(minDeletionSize(strs));
    }

    static int minDeletionSize(String[] strs) {
        int count = 0;
        int n = strs.length;
        int len = strs[0].length();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (strs[j].charAt(i) > strs[j + 1].charAt(i)) {
                    count += 1;
                    break;
                }
            }
        }
        return count;
    }
}