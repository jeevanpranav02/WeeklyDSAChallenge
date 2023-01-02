public class NextGreaterElementIII {
    public static void main(String[] args) {
        int n = 2147483486;
        int n2 = 2147483476;
        System.out.println(nextGreaterElement(n));
        System.out.println(nextGreaterElement(n2));
    }

    static int nextGreaterElement(int n) {
        char[] arr = Integer.toString(n).toCharArray();

        // Finding change in trend last of arr
        int right = arr.length - 1;
        while (right > 0 && arr[right] <= arr[right - 1]) {
            right--;
        }
        if (right == 0) {
            return -1;
        }
        right--;

        // Finding change trend from the previous break in trend to the Change
        int left = arr.length - 1;
        while (arr[left] <= arr[right]) {
            left--;
        }

        // Swaping the values of right and left
        swap(arr, right, left);

        // Reversing the terms from the left pointer value
        reverse(arr, right + 1);

        long result = Long.parseLong(String.valueOf(arr));
        if (result <= Integer.MAX_VALUE) {
            return (int) result;
        } else {
            return -1;
        }
    }

    static void swap(char[] arr, int right, int left) {
        arr[right] ^= arr[left];
        arr[left] ^= arr[right];
        arr[right] ^= arr[left];
    }

    static void reverse(char[] arr, int l) {
        int h = arr.length - 1;
        while (l < h) {
            swap(arr, l++, h--);
        }
    }
}
